# 6. A Reference for Bison Specifications

## Bison文法的结构

Bison文法由三部分构成: 定义段、规则段和用户例程段

```
<definition section>
%%
<rules section>
%%
<user subroutines>
```

各段之间用`%%`分隔. 前两个段是必须的, 段可以为空. 第三段和前缀的`%%`可以省略.

### 符号

bison文法是从符号(symbol)构造的, 符号是文法的单词(word). 符号是字符、数字、`.`和`_`的序列, 不以数字开始. 符号错误被保留用于错误恢复, 否则bison不会给任何符号附加固定的含义.

由词法器产生的符号称为终结符号(terminal symbol)或token. 在规则LHS定义的符号称为非终结符号(nonterminal symbols或nonterminals).

token可以是`""`包裹的字面量字符串. 一个广泛采用的约定是token名称全大写, 非终结符号全小写. 本书中采用这一约定.

### 定义段
### 规则段
### 用户例程段

## Actions
### Embedded Actions
### Symbol Types for Embedded Actions

## Ambiguity and Conflicts
### Types of Conflicts
### Shift/Reduce Conflicts
### Reduce/Reduce Conflicts
### %expect
### GLR Parsers

## Bugs in Bison Programs
### Infinite Recursion
### Interchanging Precedence
### Embedded Actions

## C++ Parsers

## %code Blocks

## End Marker

## Error Token and Error Recovery
### %destructor

## Inherited Attributes ($0)
### Symbol Types for Inherited Attributes

## %initial-action

## Lexical Feedback

## Literal Block

## Literal Tokens

## Locations

## %parse-param

## Portability of Bison Parsers
### Porting Bison Grammars
### Porting Generated C Parsers
### Libraries
### Character Codes

## Precedence and Associativity Declarations
### Precedence
### Associativity
### Precedence Declarations
### Using Precedence and Associativity to Resolve Conflicts
### Typical Uses of Precedence

## Recursive Rules
### Left and Right Recursion

## Rules

## Special Characters

## %start Declaration

## Symbol Values
### Declaring Symbol Types
### Explicit Symbol Types

## Tokens
### Token Numbers
### Token Values
### %type Declaration
### %union Declaration

## Variant and Multiple Grammars
### Combined Parsers

## Multiple Parsers
### Using %name-prefix or the -p Flag
### Lexers for Multiple Parsers
### Pure Parsers

## y.output Files

## Bison Library
### main()
### yyerror()

## YYABORT

## YYACCEPT

## YYBACKUP

## yyclearin

## yydebug and YYDEBUG
### YYDEBUG
### yydebug

## yyerrok

## YYERROR

## yyerror()

## yyparse()

## YYRECOVERING()
