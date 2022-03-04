# **LLVM Language Reference Manual**

> LLVM Language Reference Manual: https://llvm.org/docs/LangRef.html

|时间|内容|
|:---|:---|
|2022-03-04| kick off. |

- [Instruction Reference](llvm-lang-ref-instructions.md)

## 术语

- pass: 趟, 例verification pass
- module: 模块
- parser: 解析器

## Abstract

## Introduction
### Well-Formedness

LLVM基础设施提供了一个验证趟(verification pass), 用于验证LLVM模块(module)是否是格式良好的(well formed).

这个趟在解析器解析完输入的汇编后以及在优化器输出bitcode之前被自动运行.

## Identifiers

LLVM的标识符有两类:

- 全局的(global): 以`@`开始, 例如函数、全局变量;
- 局部的(local): 以`%`开始, 例如寄存器名称、类型.

3种标识符格式:

1. 命名的值(named values): `[%@][-a-zA-Z$._][-a-zA-Z$._0-9]*`, 用引号`""`来包含其他字符, 例如`%foo`、`@DivisionByZero`、`%a.really.long.identifier`、`"\01"`.
2. 未命名的值(unnamed values): 用前缀带无符号数值表示, 例如`%12`、`@2`、`%44`.
3. 常量(constants): 在下面的**Constants**一节描述.

例: 将整数变量`%x`乘以8

``` llvm
%result = mul i32 %X, 8

; after strength reducton
%result = shl i32 %X, 3

; the hard way
%0 = add i32 %X, %X       ; yields i32:%0
%1 = add i32 %0, %0       ; yields i32:%1
%result = add i32 %1, %1
```

- 行注释以`;`开始,
- 计算的结果未赋值给命名的值时, 创建未命名的临时值,
- 未命名的临时值中数值依次递增: 使用每个函数的计数值(从0开始).

## High Level Structure
### Module Structure

LLVM程序由模块(module)构成, 每个模块是输入程序的一个翻译单元(translation unit).

模块由函数、全局变量和符号表项(symbol table entries)构成.

多个模块可以被LLVM链接器(linker)组合在一起, 即合并函数和全局变量定义、解析前向声明(forward declarations)以及合并符号表项.


例: hello word模块

``` llvm
; Declare the string constant as a global constant.
@.str = private unnamed_addr constant [13 x i8] c"hello world\0A\00"

; External declaration of the puts function
declare i32 @puts(i8* nocapture) nounwind

; Definition of main function
define i32 @main() {  ; i32()*
  ; Convert [13 x i8] to i8*...
  %cast210 = getelementptr [13 x i8], [13 x i8]* @.str, i64 0, i64 0

  ; Call puts function to write out the string to stdout.
  call i32 @puts(i8* %cast210)
  ret i32 0
}

; Named metadata
!0 = !{i32 42, null, !"string"}
!foo = !{!0}
```

### Linkage Types

所有全局变量和函数有链接类型(types of linkage):

- private
- internal
- available_externally
- linkonce
- weak
- common
- appending
- extern_weak
- linkonce_odr, weak_odr
- extenrnal

如果没有使用上面的标识符, 这个全局对象是外部可见的.

全局变量或函数声明有除了external或extern_weak之外的链接类型, 是非法的.

### Calling Conventions

LLVM函数、calls和invokes有一个可选的调用约定(calling convention).

任意一对调用者-被调用者(caller/callee)的调用约定必须匹配, 否则程序的行为是为定义的.

当前LLVM支持的调用约定:

- ccc: C调用约定
- fastcc: 快速调用约定
- coldcc: 冷调用约定
- cc 10: GHC(Glasgow Haskell Compiler)约定
- cc 11: The HiPE(High-Performance Erlang)调用约定
- webkit_jscc: WebKit JavaScript调用约定
- anyregcc: 用于代码修补(code patching)的动态调用约定
- preserve_mostcc: PreserveMost调用约定
- preserve_allcc: PreserveAll调用约定
- cxx_fast_tlscc: 用于访问函数的CXX_FAST_TLS
- tailcc: 尾部可调用的(tail callable)调用约定
- swiftcc: 用于Swift语言的调用约定
- swifttailcc
- cfguard_checkcc: Windos Control Flow Guard
- cc <n>: 数值标识的约定

### Visibility Styles

所有全局变量和函数有可见性风格(visibility styles):

- default
- hidden
- protected

有internal或private链接类型的符号必须有default可见性.

### DLL Storage Classes
### Thread Local Storage Models
### Runtime Preemption Specifiers
### Structure Types
### Non-Integral Pointer Type
### Global Variables
### Functions
### Aliases
### IFuncs
### Comdats
### Named Metadata
### Parameter Attributes
### Garbage Collector Strategy Names
### Prefix Data
### Prologue Data
### Personality Function
### Attribute Groups
### Function Attributes
### Call Site Attributes
### Global Attributes
### Operand Bundles
#### Deoptimization Operand Bundles
#### Funclet Operand Bundles
#### GC Transition Operand Bundles
#### Assume Operand Bundles
#### Preallocated Operand Bundles
#### GC Live Operand Bundles
#### ObjC ARC Attached Call Operand Bundles
#### Pointer Authentication Operand Bundles
### Module-Level Inline Assembly
### Data Layout
### Target Triple
### Object Lifetime
### Pointer Aliasing Rules
### Pointer Capture
### Volatile Memory Accesses
### Memory Model for Concurrent Operations
### Atomic Memory Ordering Constraints
### Floating-Point Environment
### Fast-Math Flags
### Use-list Order Directives
### Source Filename

## Type System
### Void Type
### Function Type
### First Class Types
#### Single Value Types
##### Integer Type
##### Floating-Point Types
##### X86_amx Type
##### X86_mmx Type
##### Pointer Type
##### Vector Type
#### Label Type
#### Token Type
#### Metadata Type
#### Aggregate Types
##### Array Type
##### Structure Type
##### Opaque Structure Types

## Constants
### Simple Constants
### Complex Constants
### Global Variable and Function Addresses
### Undefined Values
### Poison Values
### Well-Defined Values
### Addresses of Basic Blocks
### DSO Local Equivalent
### No CFI
### Constant Expressions

## Other Values
### Inline Assembler Expressions
#### Inline Asm Constraint String
##### Output constraints
##### Input constraints
##### Indirect inputs and outputs
##### Clobber constraints
##### Constraint Codes
##### Supported Constraint Code List
#### Asm template argument modifiers
#### Inline Asm Metadata

## Metadata
### Metadata Nodes and Metadata Strings
#### Specialized Metadata Nodes
##### DICompileUnit
##### DIFile
##### DIBasicType
##### DISubroutineType
##### DIDerivedType
##### DICompositeType
##### DISubrange
##### DIEnumerator
##### DITemplateTypeParameter
##### DITemplateValueParameter
##### DINamespace
##### DIGlobalVariable
##### DIGlobalVariableExpression
##### DISubprogram
##### DILexicalBlock
##### DILexicalBlockFile
##### DILocation
##### DILocalVariable
##### DIExpression
##### DIArgList
##### DIFlags
##### DIObjCProperty
##### DIImportedEntity
##### DIMacro
##### DIMacroFile
##### DILabel
#### ‘tbaa’ Metadata
##### Semantics
##### Representation
#### ‘tbaa.struct’ Metadata
#### ‘noalias’ and ‘alias.scope’ Metadata
#### ‘fpmath’ Metadata
#### ‘range’ Metadata
#### ‘absolute_symbol’ Metadata
#### ‘callees’ Metadata
#### ‘callback’ Metadata
#### ‘unpredictable’ Metadata
#### ‘dereferenceable’ Metadata
#### ‘dereferenceable_or_null’ Metadata
#### ‘llvm.loop’
#### ‘llvm.loop.disable_nonforced’
#### ‘llvm.loop.vectorize’ and ‘llvm.loop.interleave’
#### ‘llvm.loop.interleave.count’ Metadata
#### ‘llvm.loop.vectorize.enable’ Metadata
#### ‘llvm.loop.vectorize.predicate.enable’ Metadata
#### ‘llvm.loop.vectorize.scalable.enable’ Metadata
#### ‘llvm.loop.vectorize.width’ Metadata
#### ‘llvm.loop.vectorize.followup_vectorized’ Metadata
#### ‘llvm.loop.vectorize.followup_epilogue’ Metadata
#### ‘llvm.loop.vectorize.followup_all’ Metadata
#### ‘llvm.loop.unroll’
#### ‘llvm.loop.unroll.count’ Metadata
#### ‘llvm.loop.unroll.disable’ Metadata
#### ‘llvm.loop.unroll.runtime.disable’ Metadata
#### ‘llvm.loop.unroll.enable’ Metadata
#### ‘llvm.loop.unroll.full’ Metadata
#### ‘llvm.loop.unroll.followup’ Metadata
#### ‘llvm.loop.unroll.followup_remainder’ Metadata
#### ‘llvm.loop.unroll_and_jam’
#### ‘llvm.loop.unroll_and_jam.count’ Metadata
#### ‘llvm.loop.unroll_and_jam.disable’ Metadata
#### ‘llvm.loop.unroll_and_jam.enable’ Metadata
#### ‘llvm.loop.unroll_and_jam.followup_outer’ Metadata
#### ‘llvm.loop.unroll_and_jam.followup_inner’ Metadata
#### ‘llvm.loop.unroll_and_jam.followup_remainder_outer’ Metadata
#### ‘llvm.loop.unroll_and_jam.followup_remainder_inner’ Metadata
#### ‘llvm.loop.unroll_and_jam.followup_all’ Metadata
#### ‘llvm.loop.licm_versioning.disable’ Metadata
#### ‘llvm.loop.distribute.enable’ Metadata
#### ‘llvm.loop.distribute.followup_coincident’ Metadata
#### ‘llvm.loop.distribute.followup_sequential’ Metadata
#### ‘llvm.loop.distribute.followup_fallback’ Metadata
#### ‘llvm.loop.distribute.followup_all’ Metadata
#### ‘llvm.licm.disable’ Metadata
#### ‘llvm.access.group’ Metadata
#### ‘llvm.loop.parallel_accesses’ Metadata
#### ‘llvm.loop.mustprogress’ Metadata
#### ‘irr_loop’ Metadata
#### ‘invariant.group’ Metadata
#### ‘type’ Metadata
#### ‘associated’ Metadata
#### ‘prof’ Metadata
##### branch_weights
##### function_entry_count
##### VP
#### ‘annotation’ Metadata

## Module Flags Metadata
### Synthesized Functions Module Flags Metadata
### Objective-C Garbage Collection Module Flags Metadata
### C type width Module Flags Metadata
### LTO Post-Link Module Flags Metadata

## Automatic Linker Flags Named Metadata

## Dependent Libs Named Metadata

## ThinLTO Summary
### Module Path Summary Entry
### Global Value Summary Entry
#### Function Summary
#### Global Variable Summary
#### Alias Summary
#### Function Flags
#### Calls
#### Params
#### Refs
#### TypeIdInfo
##### TypeTests
##### TypeTestAssumeVCalls
##### TypeCheckedLoadVCalls
##### TypeTestAssumeConstVCalls
##### TypeCheckedLoadConstVCalls
### Type ID Summary Entry

## Intrinsic Global Variables
### The ‘llvm.used’ Global Variable
### The ‘llvm.compiler.used’ Global Variable
### The ‘llvm.global_ctors’ Global Variable
### The ‘llvm.global_dtors’ Global Variable
