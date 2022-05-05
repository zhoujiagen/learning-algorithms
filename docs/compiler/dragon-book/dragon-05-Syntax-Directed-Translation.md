# 5 Syntax-Directed Translation
## 5.1 Syntax-Directed Definitions

A **syntax-directed definition(SDD)** is a context-free grammar together with attributes and rules. Attributes are associated with grammar symbols and rules are associated with productions.

### 5.1.1 Inherited and Synthesized Attributes

2 kinds of attributes for nonterminals:

- 1 A **synthesis attribute** for a nonterminal A at a parse-tree node N is defined by a semantic rule associated with *the production at N*. A synthesized attribute at node N is defined only in terms of attribute values at *the children of N* and at *N itself*.

- 2 An **inherited attribute** for a nonterminal B at a parse-tree node N is defined by a semantic rule associated with *the production at the parent of N*. An inherited attribute at node N is defined only in terms of attribute values at *N's parent*, *N itself*, and *N's siblings*.

Figure 5.1 Syntax-directed definition of a simple desk calculator

```
   PRODUCTION   SEMANTIC RULES

1) L -> E n     L.val = E.val
2) E -> E1 + T  E.val = E1.val + T.val
3) E -> T       E.val = T.val
4) T -> T1 * F  T.val = T1.val X F.val
5) T -> F       T.val = F.val
6) F -> ( E )   F.val = E.val
7) F -> digit   F.val = digit.lexval
```

A SSD that involves only synthesized attributes is called **S-attributed**.

A SSD without side effects is sometimes called an **attributed grammar**.

### 5.1.2 Evaluating an SDD at the Nodes of a Parse Tree

A parse tree, showing the values of its attributes is called an **annotated parse tree**.

With *synthesized attribute*, we can evaluate attributes in any bottom-up order, such as that of a postorder traversal of the parse tree.

For SDDs with both *inherited* and *synthesized* attributes, there is no guarantee that there is even one order in which to evaluate attributes at nodes.

Figure 5.3 Annotated parse tree for 3 * 5 + 4 n (using SDD in Figure 5.1)

```
                      L.val = 19
                            |-----------|
                      E.val = 19        n
              |-------------|--------------|
        E.val = 15          +           T.val = 4
              |                            |
        T.val = 15                      F.val = 4
    |---------|---------|                  |
T.val = 3     *    F.val = 5         digit.lexval = 4
    |                   |
F.val = 3         digit.lexval = 5
    |
digit.lexval = 3
```

Figure 5.4 An SDD based on a grammar suitable for top-down parsing

```
   PRODUCTION     SEMANTIC RULES

1) T -> F T'      T'.inh = F.val
                  T.val = T'.syn
2) T' -> * F T1'  T1'.inh = T.inh X F.val
                  T'.syn = T1'.syn
3) T' -> ε        T'.syn = T'.inh
4) F -> digit     F.val = digit.lexval
```
- `T` and `F` have a synthesized attribute `val`,
- `digit` has a synthesized attribute `lexval`,
- `T'` has an inherited attribute `inh` and a synthesized attribute `syn`.

Figure 5.5 Annotated parse tree for 3 * 5 (using SDD in Figure 5.4)

```
              T.val = 15
    |-------------|-------------|
F.val = 3                   T'.inh =3
    |                       T'.syn = 15
    |                 |---------|---------------|
digit.lexval = 3      *     F.val = 5       T1'.inh = 15
                                |           T1'.syn = 15
                                |               |
                          digit.lexval = 4      ε
```

### 5.1.3 Exercises for Section 5.1

## 5.2 Evaluation Orders for SDD's
### 5.2.1 Dependency Graphs

A **dependency graph** depicts the flow of information among the attribute instances in a particular tree; a tree from one attribute instance to another means the value of the first is needed to compute the second.

- 1 For each parse-tree node, a node labeled by grammar symbol X, the dependency graph has a node for each attribute associated with X.

- 2 Suppose a semantic rule associated with a production p defines the value of *synthesized attribute* A.b in terms of the value of X.c (the rule may define A.b in terms of other attributes in addition to X.c), then the dependency graph has an edge from X.c to A.b.

- 3 Suppose a semantic rule associated with a production p defines the value of *inherited attribute* B.c in terms of the value of X.a, then the dependency graph has an edge from X.a to B.c.

### 5.2.2 Ordering the Evaluation of Attributes

If the dependency graph as an edge from node M to node N, then the attribute corresponding to M must be evaluated before the attribute of N. Such an ordering of the only allowable orders of evaluation embeds a directed graph into a linear order, is called a **topological sort** of the graph.

If there is any cycle in the graph, then there are not topological sorts, that is, there is no way to evaluate the SDD on this parse tree.

If there are not cycles, then there is always at least one topological sort.

### 5.2.3 S-Attributed Definitions

An SDD is **S-attributed** if every attribute is *synthesized*.

When an SDD is S-attributed, we can evaluate its attributes in any bottom-up order of the nodes of the parse tree.

### 5.2.4 L-Attributed Definitions

ideas behind L-attributed SDDs is that, between the attributes associated with a production body, dependency graph edges go from left to right, but not from right to left.

An SDD is **L-attributed**, each attributed must be either:

(1) synthesized, or

(2) inherited, but with rules limited. suppose A -> X1 X2 ... Xn, and there is a inherited attribute Xi.a computed by a rule associated with this production, then the rule may use only:

(2.1) inherited attributes associated with the head A;
(2.2) either inherited or synthesized attributes with the occurrence of symbols X1,X2,...,Xi-1 located to the left of Xi;
(2.3) inherited or synthesized attributes associated with this occurrence of Xi itself, but only in such a way that there are no cycles in a dependency graph formed by the attributes of this Xi.

The SDD in Figure 5.4 is L-attributed.

### 5.2.5 Semantic Rules with Controlled Side Effects

We shall control side effect in SDDs in one of the following ways:

- 1 Permit side effects when attribute evaluation based on any topological sort of the dependency graph produces a "correct" translation, where "correct" depends on the application.
- 2 Constrain the allowable evaluation orders, so that the same translation is produced for any allowable order.

### 5.2.6 Exercises for Section 5.2

## 5.3 Applications of Syntax-Directed Translation

We consider 2 SDDs for constructing syntax trees for expression.

The final example is an L-attributed definition that deals with base and array types.

### 5.3.1 Construction of Syntax Trees

Figure 5.10 Constructing syntax trees for simple expression

```
   PRODUCTION   SEMANTIC RULES

1) E -> E1 + T  E.node = new Node('+', E1.node, T.node)
2) E -> E1 - T  E.node = new Node('+', E1.node, T.node)
3) E -> T       E.node = T.node
4) T -> ( E )   T.node = E.node
5) T -> id      T.node = new Leaf(id, id.entry)
6) T -> num     T.node = new Leaf(num, num.val)
```

implement the nodes of a syntax tree by objects with a suitable number of fields:

- `op`: the label of the node,
- `Leaf(op, val)`: create a leaf object,
- `Node(op,c1,c2,...,ck)`: create an object with first field `op` and k additional fields for the k children `c1,c2,...,ck`.

Figure 5.11 Syntax tree for a-4+c

```
              [+| | ]
        |--------| |-------|
     [-| | ]            [id| ]
    |---| |---|             |-- to entry for c
[id | ]   [num|4]
     |-- to entry for a
```

Figure 5.12 Steps in the construction of the syntax tree for a-4+c

```
1) p1 = new Leaf(id, entry-a);
2) p2 = new Leaf(num, 4);
3) p3 = new Node('-', p1, p2);
4) p4 = new Leaf(id, entry-c);
5) p5 = new Node('+', p3, p4);
```

Figure 5.13 Constructing syntax trees during top-down parsing

```
   PRODUCTION     SEMANTIC RULES

1) E -> T E'      E.node = E'.syn
                  E'.inh = T.node
2) E' -> + T E1'  E1'.inh = new Node('+', E'.inh, T.node)
                  E'.syn = E1'.syn
3) E' -> - T E1'  E1'.inh = new Node('-', E'.inh, T.node)
                  E'.syn = E1'.syn
4) E' -> ε        E'.syn = E'.inh
5) T -> ( E )     T.node = E.node
6) T -> id        T.node = new Leaf(id, id.entry)
7) T -> num       T.node = new Leaf(num, num.val)
```

- `E'` has an inherited attribute `inh` and a synthesized attribute `syn`.
- `E'.inh`: represents the partial syntax tree constructed so far.

### 5.3.2 The Structure of a Type

Figure 5.16 T generates either a basic type of an array type

```
PRODUCTION        SEMANTIC RULES

T -> B C          T.t = C.t
                  C.b = B.t
B -> int          B.t = integer
B -> float        B.t = float
C -> [ num ] C1   C.t = array(num.val, C1.t)
                  C1.b = C.b
C -> ε            C.t = C.b
```

- `B` and `T` has a synthesized attribute `t`: represent a type,
- `C` has two attributes: an inherited attribute `b` and a synthesized attribute `t`,
- `b` pass a basic type down the tree,
- `t` accumulate the result.

### 5.3.3 Exercises for Section 5.3

## 5.4 Syntax-Directed Translation Schemes
### 5.4.1 Postfix Translation Schemes
### 5.4.2 Parser-Stack Implementation of Postfix SDT's
### 5.4.3 SDT's With Actions Inside Productions
### 5.4.4 Eliminating Left Recursion From SDT's
### 5.4.5 SDT's for L-Attributed Definitions
### 5.4.6 Exercises for Section 5.4

### 5.5 Implementing L-Attributed SDD's
### 5.5.1 Translation During Recursive-Descent Parsing
### 5.5.2 On-The-Fly Code Generation
### 5.5.3 L-Attributed SDD's and LL Parsing
### 5.5.4 Bottom-Up Parsing of L-Attributed SDD's
### 5.5.5 Exercises for Section 5.5

## 5.6 Summary of Chapter 5
## 5.7 References for Chapter 5

- 1 Brooker, R. A. and D. Morris, **A general translation program for phrase structure languages**, J. ACM 9:1 (1962), pp. 1-10.
- 2 Irons, E. T., **A syntax directed compiler for Algol 60**, Comm. ACM 4:1 (1961), pp. 51{55.
- 3 Jazayeri, M., W. F. Ogden, and W. C. Rounds, **The intrinsic exponential complexity of the circularity problem for attribute grammars**, Comm. ACM 18:12 (1975), pp. 697-706.
- 4 Johnson, S. C., **Yacc - Yet Another Compiler Compiler**, Computing Science Technical Report 32, Bell Laboratories, Murray Hill, NJ, 1975. Available at http://dinosaur.compilertools.net/yacc/ .
- 5 Knuth, D.E., **Semantics of context-free languages**, Mathematical Systems Theory 2:2 (1968), pp. 127{145. See also Mathematical Systems Theory 5:1 (1971), pp. 95-96.
- 6 Lewis, P. M. II, D. J. Rosenkrantz, and R. E. Stearns, **Attributed translations**, J. Computer and System Sciences 9:3 (1974), pp. 279-307.
- 7 Paakki, J., **Attribute grammar paradigms - a high-level methodology in language implementation**, Computing Surveys 27:2 (1995), pp. 196-255.
- 8 Samelson, K. and F. L. Bauer, **Sequential formula translation**, Comm. ACM 3:2 (1960), pp. 76-83.  
