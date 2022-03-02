# Notes of **Compilers: Principles, Techniques, and Tools, 2nd Edition**


|时间|内容|
|:---|:---|
|2022-02-24| kick off. |
|2022-03-02| skimming chapter 1 and 2. |

## 术语

<!-- 记录阅读过程中出现的关键字及其简单的解释. -->

## 介绍

<!-- 描述书籍阐述观点的来源、拟解决的关键性问题和采用的方法论等. -->

## 动机

<!-- 描述阅读书籍的动机, 要达到什么目的等. -->

- 厘清编译器领域中基本术语及其含义;
- 了解编译器领域中常见的优化方法.

## 概念结构

<!-- 描述书籍的行文结构, 核心主题和子主题的内容结构和关系. -->

### 1  Introduction
#### 1.1 Language Processors
#### 1.2 The Structure of a Compiler
#### 1.3 The Evolution of Programming Languages
#### 1.4 The Science of Building a Compiler
#### 1.5 Applications of Compiler Technology
#### 1.6 Programming Language Basics
#### 1.7 Summary of Chapter 1
#### 1.8 References for Chapter 1

### 2 A Simple Syntax-Directed Translator

> This chapter is an introduction to the compiling techniques in Chapters 3 through 6 of this book.

> In this chapter, the emphasis is on the front end of a compiler, in particular on lexical analysis, parsing, and intermediate code generation.

> The working Java translator appears in Appendix A.

example:

```
{
  int i; int j; float[100] a; float v; float x;
  while ( true ) {
    do i = i + 1; while ( a[i] < v );
    do j = j - 1; while ( a[j] > v );
    if ( x >= j ) break;
    x = a[i]; a[i] = a[j]; a[j] = x;
  }
}

1:  i = i + 1
2:  t1 = a [ i ]
3:  if t1 < v goto 1
4:  j = j - 1
5:  t2 = a [ j ]
6:  if t2 > v goto 4
7:  ifFalse i >= j goto 9
8:  goto 14
9:  x = a [ i ]
10: t3 = a [ j ]
11: a [ i ] = t3
12: a [ j ] = x
13: goto 1
14:
```

#### 2.1 Introduction

three-address instructions: `x = y op z`, where `op` is a binary operator, `y` and `z` are addresses for the operands, and `x` is the address for the result of the operation.

#### 2.2 Syntax Definition

##### 2.2.1 Definition of Grammars

A **context-free grammar** has four components:

1. A set of **terminal** symbols, sometimes referred to as "tokens". The terminals are the elementary symbols of the language defined by the grammar.

2. A set of **nonterminals**, sometimes called "syntactic variables". Each nonterminal represents a set of strings of terminals, in a manner we shall describe.

3. A set of **productions**, where each production consists of a nonterminal, called the **head** or **left side** of the production, an arrow, and a sequence of terminals and/or nonterminals, called the **body** or **right side** of the production. The intuitive intent of a production is to specify one of the written forms of a construct; if the head nonterminal represents a construct, then the body represents a written form of the construct.

4. A designation of one of the nonterminals as the **start** symbol.

example:

```
list  -> list + digit
list  -> list - digit
list  -> digit
digit -> 0|1|2|3|4|5|6|7|8|9

9-5+2
3-1
7
```

##### 2.2.2 Derivations

A grammar **derives** strings by beginning with the start symbol and repeatedly replacing a nonterminal by the body of a production for that nonterminal.

The terminal strings that can be derived from the start symbol form the **language** defined by the grammar.

**Parsing** is the problem of taking a string of terminals and figuring out how to derive it from the start symbol of the grammar, and if it cannot be derived from the start symbol of the grammar, then reporting syntax errors within the string.

> In this chapter, for simplicity, we begin with source program like `9-5+2` in which each character is a terminal.

##### 2.2.3 Parse Trees
##### 2.2.4 Ambiguity

A grammar can have more than one parse tree generating a given string of terminals. Such a grammar is said to be **ambiguous**.

example:

```
string -> string + string | string - string |0|1|2|3|4|5|6|7|8|9

9-5+2

(9-5)+2
9-(5+2)
```

##### 2.2.5 Associativity of Operators


example:

```
right   -> letter = right | letter
letter  -> a|b|...|z

a=b=c

a=(b=c)
```

##### 2.2.6 Precedence of Operators

example:

```
expr    -> expr + term
        | expr - term
        | term
term    -> term * factor
        | term / factor
        | factor
factor  -> `digit`
        | ( expr )

9+5*2

9+(5*2)
```

##### 2.2.7 Exercises for Section 2.2

#### 2.3 Syntax-Directed Translation

**Syntax-directed translation** is done by attaching rules or program fragments to productions in a grammar.

example:

```
expr -> expr1 + term

translate expr1;
translate term;
handle +;
```

==Attributes==

An **attribute** is any quantity associated with a programming construct.

> we use grammar symbols (nonterminals and terminals) to represent programming construct.

examples:

- data types of expressions,
- the number of instructions in the generated code,
- the location of the first instruction in the generated code for a construct.

==(Syntax-directed) translation schemes==

A **translation scheme** is a notation for attaching *program fragments* to the productions of a grammar.

The program fragments are executed when the production is used during syntax analysis.

The combined result of all these fragment executions, in the order induced by the syntax analysis, produces the translation of the program to which this analysis/synthesis process is applied.

##### 2.3.1 Postfix Notation
##### 2.3.2 Synthesized Attributes

A **syntax-directed definition** associates

1. with each grammar symbol, a set of attributes, and
2. with each production, a set of **semantic rules** for computing the values of the attributes associated with the symbols appearing in the production.

example:

- each nonterminal has a string-valued attribute `t` that represents the postfix notation for the expression generated by that nonterminal in a parse tree.
- the symbol `||` in the sematic rule is the operator for string concatenation.

```
production              semantic rules

expr -> expr1 + term    expr.t = expr1.t || term.t || '+'
expr -> expr1 - term    expr.t = expr1.t || term.t || '-'
expr -> term            expr.t = term.t
term -> 0               term.t = '0'
term -> 1               term.t = '1'
...
term -> 9               term.t = '9'
```


##### 2.3.3 Simple Syntax-Directed Definitions
##### 2.3.4 Tree Traversals

A **traversal** of a tree starts at the root and visits each node of the tree in some order.

depth-first traversal:

```
procedure visit(node N) {
  for ( each child C of N, from left to right ) {
    visit(C)
  }
  evaluate semantic rules at node N;
}
```

##### 2.3.5 Translation Schemes

Program fragments embedded within production bodies are called **semantic actions**.

example:

```
rest -> + term {print('+')} rest1
```

actions for translating into postfix notaion:

```
expr -> expr1 + term  {print('+')}
expr -> expr1 - term  {print('-')}
expr -> term
term -> 0             {print('0')}
term -> 1             {print('1')}
...
term -> 9             {print('9')}
```

##### 2.3.6 Exercises for Section 2.3

#### 2.4 Parsing

> Programming-language parsers almost always make a single left-to-right scan over the input, looking ahead one terminal at a time, and constructing pieces of the prase tree as they go.

In **top-down** parsers, construction starts at the root and proceeds towards the leaves, while in **bottom-up** parsers, construction starts at the leaves and proceeds towards the root.

##### 2.4.1 Top-Down Parsing

The top-down construction of a prase tree, is done by starting with the root, and repeatedly performing thr following two steps:

1. at node N, labeled with nonterminal A, select one of the productions for A and construct children at N for the symbols in the production body.
2. find the next node at which a subtree is to be constructed, typically the leftmost unexpanded nonterminal of the tree.

For some grammars, the above steps can be implemented during a single left-to-right scan of the input string. The current terminal being scanned in the input is frequently referred to as the **lookahead** symbol.

In general, the selction of a production for a nonterminal way invole **trial-and-error**; that is, we may have to try a production and backtrack to try another production if the first is found to be unsuitable.

##### 2.4.2 Predictive Parsing

> **Recursive-descent parsing** is a top-down method of syntax analysis in which a set of recursive procedures is used to process the input. One procedure is associated with each nonterminal of a grammar.

**predictive parsing**: a simple form of recursive-descent parsing, in which the lookahead symbol unambiguously determine the flow of control through the procedure body for each nonterminal.

> $FIRST(\alpha)$ in section 4.4.2

##### 2.4.3 When to Use ε-Productions
##### 2.4.4 Designing a Predictive Parser
##### 2.4.5 Left Recursion

left-recursive production example:

```
expr -> expr + term
```

> A left-recursive production can be elimated by rewriting the offending production.

$$
\begin{equation}
\begin{aligned}
& A \rightarrow A \, \alpha \, | \, \beta \\
\implies & A \rightarrow \beta \, R \\
& R \rightarrow \alpha \, R \, | \, \epsilon
\end{aligned}
\end{equation}
$$

- $\alpha$ and $\beta$ are sequences of terminals and nonterminals that do not start with $A$
- nonterminal $R$ and its production $R \rightarrow \alpha \, R$ are **right recursive**.

##### 2.4.6 Exercises for Section 2.4

#### 2.5 A Translator for Simple Expressions

A syntax-directed translation scheme often serves as the Specification for a translator:

example: action for translating into postfix notation

```
expr  -> expr + term  {print('+')}
      | expr - term   {print('-')}
      | term
term  -> 0            {print('0')}
      | 1             {print('1')}
      | ...
      | 9             {print('9')}
```

##### 2.5.1 Abstract and Concrete Syntax

In abstract syntax tree, many nonterminals of a grammar represent programming constructs, but others are "helpers" of on sort of another, such as those representing terms, factors, or other variations of expressions. These heloers typically are not needed and are hence dropped, to emphase the contrast, a parse tree is sometimes called a **concrete syntax tree**.

##### 2.5.2 Adapting the Translation Scheme

1. extend left-recursion-elimination technique to multiple productions for $A$.

$$
\begin{equation}
\begin{aligned}
& A \rightarrow A \, \alpha \, | \, A \, \beta \, | \, \gamma \\
\implies & A \rightarrow \gamma \, R \\
& R \rightarrow \alpha \, R \, | \, \beta \, R \, | \, \epsilon
\end{aligned}
\end{equation}
$$

2. semantic actions embedded in the productions are simply carried along in the transformation, as if they were terminals.

example:

apply

$$
\begin{equation}
\begin{aligned}
A &= expr \\
\alpha &= + \, term \, \{print('+')\} \\
\beta &= - \, term \, \{print('-')\} \\
\gamma &= term
\end{aligned}
\end{equation}
$$

```
expr  -> expr + term  {print('+')}          expr  -> term rest
      | expr - term   {print('-')}          rest  -> + term {print('+')} rest
      | term                          ==>         | - term {print('-')} rest
term  -> 0            {print('0')}                | ε
      | 1             {print('1')}          term  -> 0 {print('0')}
      | ...                                       | 1 {print('1')}
      | 9             {print('9')}                | ...
                                                  | 9 {print('9')}
```

##### 2.5.3 Procedures for the Nonterminals
##### 2.5.4 Simplifying the Translator
##### 2.5.5 The Complete Program

``` java
class Parser { /**/ }

public class Postfix { /**/ }
```

#### 2.6 Lexical Analysis  

> In this section, a token is a terminal along with additional information.

A sequence of input characters that comprises a single token is called a **lexeme**.

> The lexical analyzer in this section allows numbers, identifiers, and "white space"(blanks, tabs, and newlines) to appear within expression.

example: actions for translating into postfix notation

```
expr    -> expr + term    {print('+')}
        | expr - term     {print('-')}
        | term
term    -> term * factor  {print('*')}
        | term / factor   {print('/')}
        | factor
factor  -> ( expr )
        | `num`           {print(num.value)}
        | `id`            {print(id.lexeme)}
```

##### 2.6.1 Removal of White Space and Comments
##### 2.6.2 Reading Ahead
##### 2.6.3 Constants
##### 2.6.4 Recognizing Keywords and Identifiers
##### 2.6.5 A Lexical Analyzer
##### 2.6.6 Exercises for Section 2.6

#### 2.7 Symbol Tables

> **Symbol tables** are data structures that are used by compilers to hold information about source-program structs.

##### 2.7.1 Symbol Table Per Scope

> The term "scope of identifier x" really refers to the scope of a particular declaration of x.

``` java
class Env { /**/ }
```

##### 2.7.2 The Use of Symbol Tables

> In effect, the role of a symbol table is to pass information from declarations to uses.

example:

```
program ->                  {top=null;}
            block
block   -> '{'              {saved=top; top=new Env(top); print("{ ");}
            decls stmts '}' {top=saved; print("} ")}
decls   -> decls decl
        | ε
decls   -> `type` `id` ';'  {s=new Symbol; s.type=type.lexeme; top.put(id.lexeme, s);}
stmts   -> stmts stmt
        | ε
stmt    -> block
        | factor ';'        {print("; ");}
factor  -> `id`             {s=top.get(id.lexeme); print(id.lexeme); print(":");} print(s.type);
```

#### 2.8 Intermediate Code Generation

> The front end of a compiler constructs an **intermediate representation** of the source program from which the back end generates the target program.

##### 2.8.1 Two Kinds of Intermediate Representations

- trees: parse trees, abstract syntax trees
- linear representation: three-address code

##### 2.8.2 Construction of Syntax Trees

example: construction of syntax trees for expression and statements

```
program -> block                      {return block.n;}
block   -> '{' stmts '}'              {block.n=stmts.n;}
stmts   -> stmts1 stmt                {stmts.n=new Seq(stmts1.n, stmt.n);}
        | ε                           {stmts.n=null;}
stmt    -> expr ';'                   {stmt.n=new Eval(expr.n);}
        | 'if' ( expr ) stmt1         {stmt.n=new If(expr.n, stmt1.n);}
        | 'while' ( expr ) stmt1      {stmt.n=new While(expr.n, stmt1.n);}
        | 'do' stmt1 'while' ( expr ) {stmt.n=new Do(stmt1.n, expr.n);}
        | block                       {stmt.n=block.n;}
expr    -> rel = expr1                {expr.n=new Assign('=', rel.n, expr1.n);}
        | rel                         {expr.n=rel.n;}
rel     -> rel1 < add                 {rel.n=new Rel('<', rel1.n, add.n);}
        | rel1 <= add                 {rel.n=new Rel('<=', rel1.n, add.n);}
        | add                         {rel.n=add.n;}
add     -> add1 + term                {add.n=new Op('+', add1.n, term.n);}
        | term                        {add.n=term.n;}
term    -> term1 * factor             {term.n=new Op('*', term1.n, factor.n);}
        | factor                      {term.n=factor.n;}
factor  -> ( expr )                   {factor.n=expr.n;}
        | `num`                       {factor.n=new Num(num.value);}
```

##### 2.8.3 Static Checking

Static checking includes:

- syntactic checking,
- type checking.

##### 2.8.4 Three-Address Code

**Three-address code** is a sequence of instructions of the form:

```
x = y op z

; control flow instructions
ifFalse x goto L  ; if x is false, next execute the instruction labeled L
ifTrue x goto L   ; if x is true, next execute the instruction labeled L
goto L            ; next execute the instruction labeled L

; copy value instructions
x = y             ; copy the value of y into x
```

- `x`,`y`,`z` are names, constants, or compiler-generated tempories,
- `op` stands for an operator.


##### 2.8.5 Exercises for Section 2.8

#### 2.9 Summary of Chapter 2

### 3 Lexical Analysis
#### 3.1 The Role of the Lexical Analyzer
#### 3.2 Input Buffering  
#### 3.3 Specification of Tokens
#### 3.4 Recognition of Tokens
#### 3.5 The Lexical-Analyzer Generator Lex
#### 3.6 Finite Automata
#### 3.7 From Regular Expressions to Automata
#### 3.8 Design of a Lexical-Analyzer Generator
#### 3.9 Optimization of DFA-Based Pattern Matchers  
#### 3.10 Summary of Chapter 3
#### 3.11 References for Chapter 3

### 4 Syntax Analysis
#### 4.1 Introduction
#### 4.2 Context-Free Grammars
#### 4.3 Writing a Grammar
#### 4.4 Top-Down Parsing  
#### 4.5 Bottom-Up Parsing
#### 4.6 Introduction to LR Parsing: Simple LR
#### 4.7 More Powerful LR Parsers
#### 4.8 Using Ambiguous Grammars
#### 4.9 Parser Generators
#### 4.10 Summary of Chapter 4  
#### 4.11 References for Chapter 4

### 5 Syntax-Directed Translation
#### 5.1 Syntax-Directed Definitions
#### 5.2 Evaluation Orders for SDD's  
#### 5.3 Applications of Syntax-Directed Translation
#### 5.4 Syntax-Directed Translation Schemes
#### 5.5 Implementing L-Attributed SDD's  
#### 5.6 Summary of Chapter 5
#### 5.7 References for Chapter 5  

### 6 Intermediate-Code Generation
#### 6.1 Variants of Syntax Trees  
#### 6.2 Three-Address Code
#### 6.3 Types and Declarations
#### 6.4 Translation of Expressions  
#### 6.5 Type Checking  
#### 6.6 Control Flow
#### 6.7 Backpatching
#### 6.8 Switch-Statements
#### 6.9 Intermediate Code for Procedures  
#### 6.10 Summary of Chapter 6
#### 6.11 References for Chapter 6

### 7 Run-Time Environments
#### 7.1 Storage Organization  
#### 7.2 Stack Allocation of Space
#### 7.3 Access to Nonlocal Data on the Stack  
#### 7.4 Heap Management  
#### 7.5 Introduction to Garbage Collection  
#### 7.6 Introduction to Trace-Based Collection
#### 7.7 Short-Pause Garbage Collection
#### 7.8 Advanced Topics in Garbage Collection
#### 7.9 Summary of Chapter 7
#### 7.10 References for Chapter 7

### 8 Code Generation
#### 8.1 Issues in the Design of a Code Generator
#### 8.2 The Target Language
#### 8.3 Addresses in the Target Code  
#### 8.4 Basic Blocks and Flow Graphs
#### 8.5 Optimization of Basic Blocks
#### 8.6 A Simple Code Generator
#### 8.7 Peephole Optimization  
#### 8.8 Register Allocation and Assignment  
#### 8.9 Instruction Selection by Tree Rewriting  
#### 8.10 Optimal Code Generation for Expressions
#### 8.11 Dynamic Programming Code-Generation
#### 8.12 Summary of Chapter 8  
#### 8.13 References for Chapter 8  

### 9 Machine-Independent Optimizations
#### 9.1 The Principal Sources of Optimization
#### 9.2 Introduction to Data-Flow Analysis
#### 9.3 Foundations of Data-Flow Analysis  
#### 9.4 Constant Propagation  
#### 9.5 Partial-Redundancy Elimination
#### 9.6 Loops in Flow Graphs
#### 9.7 Region-Based Analysis
#### 9.8 Symbolic Analysis
#### 9.9 Summary of Chapter 9
#### 9.10 References for Chapter 9

### 10 Instruction-Level Parallelism
#### 10.1 Processor Architectures
#### 10.2 Code-Scheduling Constraints
#### 10.3 Basic-Block Scheduling
#### 10.4 Global Code Scheduling
#### 10.5 Software Pipelining
#### 10.6 Summary of Chapter 10  
#### 10.7 References for Chapter 10

### 11 Optimizing for Parallelism and Locality  
#### 11.1 Basic Concepts
#### 11.2 Matrix Multiply: An In-Depth Example
#### 11.3 Iteration Spaces
#### 11.4 Affine Array Indexes  
#### 11.5 Data Reuse
#### 11.6 Array Data-Dependence Analysis
#### 11.7 Finding Synchronization-Free Parallelism
#### 11.8 Synchronization Between Parallel Loops
#### 11.9 Pipelining
#### 11.10 Locality Optimizations
#### 11.11 Other Uses of Affine Transforms  
#### 11.12 Summary of Chapter 11
#### 11.13 References for Chapter 11

### 12 Interprocedural Analysis  
#### 12.1 Basic Concepts  
#### 12.2 Why Interprocedural Analysis?
#### 12.3 A Logical Representation of Data Flow  
#### 12.4 A Simple Pointer-Analysis Algorithm
#### 12.5 Context-Insensitive Interprocedural Analysis
#### 12.6 Context-Sensitive Pointer Analysis
#### 12.7 Datalog Implementation by BDD's
#### 12.8 Summary of Chapter 12
#### 12.9 References for Chapter 12

### A  A Complete Front End
#### A.1 The Source Language

```
program   -> block
block     -> { decls stmts }
decls     -> decls decl | ε
decl      -> type `id` ;
type      -> type [ `num` ] | `basic`         # basic represents basic types
stmts     -> stmts stmt | ε

stmt      -> loc = bool ;
          | 'if' ( bool ) stmt
          | 'if' ( bool ) stmt 'else' stmt
          | 'while' ( bool ) stmt
          | 'do' stmt 'while' ( bool ) ;
          | 'break' ;
          | block
loc       -> loc [ bool ] | `id`

bool      -> bool || join | join
join      -> join && equality | equality
equality  -> equality == rel | equality != rel | rel
rel       -> expr < expr | expr <= expr | expre >= expr | expr > expr | expr
expr      -> expr + term | expr - term | term
term      -> term * unary | term / unary | unary
unary     -> ! unary | - unary | factor
factor    -> ( bool ) | loc | `num` | `real` | 'true' | 'false'
```

- `''`: literal,
- ``` `` ```: lexer identifier.


#### A.2 Main
#### A.3 Lexical Analyzer
#### A.4 Symbol Tables and Types
#### A.5 Intermediate Code for Expressions  
#### A.6 Jumping Code for Boolean Expressions
#### A.7 Intermediate Code for Statements
#### A.8 Parser  
#### A.9 Creating the Front End

### B Finding Linearly Independent Solutions


## 总结

<!-- 概要记录书籍中如何解决关键性问题的. -->

## 应用

<!-- 记录如何使用书籍中方法论解决你自己的问题. -->

## 文献引用

<!-- 记录相关的和进一步阅读资料: 文献、网页链接等. -->

- Alfred V. Aho, Monica S. Lam, Ravi Sethi, Jeffrey D. Ullman. **Compilers: Principles, Techniques, and Tools, 2nd Edition**. Pearson, 2007.

## 其他备注
