# Notes of LLVM

|时间|内容|
|:---|:---|
|2021-08-18| kick off. |
|2022-02-23| update: notes of project directories. |

## 术语

<!-- 记录阅读过程中出现的关键字及其简单的解释. -->

- LLVM: Low Level Virtual Machine

## 介绍

<!-- 描述软件的来源、特性、解决的关键性问题等. -->

## 动机

<!-- 描述阅读软件源码的动机, 要达到什么目的等. -->

## 系统结构

<!-- 描述软件的系统结构, 核心和辅助组件的结构; 系统较复杂时细分展示. -->

### 子项目

```
llvm-project$ tree -L 1
.
├── CONTRIBUTING.md
├── README.md
├── SECURITY.md
├── bolt                      // BOLT is a post-link optimizer developed to speed up large applications
├── clang                     // C Language Family Front-end
├── clang-tools-extra         // Clang Tools repository
├── cmake                     // LLVM Common CMake Utils
├── compiler-rt               // compiler support routines
├── cross-project-tests       // for tests that require access to multiple projects across LLVM (e.g. clang, lld and lldb).
├── flang                     // Flang is a ground-up implementation of a Fortran front end written in modern C++
├── libc                      // llvm-libc, a retargetable implementation of the C standard library
├── libclc                    // an implementation of the OpenCL C programming language
├── libcxx                    // an implementation of the C++ standard library libc++, targeting C++11 and above
├── libcxxabi                 // libc++ abi
├── libunwind                 // an implementation of the interface defined by the HP libunwind project
├── lld                       // LLVM Linker
├── lldb                      // The LLDB Debugger
├── llvm                      // The LLVM Compiler Infrastructure
├── llvm-libgcc               // for who want to replace libgcc with compiler-rt and libunwind
├── mlir                      // Multi-Level Intermediate Representation
├── openmp                    // the LLVM OpenMP Libraries
├── polly                     // Polyhedral optimizations for LLVM
├── pstl                      // Parallel STL
├── runtimes                  // building LLVM runtime sub-projects
├── test                      // nothing
├── third-party               // benchmark: A library to benchmark code snippets, similar to unit tests
└── utils                     // clang-format.sh, Bazel build system
```

|subproject           | Description|
|:---                 |:---|
| LLVM Core           | The LLVM Core libraries provide a modern source- and target-independent optimizer, along with code generation support for many popular CPUs (as well as some less common ones!) These libraries are built around a well specified code representation known as the LLVM intermediate representation ("LLVM IR"). The LLVM Core libraries are well documented, and it is particularly easy to invent your own language (or port an existing compiler) to use LLVM as an optimizer and code generator.|
| Clang               | Clang is an "LLVM native" C/C++/Objective-C compiler, which aims to deliver amazingly fast compiles, extremely useful error and warning messages and to provide a platform for building great source level tools. The Clang Static Analyzer and clang-tidy are tools that automatically find bugs in your code, and are great examples of the sort of tools that can be built using the Clang frontend as a library to parse C/C++ code.|
| LLDB                | The LLDB project builds on libraries provided by LLVM and Clang to provide a great native debugger. It uses the Clang ASTs and expression parser, LLVM JIT, LLVM disassembler, etc so that it provides an experience that "just works". It is also blazing fast and much more memory efficient than GDB at loading symbols.|
| libc++, libc++ ABI  | The libc++ and libc++ ABI projects provide a standard conformant and high-performance implementation of the C++ Standard Library, including full support for C++11 and C++14.|
| compiler-rt         | The compiler-rt project provides highly tuned implementations of the low-level code generator support routines like "__fixunsdfdi" and other calls generated when a target doesn't have a short sequence of native instructions to implement a core IR operation. It also provides implementations of run-time libraries for dynamic testing tools such as AddressSanitizer, ThreadSanitizer, MemorySanitizer, and DataFlowSanitizer.|
| MLIR                | The MLIR subproject is a novel approach to building reusable and extensible compiler infrastructure. MLIR aims to address software fragmentation, improve compilation for heterogeneous hardware, significantly reduce the cost of building domain specific compilers, and aid in connecting existing compilers together.|
| OpenMP              | The OpenMP subproject provides an OpenMP runtime for use with the OpenMP implementation in Clang.|
| polly               | The polly project implements a suite of cache-locality optimizations as well as auto-parallelism and vectorization using a polyhedral model.|
| libclc              | The libclc project aims to implement the OpenCL standard library.|
| klee                | The klee project implements a "symbolic virtual machine" which uses a theorem prover to try to evaluate all dynamic paths through a program in an effort to find bugs and to prove properties of functions. A major feature of klee is that it can produce a testcase in the event that it detects a bug.|
| LLD                 | The LLD project is a new linker. That is a drop-in replacement for system linkers and runs much faster.|

### llvm-project/llvm

```
.
├── CMakeLists.txt
├── CODE_OWNERS.TXT
├── CREDITS.TXT
├── LICENSE.TXT
├── README.txt
├── RELEASE_TESTERS.TXT
├── benchmarks
│   ├── CMakeLists.txt
│   └── DummyYAML.cpp
├── bindings                            // provides language bindings for Go, OCaml and Python
│   ├── README.txt
│   ├── go
│   ├── ocaml
│   └── python
├── cmake
│   ├── README
│   ├── config-ix.cmake
│   ├── config.guess
│   ├── dummy.cpp
│   ├── modules                         // build configuration for llvm user defined options
│   ├── nsis_icon.ico
│   ├── nsis_logo.bmp
│   ├── platforms                       // toolchain configuration for Android NDK, iOS systems and non-Windows hosts to target MSVC
│   └── unwind.h
├── configure
├── docs
├── examples
│   ├── BrainF
│   ├── Bye
│   ├── CMakeLists.txt
│   ├── ExceptionDemo
│   ├── Fibonacci
│   ├── HowToUseJIT
│   ├── HowToUseLLJIT
│   ├── IRTransforms
│   ├── Kaleidoscope                    // Kaleidoscope language tutorial
│   ├── ModuleMaker
│   ├── OrcV2Examples
│   ├── ParallelJIT
│   └── SpeculativeJIT
├── include
│   ├── llvm                            // All LLVM-specific header files, subdirectories for different portions of LLVM: Analysis, CodeGen, etc
│   └── llvm-c                          // ???
├── lib
│   ├── Analysis                        // A variety of program analyses, such as Call Graphs, Induction Variables, Natural Loop Identification, etc
│   ├── AsmParser                       // Source code for the LLVM assembly language parser library
│   ├── BinaryFormat
│   ├── Bitcode                         // Code for reading and writing bitcode
│   ├── Bitstream
│   ├── CMakeLists.txt
│   ├── CodeGen                         // The major parts of the code generator: Instruction Selector, Instruction Scheduling, and Register Allocation
│   ├── DWARFLinker
│   ├── DWP
│   ├── DebugInfo
│   ├── Debuginfod
│   ├── Demangle
│   ├── ExecutionEngine                 // Libraries for directly executing bitcode at runtime in interpreted and JIT-compiled scenarios
│   ├── Extensions
│   ├── FileCheck
│   ├── Frontend
│   ├── FuzzMutate
│   ├── Fuzzer
│   ├── IR                              // Core LLVM source files that implement core classes like Instruction and BasicBlock
│   ├── IRReader
│   ├── InterfaceStub
│   ├── LTO
│   ├── LineEditor
│   ├── Linker
│   ├── MC                              // The libraries represent and process code at machine code level. Handles assembly and object-file emission
│   ├── MCA
│   ├── ObjCopy
│   ├── Object
│   ├── ObjectYAML
│   ├── Option
│   ├── Passes
│   ├── ProfileData
│   ├── Remarks
│   ├── Support                         // corresponding to the header files in llvm/include/ADT/ and llvm/include/Support/
│   ├── TableGen
│   ├── Target                          // Files describing target architectures for code generation
│   ├── Testing
│   ├── TextAPI
│   ├── ToolDrivers
│   ├── Transforms                      // IR-to-IR program transformations
│   ├── WindowsDriver
│   ├── WindowsManifest
│   └── XRay
├── llvm.spec.in
├── llvm.txt
├── projects                            // Projects not strictly part of LLVM but shipped with LLVM
│   └── CMakeLists.txt
├── resources
│   └── windows_version_resource.rc
├── runtimes
│   └── CMakeLists.txt
├── test                                // Feature and regression tests and other sanity checks on LLVM infrastructure
├── tools                               // Executables built out of the libraries
│   ├── CMakeLists.txt
│   ├── bugpoint                        // debug optimization passes or code generation backends by narrowing down the given test case to the minimum number of passes and/or instructions that still cause a problem, whether it is a crash or miscompilation
│   ├── bugpoint-passes
│   ├── dsymutil
│   ├── gold
│   ├── llc                             // the LLVM backend compiler, which translates LLVM bitcode to a native code assembly file
│   ├── lli                             // the LLVM interpreter, which can directly execute LLVM bitcode (slowly)
│   ├── llvm-ar                         // The archiver produces an archive containing the given LLVM bitcode files
│   ├── llvm-as                         // The assembler transforms the human readable LLVM assembly to LLVM bitcode
│   ├── llvm-as-fuzzer
│   ├── llvm-bcanalyzer
│   ├── llvm-c-test
│   ├── llvm-cat
│   ├── llvm-cfi-verify
│   ├── llvm-config
│   ├── llvm-cov
│   ├── llvm-cvtres
│   ├── llvm-cxxdump
│   ├── llvm-cxxfilt
│   ├── llvm-cxxmap
│   ├── llvm-debuginfod-find
│   ├── llvm-diff
│   ├── llvm-dis                        // The disassembler transforms the LLVM bitcode to human readable LLVM assembly
│   ├── llvm-dis-fuzzer
│   ├── llvm-dlang-demangle-fuzzer
│   ├── llvm-dwarfdump
│   ├── llvm-dwp
│   ├── llvm-exegesis
│   ├── llvm-extract
│   ├── llvm-go
│   ├── llvm-gsymutil
│   ├── llvm-ifs
│   ├── llvm-isel-fuzzer
│   ├── llvm-itanium-demangle-fuzzer
│   ├── llvm-jitlink
│   ├── llvm-jitlistener
│   ├── llvm-libtool-darwin
│   ├── llvm-link                       //  links multiple LLVM modules into a single program
│   ├── llvm-lipo
│   ├── llvm-lto
│   ├── llvm-lto2
│   ├── llvm-mc
│   ├── llvm-mc-assemble-fuzzer
│   ├── llvm-mc-disassemble-fuzzer
│   ├── llvm-mca
│   ├── llvm-microsoft-demangle-fuzzer  
│   ├── llvm-ml
│   ├── llvm-modextract
│   ├── llvm-mt
│   ├── llvm-nm
│   ├── llvm-objcopy
│   ├── llvm-objdump
│   ├── llvm-opt-fuzzer
│   ├── llvm-opt-report
│   ├── llvm-pdbutil
│   ├── llvm-profdata
│   ├── llvm-profgen
│   ├── llvm-rc
│   ├── llvm-readobj
│   ├── llvm-reduce
│   ├── llvm-remark-size-diff
│   ├── llvm-rtdyld
│   ├── llvm-rust-demangle-fuzzer
│   ├── llvm-shlib
│   ├── llvm-sim
│   ├── llvm-size
│   ├── llvm-special-case-list-fuzzer
│   ├── llvm-split
│   ├── llvm-stress
│   ├── llvm-strings
│   ├── llvm-symbolizer
│   ├── llvm-tapi-diff
│   ├── llvm-tli-checker
│   ├── llvm-undname
│   ├── llvm-xray
│   ├── llvm-yaml-numeric-parser-fuzzer
│   ├── llvm-yaml-parser-fuzzer
│   ├── lto
│   ├── msbuild
│   ├── obj2yaml
│   ├── opt                             // reads LLVM bitcode, applies a series of LLVM transformations, and outputs the resultant bitcode
│   ├── opt-viewer
│   ├── remarks-shlib
│   ├── sancov
│   ├── sanstats
│   ├── split-file
│   ├── verify-uselistorder
│   ├── vfabi-demangle-fuzzer
│   ├── xcode-toolchain
│   └── yaml2obj
├── unittests
└── utils                               // Utilities for working with LLVM source code
    ├── DSAclean.py
    ├── DSAextract.py
    ├── FileCheck
    ├── GenLibDeps.pl
    ├── GetSourceVersion
    ├── KillTheDoctor
    ├── LLVMVisualizers
    ├── Misc
    ├── PerfectShuffle
    ├── Reviewing
    ├── TableGen                        // Contains the tool used to generate register descriptions, instruction set descriptions, and even assemblers from common TableGen description files
    ├── Target
    ├── UpdateCMakeLists.pl
    ├── UpdateTestChecks
    ├── abtest.py
    ├── add_argument_names.py
    ├── bisect
    ├── bisect-skip-count
    ├── bugpoint
    ├── bugpoint_gisel_reducer.py
    ├── check-each-file
    ├── check_ninja_deps.py
    ├── chunk-print-before-all.py
    ├── clang-parse-diagnostics-file
    ├── codegen-diff                    // finds differences between code that LLC generates and code that LLI generates
    ├── collect_and_build_with_pgo.py
    ├── convert-constraint-log-to-z3.py
    ├── count
    ├── countloc.sh
    ├── create_ladder_graph.py
    ├── crosstool
    ├── demangle_tree.py
    ├── docker
    ├── emacs                           // Emacs and XEmacs syntax highlighting for LLVM assembly files and TableGen description files
    ├── extract-section.py
    ├── extract_symbols.py
    ├── extract_vplan.py
    ├── findmisopt
    ├── findoptdiff
    ├── findsym.pl
    ├── fpcmp
    ├── gdb-scripts
    ├── getsrcs.sh                      // Finds and outputs all non-generated source files
    ├── git
    ├── gn
    ├── indirect_calls.py
    ├── jedit
    ├── kate
    ├── lint
    ├── lit
    ├── lldbDataFormatters.py
    ├── llvm-compilers-check
    ├── llvm-gisel-cov.py
    ├── llvm-lit
    ├── llvm-locstats
    ├── llvm-mca-compare.py
    ├── llvm-native-gxx
    ├── llvm-original-di-preservation.py
    ├── llvm.grm
    ├── llvmdo
    ├── llvmgrep                        // Performs an egrep -H -n on each source file in LLVM
    ├── merge-stats.py
    ├── not
    ├── pipeline.py
    ├── prepare-code-coverage-artifact.py
    ├── reduce_pipeline.py
    ├── reduce_pipeline_test
    ├── release
    ├── remote-exec.py
    ├── revert_checker.py
    ├── revert_checker_test.py
    ├── rsp_bisect.py
    ├── rsp_bisect_test
    ├── sanitizers
    ├── schedcover.py
    ├── shuffle_fuzz.py
    ├── shuffle_select_fuzz_tester.py
    ├── sort_includes.py
    ├── sysroot.py
    ├── testgen
    ├── textmate
    ├── unicode-case-fold.py
    ├── unittest
    ├── update_analyze_test_checks.py
    ├── update_cc_test_checks.py
    ├── update_llc_test_checks.py
    ├── update_mca_test_checks.py
    ├── update_mir_test_checks.py
    ├── update_test_checks.py
    ├── update_test_prefix.py
    ├── valgrind
    ├── vim                             // vim syntax-highlighting for LLVM assembly files and TableGen description files
    ├── vscode
    ├── wciia.py
    └── yaml-bench
```

- test-suite: A comprehensive correctness, performance, and benchmarking test suite for LLVM

```
https://github.com/llvm/llvm-test-suite
```

## 使用

<!-- 记录软件如何使用. -->

### Versions

- Windows with MSYS2
```
$ clang --version
clang version 13.0.1
Target: x86_64-w64-windows-gnu
Thread model: posix
InstalledDir: D:/msys64/mingw64/bin

$ gcc --version
gcc.exe (Rev9, Built by MSYS2 project) 11.2.0
```

- MacOS

```
To use the bundled libc++ please add the following LDFLAGS:
  LDFLAGS="-L/usr/local/opt/llvm/lib -Wl,-rpath,/usr/local/opt/llvm/lib"

llvm is keg-only, which means it was not symlinked into /usr/local,
because macOS already provides this software and installing another version in
parallel can cause all kinds of trouble.

If you need to have llvm first in your PATH, run:
  echo 'export PATH="/usr/local/opt/llvm/bin:$PATH"' >> ~/.zshrc

For compilers to find llvm you may need to set:
  export LDFLAGS="-L/usr/local/opt/llvm/lib"
  export CPPFLAGS="-I/usr/local/opt/llvm/include"
```

### Example with clang

hello.c:

``` c
#include <stdio.h>

int main() {
        printf("hello world\n");
        return 0;
}
```

```
# compile C file to native executable
$ clang hello.c -o hello
$ ./hello.exe
hello world

# compile C file to LLVM bitcode file
$ clang -O3 -emit-llvm hello.c -c -o hello.bc
# invoke LLVM JIT lli
$ lli hello.bc
JIT session error: Symbols not found: [ __mingw_vfprintf, __main ]
D:\msys64\mingw64\bin/lli.exe: Failed to materialize symbols: { (main, { main }) }

# view LLVM assembly code
$ llvm-dis < hello.bc

# LLC code generator: compile to native assembly code
$ llc hello.bc -o hello.s
# assemble to program
$ gcc hello.s -o hello.native
$ ./hello.native
hello world
```

### Kaleidoscope example

parser: Recursive Descent Parsing, Operator-Precedence Parsing[^OPP]

[^OPP]: Operator-Precedence Parsing: https://en.wikipedia.org/wiki/Operator-precedence_parser

- Grammar

```
# Parser
top ::= definition | external | expression | ';'

definition ::= 'def' prototype expression
external ::= 'extern' prototype
toplevelexpr ::= expression

prototype ::= id '(' id* ')'

expression ::= primary binoprhs

primary
  ::= identifierexpr
  ::= numberexpr
  ::= parenexpr

identifierexpr
  ::= identifier
  ::= identifier '(' expression* ')'
parenexpr ::= '(' expression ')'
numberexpr ::= number

binoprhs ::= ('<'|'+'|'-'|'*' primary)*

# Lexer
identifier: [a-zA-Z][a-zA-Z0-9]*
number: [0-9.]+
```

- AST

```
/// ExprAST - Base class for all expression nodes.
class ExprAST

/// NumberExprAST - Expression class for numeric literals like "1.0".
class NumberExprAST : public ExprAST

/// VariableExprAST - Expression class for referencing a variable, like "a".
class VariableExprAST : public ExprAST

/// BinaryExprAST - Expression class for a binary operator.
class BinaryExprAST : public ExprAST

/// CallExprAST - Expression class for function calls.
class CallExprAST : public ExprAST

/// PrototypeAST - This class represents the "prototype" for a function,
/// which captures its name, and its argument names (thus implicitly the number
/// of arguments the function takes).
class PrototypeAST
```

- example

```
# Compute the x'th fibonacci number.
def fib(x)
  if x < 3 then
    1
  else
    fib(x-1)+fib(x-2)

# This expression will compute the 40th number.
fib(40)

extern sin(arg);
extern cos(arg);
extern atan2(arg1 arg2);
atan2(sin(.4), cos(42))
```

- Code Generation

``` c++
// llvm::LLVMContext: (opaquely) owns and manages the core "global" data of LLVM's core infrastructure
// llvm::Module: Modules are the top level container of all other LLVM Intermediate Representation (IR) objects
// llvm::IRBuilder: provides a uniform API for creating instructions and inserting them into a basic block

static std::unique_ptr<LLVMContext> TheContext;
static std::unique_ptr<Module> TheModule;
static std::unique_ptr<IRBuilder<>> Builder;
static std::map<std::string, Value *> NamedValues;

static void InitializeModule() {
  // Open a new context and module.
  TheContext = std::make_unique<LLVMContext>();
  TheModule = std::make_unique<Module>("my cool jit", *TheContext);

  // Create a new builder for the module.
  Builder = std::make_unique<IRBuilder<>>(*TheContext);
}

// llvm::Value: represent a SSA(Static Single Assignment) register, or SSA value
// llvm::Function

ConstantFP::get(...)
Builder.CreateFAdd(...)
Builder.CreateFSub(...)
Builder.CreateFMul(...)
Builder.CreateFCmpULT(...)
Builder.CreateUIToFP(...)
Type::getDoubleTy(...)
TheModule->getFunction(...)
Builder.CreateCall(...)
FunctionType::get(...)
Function::Create(...)
BasicBlock::Create(...)
Builder.SetInsertPoint(...)
Builder.CreateRet(...)
```

- JIT

``` c++
static std::unique_ptr<KaleidoscopeJIT> TheJIT;

llvm::InitializeNativeTarget();
llvm::InitializeNativeTargetAsmPrinter();
llvm::InitializeNativeTargetAsmParser();


TheJIT->addModule(...)
TheJIT->findSymbol(...)
TheJIT->removeModule(...)
```

## 数据结构和算法

<!-- 描述软件中重要的数据结构和算法, 支撑过程部分的记录. -->

## 过程

<!-- 描述软件中重要的过程性内容, 例如服务器的启动、服务器响应客户端请求、服务器背景活动等. -->

## 文献引用

<!-- 记录软件相关和进一步阅读资料: 文献、网页链接等. -->

### 网页

- [LLVM Documentation](https://llvm.org/docs/index.html)

#### LLVM Design & Overview

- [Introduction to the LLVM Compiler](https://llvm.org/pubs/2008-10-04-ACAT-LLVM-Intro.html): Presentation providing a users introduction to LLVM.
- [Intro to LLVM](http://www.aosabook.org/en/llvm.html): A chapter from the book “The Architecture of Open Source Applications” that describes high-level design decisions that shaped LLVM.
- [LLVM: A Compilation Framework for Lifelong Program Analysis & Transformation](https://llvm.org/pubs/2004-01-30-CGO-LLVM.html): Design overview.
- [LLVM: An Infrastructure for Multi-Stage Optimization](https://llvm.org/pubs/2002-12-LattnerMSThesis.html): More details (quite old now).

#### Documentation

- [Getting Started/Tutorials](https://llvm.org/docs/GettingStartedTutorials.html): For those new to the LLVM system.
- [User Guides](https://llvm.org/docs/UserGuides.html): User guides and How-tos.
- [Reference](https://llvm.org/docs/Reference.html): LLVM and API reference documentation.

## 其他备注

- 体系结构和平台信息: [Architecture & Platform Information for Compiler Writers](https://llvm.org/docs/CompilerWriterInfo.html)
