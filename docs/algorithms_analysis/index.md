# Note of **An Introduction to the Analysis of Algorithms**


|时间|内容|
|:---|:---|
|20211207|kick off.|

## 术语

<!-- 记录阅读过程中出现的关键字及其简单的解释. -->

### Notation

$\lfloor x \rfloor$: floor function, largest integer less than or equal to $x$

$\lceil x \rceil$: ceiling function, smallest integer greater than or equal to $x$

$\{ x \}$: fractional part, $x - \lfloor x \rfloor$

$\texttt{lg} N$: binary logarithm, $\texttt{log}_{2}N$

$\texttt{ln} N$: natural logarithm, $\texttt{log}_{e} N$

$\binom{n}{k}$: binomial coefficient, number of ways to choose $k$ out of $n$ items

$\begin{bmatrix} n\\ k \end{bmatrix}$: Stirling number of the first kind, number of permutations of $n$ elements that have $k$ cycles

$\begin{Bmatrix} n\\ k \end{Bmatrix}$: Stirling number of the second kind, numbers of ways to partition $n$ elements into $k$ nonemoty subsets

$\phi$: golden ratio, $(1+\sqrt{5})/2 = 1.61803 \cdots$

$\gamma$: Euler's constant, $.57721 \cdots$

$\sigma$: Stirling's constant, $\sqrt{2 \pi} = 2.50662 \cdots$

## 介绍

<!-- 描述书籍阐述观点的来源、拟解决的关键性问题和采用的方法论等. -->

## 动机

<!-- 描述阅读书籍的动机, 要达到什么目的等. -->

## 概念结构

<!-- 描述书籍的行文结构, 核心主题和子主题的内容结构和关系. -->

### 导论

#### 1. Analysis of Algorithms

```
|-- 1.1 Why Analyze an Algorithm?
|-- 1.2 Theory of Algorithms
|-- 1.3 Analysis of Algorithms
|-- 1.4 Average-Case Analysis
|-- 1.5 Example: Analysis of Quicksort
|-- 1.6 Asymptotic Approximations
|-- 1.7 Distributions
|-- 1.8 Randomized Algorithms
```

### 离散数学方法

#### 2. Recurrence Relations

```
|-- 2.1 Basic Properties
|-- 2.2 First-Order Recurrences
|-- 2.3 Nonlinear First-Order Recurrences
|-- 2.4 Higher-Order Recurrences
|-- 2.5 Methods for Solving Recurrences
|-- 2.6 Binary Divide-and-Conquer Recurrences and Binary Numbers
|-- 2.7 General Divide-and-Conquer Recurrences
```

#### 3. Generating Functions

```
|-- 3.1 Ordinary Generating Functions
|-- 3.2 Exponential Generating Functions
|-- 3.3 Generating Function Solution of Recurrences
|-- 3.4 Expanding Generating Functions
|-- 3.5 Transformations with Generating Functions
|-- 3.6 Functional Equations on Generating Functions
|-- 3.7 Solving the Quicksort Median-of-Three Recurrence with OGFs
|-- 3.8 Counting with Generating Functions
|-- 3.9 Probability Generating Functions
|-- 3.10 Bivariate Generating Functions
|-- 3.11 Special Functions
```

#### 4. Asymptotic Approximations

```
|-- 4.1 Notation for Asymptotic Approximations
|-- 4.2 Asymptotic Expansions
|-- 4.3 Manipulating Asymptotic Expansions
|-- 4.4 Asymptotic Approximations of Finite Sums
|-- 4.5 Euler-Maclaurin Summation
|-- 4.6 Bivariate Asymptotics
|-- 4.7 Laplace Method
|-- 4.8 “Normal” Examples from the Analysis of Algorithms
|-- 4.9 “Poisson” Examples from the Analysis of Algorithms
```

#### 5. Analytic Combinatorics

```
|-- 5.1 Formal Basis
|-- 5.2 Symbolic Method for Unlabelled Classes
|-- 5.3 Symbolic Method for Labelled Classes
|-- 5.4 Symbolic Method for Parameters
|-- 5.5 Generating Function Coefficient Asymptotics
```

### 算法与组合结构

#### 6. Trees

```
|-- 6.1 Binary Trees
|-- 6.2 Forests and Trees
|-- 6.3 Combinatorial Equivalences to Trees and Binary Trees
|-- 6.4 Properties of Trees
|-- 6.5 Examples of Tree Algorithms
|-- 6.6 Binary Search Trees
|-- 6.7 Average Path Length in Catalan Trees
|-- 6.8 Path Length in Binary Search Trees
|-- 6.9 Additive Parameters of Random Trees
|-- 6.10 Height
|-- 6.11 Summary of Average-Case Results on Properties of Trees
|-- 6.12 Lagrange Inversion
|-- 6.13 Rooted Unordered Trees
|-- 6.14 Labelled Trees
|-- 6.15 Other Types of Trees
```

#### 7. Permutations

```
|-- 7.1 Basic Properties of Permutations
|-- 7.2 Algorithms on Permutations
|-- 7.3 Representations of Permutations
|-- 7.4 Enumeration Problems
|-- 7.5 Analyzing Properties of Permutations with CGFs
|-- 7.6 Inversions and Insertion Sorts
|-- 7.7 Left-to-Right Minima and Selection Sort
|-- 7.8 Cycles and In Situ Permutation
|-- 7.9 Extremal Parameters
```

#### 8. Strings and Tries

```
|-- 8.1 String Searching
|-- 8.2 Combinatorial Properties of Bitstrings
|-- 8.3 Regular Expressions
|-- 8.4 Finite-State Automata and the Knuth-Morris-Pratt Algorithm
|-- 8.5 Context-Free Grammars
|-- 8.6 Tries
|-- 8.7 Trie Algorithms
|-- 8.8 Combinatorial Properties of Tries
|-- 8.9 Larger Alphabets
```

#### 9. Words and Mappings

```
|-- 9.1 Hashing with Separate Chaining
|-- 9.2 The Balls-and-Urns Model and Properties of Words
|-- 9.3 Birthday Paradox and Coupon Collector Problem
|-- 9.4 Occupancy Restrictions and Extremal Parameters
|-- 9.5 Occupancy Distributions
|-- 9.6 Open Addressing Hashing
|-- 9.7 Mappings
|-- 9.8 Integer Factorization and Mappings
```

## 总结

<!-- 概要记录书籍中如何解决关键性问题的. -->

## 应用

<!-- 记录如何使用书籍中方法论解决你自己的问题. -->

## 文献引用

<!-- 记录相关的和进一步阅读资料: 文献、网页链接等. -->

- Robert Sedgewick, Philippe Flajolet. **An Introduction to the Analysis of Algorithms**, 2nd Edition. Addison-Wesley: 2013.

## 其他备注
