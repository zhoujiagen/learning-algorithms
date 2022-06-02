# 6 Intermediate-Code Generation


## 6.1 Variants of Syntax Trees
### 6.1.1 Directed Acyclic Graphs for Expressions
### 6.1.2 The Value-Number Method for Constructing DAG's
### 6.1.3 Exercises for Section 6.1

## 6.2 Three-Address Code
### 6.2.1 Addresses and Instructions


Three-code address is built from two concepts: **addresses** and **instructions**.

An address can be one of the following:

- A **name**. For convenience, we allow source-program names to appear as addresses in three-address code. In an implementation, a source name is replaced by a pointer to its symbol-table entry, where all information about the name is kept.
- A **constants**.
- A **compiler-generated temporary**.

A **symbolic label** represents the index of a three-address instruction in the sequence of instructions.

A list of the common three-address instruction forms:

- (1) Assignment instruction `x = y op z`, `op` is a binary arithmetic or logical operations, `x,y,z` are addresses.
- (2) Assignment instruction `x = op y`, `op` is a unary operation.
- (3) Copy instruction `x = y`, `x` is assigned the value of `y`.
- (4) An unconditional jump `goto L`. The three-address instruction with label `L` is the next to be executed.
- (5) Conditional jumps `if x goto L` and `ifFalse x goto L`. These instructions execute the instruction with label `L` next if `x` is true or false respectively. Otherwise, the next instruction in sequence is excuted next as usual.
- (6) Conditional jumps, such as `if x relop y goto L`, execute the instruction with label `L` if `x` stands in relation `relop` to `y`; if not, the instruction following `if x relop y goto L` is executed next.
- (7) Procedure calls and returns: `param x` for parameters, `call p,n` and `y = call p,n` for procedure and function calls respectively, `return y` for returns, where `y` representing an optional returned value.

part of a call of the procedure `p(x1,x2,...,xn)`:

```
param x1
param x2
...
param xn
call p,n
```

- (8) Indexed copy instruction `x=y[i]` and `x[i]=y`. `x=y[i]` sets `x` the the value in the location `i` memory units beyond location `y`; `x[i]=y` sets the contents of the location `i` units beyond `x` to the value of `y`.
- (9) Address and pointer assignment instruction `x=&y`, `x=*y` and `*x=y`. `x=&y` sets the location (r-value) of `x` to be the location (l-value) of `y`; `x=*y` presumably `y` is a pointer or a temporary whose r-value is a location; `*x=y` sets the r-value of the object pointed to by `x` to the r-value of `y`.

Example:

```
// statement
do i = i + 1; while (a[i] < v)

// 2 translations to three-address code
L: t1 = i + 1
   i = t1
   t2 = i * 8
   t3 = a [ t2 ]
   if t3 < v goto L

100: t1 = i + 1
102: i = t1
103: t2 = i * 8
104: t3 = a [ t2 ]
105: if t3 < v goto L
```
### 6.2.2 Quadruples

In a compiler, three-address instructions can be implemented as objects or as records with fields for the operator and the operands.

3 representations of three-address instructions in a data structure:

(1) **quadruple**/**quad** has 4 fields `op, arg1, arg2, result`

- `op` field contains an internal code for the operator

example:

```
x = y + z

op  arg1 arg2 result
+   y     z   x
```

exceptions:

- Instructions with unary operators do not use `arg2`: `x = minus y`, `x = y`;
- Operators like `param` use neither `arg2` nor `result`;
- Conditional and unconditional jumps put the target label in `result`.

### 6.2.3 Triples

(2) **triple** has 3 fields `op, arg1, arg2`, refer to the result of an operation `x op y` to its position.

example:

```
a = b * -c + b * -c

  op    arg1 arg2
0 minus c
1 *     b    (0)
2 minus c
3 *     b    (2)
4 +     (1)  (3)
5 =     a    (4)
```

(3) **indirect triples** consist of a listing of pointers to triples.

example:

```
a = b * -c + b * -c

    instruction   op    arg1 arg2
35  (0)         0 minus c
36 (1)          1 *     b    (0)
37 (2)          2 minus c
38 (3)          3 *     b    (2)
39 (4)          4 +     (1)  (3)
40 (5)          5 =     a    (4)
```

### 6.2.4 Static Single-Assignment Form

All assignment in SSA(Static Single-Assignment) form are to variables with distinct names, example:


```
three-address code    SSA form

p = a + b             p1 = a + b
q = p - c             q1 = p1 - c
p = q * d             p2 = q1 * d
p = e - p             p3 = e - p2
q = p + q             q2 = p3 + q1
```

SSA uses a notational convention called the φ-function to combine the two defitions of a variables, example:


```
if (flag) x = -1; else x 1;
y = x * a;


if (flag) x1 = -1; else x2 = 1;
x3 = φ(x1, x2);
y = x3 * a;
```

### 6.2.5 Exercises for Section 6.2

## 6.3 Types and Declarations
### 6.3.1 Type Expressions
### 6.3.2 Type Equivalence
### 6.3.3 Declarations
### 6.3.4 Storage Layout for Local Names
### 6.3.5 Sequences of Declarations
### 6.3.6 Fields in Records and Classes
### 6.3.7 Exercises for Section 6.3

## 6.4 Translation of Expressions
### 6.4.1 Operations Within Expressions
### 6.4.2 Incremental Translation
### 6.4.3 Addressing Array Elements
### 6.4.4 Translation of Array References
### 6.4.5 Exercises for Section 6.4

## 6.5 Type Checking
### 6.5.1 Rules for Type Checking
### 6.5.2 Type Conversions
### 6.5.3 Overloading of Functions and Operators
### 6.5.4 Type Inference and Polymorphic Functions
### 6.5.5 An Algorithm for Uni### cation
### 6.5.6 Exercises for Section 6.5

## 6.6 Control Flow
### 6.6.1 Boolean Expressions
### 6.6.2 Short-Circuit Code
### 6.6.3 Flow-of-Control Statements
### 6.6.4 Control-Flow Translation of Boolean Expressions
### 6.6.5 Avoiding Redundant Gotos
### 6.6.6 Boolean Values and Jumping Code
### 6.6.7 Exercises for Section 6.6

## 6.7 Backpatching
### 6.7.1 One-Pass Code Generation Using Backpatching
### 6.7.2 Backpatching for Boolean Expressions
### 6.7.3 Flow-of-Control Statements
### 6.7.4 Break-, Continue-, and Goto-Statements
### 6.7.5 Exercises for Section 6.7

## 6.8 Switch-Statements
### 6.8.1 Translation of Switch-Statements
### 6.8.2 Syntax-Directed Translation of Switch-Statements
### 6.8.3 Exercises for Section 6.8

## 6.9 Intermediate Code for Procedures

## 6.10 Summary of Chapter 6

## 6.11 References for Chapter 6

- 1 Ershov, A. P., **On programming of arithmetic operations**, Comm. ACM 1:8 (1958), pp. 3{6. See also Comm. ACM 1:9 (1958), p. 16.
- 2 Feldman, S. I., **Implementation of a portable Fortran 77 compiler using modern tools**, ACM SIGPLAN Notices 14:8 (1979), pp. 98-106.
- 3 **GCC** home page http://gcc.gnu.org/, Free Software Foundation.
- 4 Gosling, J., **Java intermediate bytecodes**, Proc. ACM SIGPLAN Workshop on Intermediate Representations (1995), pp. 111-118.
- 5 Huskey, H. D., M. H. Halstead, and R. McArthur, **Neliac - a dialect of Algol**, Comm. ACM 3:8 (1960), pp. 463-468.
- 6 Johnson, S. C., **A tour through the portable C compiler**, Bell Telephone Laboratories, Inc., Murray Hill, N. J., 1979.
- 7 Milner, R., **A theory of type polymorphism in programming**, J. Computer and System Sciences 17:3 (1978), pp. 348-375.
- 8 Pierce, B. C., **Types and Programming Languages**, MIT Press, Cambridge, Mass., 2002.
- 9 Ritchie, D. M., **A tour through the UNIX C compiler**, Bell Telephone Laboratories, Inc., Murray Hill, N. J., 1979.
- 10 Strong, J., J. Wegstein, A. Tritter, J. Olsztyn, O. Mock, and T. Steel, **The problem of programming communication with changing machines: a proposed solution**, Comm. ACM 1:8 (1958), pp. 12-18. Part 2: 1:9 (1958), pp. 9-15. Report of the SHARE Ad-Hoc Committee on Universal Languages.
- 11 Wirth, N. **The design of a Pascal compiler**, Software|Practice and Experience 1:4 (1971), pp. 309-333.
