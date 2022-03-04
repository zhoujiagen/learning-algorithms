# Notes of **Getting Started with LLVM Core Libraries**


|时间|内容|
|:---|:---|
|2021-08-18| kick off. |
|2022-03-04| update: LLVM IR information in Chapter 5. |

## 术语

<!-- 记录阅读过程中出现的关键字及其简单的解释. -->

## 介绍

<!-- 描述书籍阐述观点的来源、拟解决的关键性问题和采用的方法论等. -->

## 动机

<!-- 描述阅读书籍的动机, 要达到什么目的等. -->

## 概念结构

<!-- 描述书籍的行文结构, 核心主题和子主题的内容结构和关系. -->

### 1. Build and Install LLVM

### 2. External Projects

### 3. Tools and Design

- **clang**
- **opt**: optimize a program at the IR level
- **llc**: convert LLVM bitcode to a target-machine assembly language file or object file via a specific backend
- **llvm-mc**: assemble instructions and generate object files(ELF, PE, MachO), disassemble the same objects
- **lli**: an interpreter and a JIT compiler for LLVM IR
- **llvm-link**: link several LLVM bitcodes to produce a single LLVM bitcode
- **llvm-as**: transform LLVM IR file(human-readable LLVM assemblies) into LLVM bitcodes, `*.ll` => `*.bc`
- **llvm-dis**: decode LLVM bitcodes into LLVM assemblies, `*.bc` => `*.ll`
- **llvm-config**: print LLVM compilation options

LLVM basic libraries:

> https://releases.llvm.org/3.0/docs/UsingLibraries.html

- **libLLVMCore**: 提供了LLVM IR相关的逻辑, 包括IR构造(数据布局、指令、基本块和函数)、IR验证器(verifier)和趟管理器(pass manager).
- **libLLVMAnalysis**: 包含几个IR分析趟(alias analysis, dependence analysis, constant folding, loop info, memory dependence analysis, instruction simplify).
- **libLLVMCodeGen**: 实现了独立于目标的代码生成和机器级别的分析和转换.
- **libLLVMTarget**: 通过通用的目标抽象提供了访问目标机器信息的功能.
- **libLLVMX86CodeGen**: 包含构成x86后段的目标代码生成信息、转换和分析趟.
- **libLLVMSupport**: 一组工具，包括错误、整数和浮点数处理、命令行解析、调试、文件支持、字符串处理等.
- **libclang**: 实现了访问Clang前端功能的C接口, 这些功能包括诊断报告、AST遍历、代码补全、游标映射和源代码.
- **libclangDriver**: 包含了一组类， 被编译器驱动器工具用于理解类GCC命令行参数并为外部工具准备作业和组织恰当的参数， 以支持编译的不同步骤.
- **libclangAnalysis**: 由Clang提供的一组前端层级的分析，包括CFG和调用图构造、可达代码等.

### 4. The Frontend

meanings of Clang:

- the frontend: Clang libraries
- the compiler driver: `clang` command, the Clang Driver library
- the actual compiler: `clang -cc1` command

> $ sudo apt-get install libclang-dev

Currently, clang is divided into the following libraries and tool:

> https://clang.llvm.org/features.html

- **libsupport**: Basic support library, from LLVM.
- **libsystem**: System abstraction library, from LLVM.
- **libbasic**: Diagnostics, SourceLocations, SourceBuffer abstraction, file system caching for input source files.
- **libast**: Provides classes to represent the C AST, the C type system, builtin functions, and various helpers for analyzing and manipulating the AST (visitors, pretty printers, etc).
- **liblex**: Lexing and preprocessing, identifier hash table, pragma handling, tokens, and macro expansion.
- **libparse**: Parsing. This library invokes coarse-grained 'Actions' provided by the client (e.g. libsema builds ASTs) but knows nothing about ASTs or other client-specific data structures.
- **libsema**: Semantic Analysis. This provides a set of parser actions to build a standardized AST for programs.
- **libcodegen**: Lower the AST to LLVM IR for optimization & code generation.
- **librewrite**: Editing of text buffers (important for code rewriting transformation, like refactoring).
- **libanalysis**: Static analysis support.
- **clang**: A driver program, client of the libraries at various levels.


Usage of Clang:

- diagnostic
- lexical analysis
- syntactic analysis
- semantic analysis
- generate LLVM IR

```
extern "C"
{
  #include "clang-c/Index.h"
}

CXTranslationUnit

CXDiagnostic

CXToken
enum CXTokenKind

Decl: TranslationUnitDecl, FunctionDecl, VarDecl
Stmt: IfStmt
Type
```


### 5. The LLVM Intermediate Representation

> The LLVM Intermediate Representation (IR) is the backbone that connects frontends and backends, allowing LLVM to parse multiple source languages and generate code to multiple targets.

#### 5.1 Overview

LLVM IR有三种等价形式:

- 内存中表示: `Instruction`类等;
- 磁盘上空间紧凑形式的表示: bitcode文件 `*.bc`;
- 磁盘上可读文本形式的表示: LLVM汇编文件 `*.ll`.

##### Understanding the LLVM IR target dependency

> The LLVM IR is designed to be as target-independent as possible, but it still conveys some target-specific aspects.

#### 5.2 Exercising basic tools to manipulate the IR formats

示例文件: `IR/sum.c`

``` c
int sum(int a, int b) {
  return a + b;
}
```

- 使用Clang生成bitcode文件: `clang sum.c -emit-llvm -c -o sum.bc`
- 使用Clang生成汇编文件: `clang sum.c -emit-llvm -S -c -o sum.ll`
- 汇编汇编文件, 生成bitcode文件: `llvm-as sum.ll -o sum.bc`
- 反汇编: `llvm-dis sum.bc -o sum.ll`
- 从IR module中提取IR functions, globals或删除globals: `llvm-extract -func=sum sum.bc -o sum-fn.bc`

#### 5.3 Introducing the LLVM IR language syntax

==组织结构==

整个文件(`*.bc`或`*.ll`)称为一个LLVM module, 每个module中包含一组function, 每个function中包含一组basic block, basic block中包含一组instruction.

module中的辅助实体: global variables, target data layout, external function prototypes, data structure declarations.

- module: `Module`
- functions: `Function`
- basic blocks(BBs): function body is explicitly divided into basic blocks, and a label is used to start a new BB. A basic block is a sequence of instructions with a single entry point at its first instruction, and a single exit point at its last instruction. `BasicBlock`
- instructions: `Instruction`
- global variable: prefixed with `@`
- local variable: the analogs of the registers in the assembly language, prefixed with `%`

fundamental properties:

- use the SSA(Static Single Assignment) form: `Value`, `User`,
- organized codes as three-address instructions,
- has an infinite number of registers.

==实体定义==

> example from Ubuntu 20.04 on Windows; clang version 10.0.0-4ubuntu1, Target: x86_64-pc-linux-gnu

- target datalayout, target tripe

target datalayout包含edianess和类型大小信息

``` llvm
; e: little-endian
; type information: type:<size>:<abi>:<preferred>
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
; processor: x86_64
target triple = "x86_64-pc-linux-gnu"
```

- types

``` llvm
i32
i64
i128
float
double

; vector types
<<# elements> x <elementtype>>
<4 x i32> ; a vector with 4 i32 elements
```

- function declaration: closely follows the C syntax

```
define dso_local i32 @sum(i32 %0, i32 %1) #0 {
```

- function attributes

`#0` tag in the function declaration maps to a set of function attributes.

``` llvm
attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
```

- basic block

> no label at the first instruction here.

``` llvm
;define dso_local i32 @sum(i32 %0, i32 %1) #0 {
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  store i32 %0, i32* %3, align 4
  store i32 %1, i32* %4, align 4
  %5 = load i32, i32* %3, align 4
  %6 = load i32, i32* %4, align 4
  %7 = add nsw i32 %5, %6
  ret i32 %7
;}
```

##### Introducing the LLVM IR in-memory model

> The header files for the C++ classes that represent the IR are located at `include/llvm/IR`.

``` c++
Module
Function
BasicBlock
Instruction
```

In the LLVM in-memory IR:

- a class that inherites from `Value` means that it defines a result that can be used by others,
- a subclass of `User` means that this entity uses one or more `Value` interfaces.

#### 5.4 Writing a custom LLVM IR generator
##### Building and running the IR generator
##### Learning how to write code to generate any IR construct with the C++ backend

Generating the C++ source code needed to generate the same IR file for a given LLVM IR file(bitcode or assembly):

> cpp target is not in llc --version.

``` console
$ llc -march=cpp sum.bc -o sum.cpp
llc: error: error: invalid target 'cpp'.
```

#### 5.5 Optimizing at the IR level
##### Compile-time and link-time optimizations
##### Discovering which passes matter
##### Understanding pass dependencies
##### Understanding the pass API
##### Writing a custom pass
##### Building and running your new pass with the LLVM build system
##### Building and running your new pass with your own Makefile
#### 5.6 Summary

### 6. The Backend


LLVM backend organization

```
|LLVM IR| -> [Passes] -> (Instrction selection)
          -> (Instruction scheduling)/(Pre-register Allocation Scheduling)
          -> [Passes] -> (Register allocation)
          -> [Passes] -> (Instruction scheduling)/(Post-register Allocation Scheduling)
          -> [Passes] -> (Code emission)
          -> <Assembly>, <Object code>

four distinct levels of instruction representation:
|LLVM IR| => |SelectionDAG| => |MachineInstr| => |MCInst|

(Instruction selection): 将内存中IR表示转换为目标特定的SelectionDAG节点. 节点通常表示指令, 边通常编码了指令之间的数据流依赖. 便于使用基于树的藐视匹配指令选择算法. 最终DAG中节点转换为目标机器指令.

(Instruction scheduling)/(Pre-register Allocation Scheduling): 将指令排序并尝试发现指令级并行. 指令被转换为MachineInstr三地址表示.

(Register allocation): 尝试将无限数量的虚拟寄存器映射到有限数量的目标特定寄存器.

(Instruction scheduling)/(Post-register Allocation Scheduling): 使用物理寄存器的信息优化指令排序.

(Code emission): 将MachineInstr三地址表示的指令转换为MCInst表示, 该表示便于汇编器和加载器处理.
```

#### backend code structure, libraries

#### TableGen: describe a backend

#### instruction selection

#### machine instructions

#### instruction scheduling

#### register allocation

#### prologure, epilogue

#### machine code framework

- MC instructions: `MCInst`
- code emission

### 7. The Just-in-Time Compiler

```
llvm::MCJIT
lli
llvm-rtdyld
```

### 8. Cross-platform Compilation

**native executables**: runs on the same platform of the compiler<br/>
**platform**: a combination of hardware, operating system, applicaiton binary interface(ABI [^1]), and system interface choices.

[^1]: ABI: https://en.wikipedia.org/wiki/Application_binary_interface

**Cross-platform compilation** is the process of using a compiler to generate executables for different, non-native platforms.

### 9. The Clang Static Analyzer

### 10. Clang Tools with LibTooling

## 总结

<!-- 概要记录书籍中如何解决关键性问题的. -->

## 应用

<!-- 记录如何使用书籍中方法论解决你自己的问题. -->

## 文献引用

<!-- 记录相关的和进一步阅读资料: 文献、网页链接等. -->

- Bruno Cardoso Lopes, Rafael Auler. **Getting Started with LLVM Core Libraries**. Packet Publishing: 2014.

## 其他备注
