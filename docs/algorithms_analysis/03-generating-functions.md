### 3. Generating Functions
#### 3.1 Ordinary Generating Functions

Given a sequence $a_{0},a_{1},a_{2},\dots,a_{k},\dots$, the **ordinary generating function (OGF)** of the sequence:

$$
A(z) = \sum_{k \geq 0} a_{k} z^{k}
$$

- $[z^{k}]A(z)$ refer to the coefficent $a_{k}$.

**Table 3.1 Elementary ordinary generating functions**

|Sequence|GF|
|:---|:---|
|$1,1,1,1,\dots,1,\dots$                                                          |$\frac{1}{1-z} = \sum_{N \geq 0} z^{N}$|
|$0,1,2,3,4,\dots,N,\dots$                                                        |$\frac{z}{(1-z)^{2}} = \sum_{N \geq 1} Nz^{N}$|
|$0,0,1,3,6,10,\dots,\binom{N}{2},\dots$                                          |$\frac{z^{2}}{(1-z)^3} = \sum_{N \geq 2} \binom{N}{2}z^{N}$|
|$0,\dots,0,1,M+1,\dots,\binom{N}{M},\dots$                                       |$\frac{z^{M}}{(1-z)^{M+1}} = \sum_{N \geq M} \binom{N}{M} z^{N}$|
|$1,M,\binom{M}{2},\dots,\binom{M}{N},\dots,M,1$                                  |$(1+z)^{M} = \sum_{N \geq 0} \binom{M}{N} z^{N}$|
|$1,M+1,\binom{M+2}{2},\binom{M+3}{3},\dots$                                      |$\frac{1}{(1-z)^{M+1}} = \sum_{N \geq 0} \binom{N+M}{N} z^{N}$|
|$1,0,1,0,\dots,1,0,\dots$                                                        |$\frac{1}{1-z^{2}} = \sum_{N \geq 0} z^{2N}$|
|$1,c,c^{2},c^{3},\dots,c^{N},\dots$                                              |$\frac{1}{1-cz} = \sum_{N \geq 0} c^{N}z^{N}$|
|$1,1,\frac{1}{2!},\frac{1}{3!},\frac{1}{4},\dots,\frac{1}{N!},\dots$             |$e^{z} = \sum_{N \geq 0} \frac{z^{N}}{N!}$|
|$0,1,\frac{1}{2},\frac{1}{3},\frac{1}{4},\dots,\frac{1}{N},\dots$                |$\texttt{ln} \frac{1}{1-z} = \sum_{N \geq 1} \frac{z^{N}}{N}$|
|$0,1,1+\frac{1}{2},1+\frac{1}{2}+\frac{1}{3},\dots,H_{N},\dots$                  |$\frac{1}{1-z} \texttt{ln} \frac{1}{1-z} = \sum_{N \geq 1} H_{N} z^{N}$|
|$0,0,1,3(\frac{1}{2}+\frac{1}{3}),4(\frac{1}{2}+\frac{1}{3}+\frac{1}{4}),\dots$  |$\frac{z}{(1-z)^{2}} \texttt{ln} \frac{1}{1-z} = \sum_{N \geq 0} N(H_{N}-1)z^{N}$|

**Table 3.2 Operations on ordinary generating functions**

|Operation|GF|Sequence|
|:---|:---|:---|
|-                                | $A(z) = \sum_{n \geq 0} a_{n}z^{n}$         |$a_{0},a_{1},a_{2},\dots,a_{n},\dots$|
|-                                | $B(z) = \sum_{n \geq 0} b_{n}z^{n}$         |$b_{0},b_{1},b_{2},\dots,b_{n},\dots$|
|right shift                      | $zA(z) = \sum_{N \geq 1} a_{n-1} z^{n}$             |$0,a_{0},a_{1},a_{2},\dots,a_{n-1},\dots$|
|left shift                       |$\frac{A(z)-a_{0}}{z} = \sum_{n \geq 0} a_{n+1} z^{n}$   |$a_{1},a_{2},a_{3},\dots,a_{n+1},\dots$|
|index multiply (differentiation) |${A(z)}' = \sum_{n \geq 0} (n+1) a_{n+1} z^{n}$   |$a_{1},2a_{2},\dots,(n+1)a_{n+1},\dots$|
|index divide (integration)       |$\int_{0}^{z} A(t)\textit{dt} = \sum_{n \geq 1} \frac{a_{n-1}}{n} z^{n}$   |$0,a_{0},\frac{a_{1}}{2},\frac{a_{2}}{3},\dots,\frac{a_{n-1}}{n},\dots$|
|scaling                          |$A(\lambda z) = \sum_{n \geq 0} \lambda^{n} a_{n} z^{n}$               |$a_{0},\lambda a_{1},\lambda^{2} a_{2},\dots,\lambda^{n} a_{n},\dots$|
|addition                         |$A(z)+B(z) = \sum_{n \geq 0} (a_{n} + b_{n}) z^{n}$   |$a_{0}+b_{0},\dots,a_{n}+b_{n},\dots$|
|difference                       |$(1-z)A(z) = a_{0} + \sum_{n \geq 1} (a_{n}-a_{n-1}) z^{n}$              |$a_{0},a_{1}-a_{0},\dots,a_{n}-a_{n-1},\dots$|
|convolution                      |$A(z)B(z) = \sum_{n \geq 0} (\sum_{0 \leq k \leq n} a_{k}b_{n-k}) z^{n}$   |$a_{0}b_{0},a_{1}b_{0}+a_{0}b_{1},\dots,\sum_{0 \leq k \leq n} a_{k}b_{n-k}$|
|partial sum                      |$\frac{A(z)}{1-z} = \sum_{n \geq 0}(\sum_{0 \leq k \leq n} a_{k}) z^{n}$   |$a_{1},a_{1}+a_{2},\dots,\sum_{0 \leq k \leq n} a_{k},\dots$|

#### 3.2 Exponential Generating Functions

Given a sequence $a_{0},a_{1},a_{2},\dots,a_{k},\dots$, the **exponential generating function (EGF)** of the sequence:

$$
A(z) = \sum_{k \geq 0} a_{k} \frac{z^{k}}{k!}
$$

- $k![z^{k}]A(z)$ refer to the coefficent $a_{k}$.


**Table 3.3 Elementary exponential generating functions**

|Sequence|GF|
|:---|:---|
|$1,1,1,1,\dots,1,\dots$                              |$e^{z} = \sum_{N \geq 0} \frac{z^{N}}{N!}$|
|$0,1,2,3,4,\dots,N,\dots$                            |$z e^{z} = \sum_{N \geq 1} \frac{z^{N}}{(N-1)!}$|
|$0,0,1,3,6,10,\dots,\binom{N}{2},\dots$              |$\frac{1}{2} z^{2} e^{z} = \frac{1}{2} \sum_{N \geq 2} \frac{z^{N}}{(N-2)!}$|
|$0,\dots,0,1,M+1,\dots,\binom{N}{M},\dots$           |$\frac{1}{M!} z^{M} e^{z} = \frac{1}{M!} \sum_{N \geq M} \frac{z^{N}}{(N-M)!}$|
|$1,0,1,0,\dots,1,0,\dots$                            |$\frac{1}{2} (e^{z}+e^{-z}) = \sum_{N \geq 0} \frac{1+(-1)^N}{2} \frac{z^{N}}{N!}$|
|$1,c,c^{2},c^{3},\dots,c^{N},\dots$                  |$e^{cz} = \sum_{N \geq 0} \frac{c^{N} z^{N}}{N!}$|
|$1,\frac{1}{2},\frac{1}{3},\dots,\frac{1}{N},\dots$  |$\frac{e^{z}-1}{z} = \sum_{N \geq 0} \frac{z^{N}}{(N+1)!}$|
|$1,1,2,6,24,\dots,N!,\dots$                          |$\frac{1}{1-z} = \sum_{N \geq 0} \frac{N! z^{N}}{N!}$|

**Table 3.4 Operations on exponential generating functions**

|Operation|GF|Sequence|
|:---|:---|:---|
|-                            | $A(z) = \sum_{n \geq 0} a_{n} \frac{z^{n}}{n!}$         |$a_{0},a_{1},a_{2},\dots,a_{n},\dots$|
|-                            | $B(z) = \sum_{n \geq 0} b_{n} \frac{z^{n}}{n!}$         |$b_{0},b_{1},b_{2},\dots,b_{n},\dots$|
|right shift (integration)    |$\int_{0}^{z} A(t) \textit{dt} = \sum_{n \geq 1} a_{n-1} \frac{z^{n}}{n!}$    |$0,a_{0},a_{1},\dots,a_{n-1},\dots$|
|left shift (differentiation) |${A(z)}' = \sum_{n \geq 0} a_{n+1} \frac{z^{n}}{n!}$    |$a_{1},a_{2},a_{3},\dots,a_{n+1},\dots$|
|index multiply               |$zA(z) = \sum_{n \geq 0} n a_{n-1} \frac{z^{n}}{n!}$    |$0,a_{0},2a_{1},3a_{2},\dots,na_{n-1},\dots$|
|index divide                 |$\frac{(A(z)-A(0))}{z} = \sum_{n \geq 1} \frac{a_{n+1}}{n+1} \frac{z^n}{n!}$               |$a_{1},\frac{a_{2}}{2},\frac{a_{3}}{3},\dots,\frac{a_{n+1}}{n+1},\dots$|
|addition                     |$A(z) + B(z) = \sum_{n \geq 0} (a_{n} + b_{n}) \frac{z^{n}}{n!}$                       |$a_{0}+b_{0},\dots,a_{n}+b_{n},\dots$|
|difference                   |${A(z)}' - A(z) = \sum_{n \geq 0} (a_{n+1} - a_{n}) \frac{z^{n}}{n!}$                |$a_{1}-a_{0},\dots, a_{n+1}-a_{n},\dots$|
|binomial convolution         |$A(z)B(z) = \sum_{n \geq 0} \left (\sum_{0 \leq k \leq n} \binom{n}{k} a_{k} b_{n-k} \right ) \frac{z^{n}}{n!}$    |$a_{0}b_{0},a_{1}b_{0}+a_{0}b_{1},\dots,\sum_{0 \leq k \leq n} \binom{n}{k} a_{k}b_{n-k}, \dots$|
|binomial sum                 |$e^{z}A(z) = \sum_{n \geq 0} \left ( \sum_{0 \leq k \leq n} \binom{n}{k} a_{k} \right ) \frac{z^{n}}{n!}$           |$a_{0},a_{0}+a_{1},\dots,\sum_{0 \leq k \leq n} \binom{n}{k} a_{k},\dots$|

#### 3.3 Generating Function Solution of Recurrences
#### 3.4 Expanding Generating Functions
#### 3.5 Transformations with Generating Functions
#### 3.6 Functional Equations on Generating Functions
#### 3.7 Solving the Quicksort Median-of-Three Recurrence with OGFs
#### 3.8 Counting with Generating Functions
#### 3.9 Probability Generating Functions
#### 3.10 Bivariate Generating Functions
#### 3.11 Special Functions
