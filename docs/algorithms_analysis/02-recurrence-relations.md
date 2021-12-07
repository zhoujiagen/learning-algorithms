### 2. Recurrence Relations
#### 2.1 Basic Properties
#### 2.2 First-Order Recurrences

**Table 2.3 Elementary discrete sums**

geometric series: $\sum_{0 \leq k < n}^{} x^{k} = \frac{1-x^{n}}{1-x}$

arithmetic series: $\sum_{0 \leq k < n}^{} k = \frac{n(n-1)}{2} = \binom{n}{2}$

binomial coefficents: $\sum_{0 \leq k \leq n}^{} \binom{k}{m} = \binom{n+1}{m+1}$

binomial theorem: $\sum_{0 \leq k \leq n}^{} \binom{n}{k} x^{k} y^{n-k} = (x+y)^{n}$

harmonic numbers: $\sum_{1 \leq k \leq n}^{} \frac{1}{k} = H_{n}$

sum of harmonic numbers: $\sum_{1 \leq k < n}^{} H_{k} = nH_{n} - n$

Vandermonde convolution: $\sum_{0 \leq k \leq n}^{} \binom{n}{k} \binom{m}{t-k} = \binom{n+m}{t}$

#### 2.3 Nonlinear First-Order Recurrences
#### 2.4 Higher-Order Recurrences

**Finonacci numbers** Fibonacci sequences $\{0,1,1,2,3,5,8,13,21,34,\dots \}$

$F_{n} = F_{n-1} + F_{n-2}$ for $n>1$ with $F_{0}=0$ and $F_{1}=1$.

$$
\begin{align}
F_{N} & = \frac{1}{\sqrt{5}} (\phi^{N} - \hat{\phi}^{N}) \\
\phi & = (1+\sqrt{5})/2 = 1.61803 \cdots \\
\hat{\phi} & = (1-\sqrt{5})/2 = -.61803 \cdots
\end{align}
$$

**Table 2.4 Binary divide-and-conquer recurrences and solutions**

$a_{N/2}$ means $a_{\lceil N/2 \rceil}$ or $a_{\lfloor N/2 \rfloor}$,
$2a_{N/2}$ means $a_{N/2} + a_{N/2}$.

$$
\begin{align}
& a_{N} = a_{N/2} + 1                           & \texttt{lg}N + O(1) \\
& a_{N} = a_{N/2} + N                           & 2N + O(\texttt{lg}N) \\
& a_{N} = a_{N/2} + N\texttt{lg}N               & \Theta(N\texttt{lg}N) \\
& a_{N} = 2a_{N/2} + 1                          & \Theta(N) \\
& a_{N} = 2a_{N/2} + \texttt{lg}N               & \Theta(N) \\
& a_{N} = 2a_{N/2} + N                          & N\texttt{lg}N+O(N) \\
& a_{N} = 2a_{N/2} + N\texttt{lg}N              & \frac{1}{2}N\texttt{lg}N^{2} + O(N\texttt{lg}N) \\
& a_{N} = 2a_{N/2} + N\texttt{lg}^{\delta-1}N   & \delta^{-1}N\texttt{lg}^{\delta}N + O(N\texttt{lg}^{\delta-1}N)\\
& a_{N} = 2a_{N/2} + N^{2}                      & 2N^2 + O(N)\\
& a_{N} = 3a_{N/2} + N                          & \Theta(N^{\texttt{lg}3}) \\
& a_{N} = 4a_{N/2} + N                          & \Theta(N^2)
\end{align}
$$

#### 2.5 Methods for Solving Recurrences
#### 2.6 Binary Divide-and-Conquer Recurrences and Binary Numbers
#### 2.7 General Divide-and-Conquer Recurrences
