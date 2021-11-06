# Note of **The Art of Computer Programming, The: Volume 3: Sorting and Searching**


|时间|内容|
|:---|:---|
|20190422|kick off.|

## 术语

<!-- 记录阅读过程中出现的关键字及其简单的解释. -->

- permutation: 置换
- run: 趟
- phase: 阶段
- passes: 遍历趟的次数
- distribute: 分发; 分布
- merge: 合并


## 介绍

<!-- 描述书籍阐述观点的来源、拟解决的关键性问题和采用的方法论等. -->

## 动机

<!-- 描述阅读书籍的动机, 要达到什么目的等. -->

## 概念结构

<!-- 描述书籍的行文结构, 核心主题和子主题的内容结构和关系. -->

### 5 – Sorting
#### 5.1. Combinatorial Properties of Permutations
##### 5.1.1. Inversions
##### 5.1.2. Permutations of a Multiset

${1,2, \cdots, n}$的置换 $a_{1}a_{2} \cdots a_{n}$

Eulerian numbers: $\left \langle \begin{matrix} n\\ k \end{matrix} \right \rangle$

${1,2, \cdots, n}$ 的置换中有 $k$ 个下降( $a_{j} > a_{j+1}$ )的置换的数量


##### 5.1.3. Runs
##### 5.1.4. Tableaux and Involutions
#### 5.2. Internal sorting

Example:

```
503 087 512 061 908 170 897 275 653 426 154 509 612 677 765 703
```

##### 5.2.1. Sorting by Insertion
##### 5.2.2. Sorting by Exchanging
##### 5.2.3. Sorting by Selection
##### 5.2.4. Sorting by Merging
##### 5.2.5. Sorting by Distribution
#### 5.3. Optimum Sorting
##### 5.3.1. Minimum-Comparison Sorting
##### 5.3.2. Minimum-Comparison Merging
##### 5.3.3. Minimum-Comparison Selection
##### 5.3.4. Networks for Sorting
#### 5.4. External Sorting

multiway merging

replacement selection

initial runs by replacement selection

初始阶段输入P路合并, 将输入拆分为多趟, 趟的期望长度为2P.

after initial run, 分发和合并:

- distribute them onto tapes
- merge them together until only a single run remains

$P$: P-way merging<br/>
$S$: run count of initial distribution pass produces<br/>
$T$: tape count


##### 5.4.1. Multiway Merging and Replacement Selection
##### 5.4.2. The Polyphase Merge
##### 5.4.3. The Cascade Merge
##### 5.4.4. Reading Tape Backwards
##### 5.4.5. The Oscillating Sort
##### 5.4.6. Practical Considerations for Tape Merging
##### 5.4.7. External Radix Sorting
##### 5.4.8. Two-Tape Sorting
##### 5.4.9. Disks and Drums
#### 5.5. Summary, History, and Bibliography

### 6 – Searching

- table: a small file
- file: a large table
- database: a large file or a group of files


#### 6.1. Sequential Searching

Algorithm S(sequential search): fixed number of records

Algorithm Q(quick sequential search): a dummy record RN+1 at the end of file

Algorithm T(sequential search in ordered table): $K_{1} < K_{2} < … < K_{N}$, a dummy record $R_{N+1}$ at the end of file


#### 6.2. Searching by Comparison of Keys

search methods based on a linear ordering of keys

##### 6.2.1. Searching an Ordered Table

Branches: $K < K_{i}, K = K_{i}, K > K_{i}$


Algorithm B(binary search):

$$
l \leftarrow  1, u \leftarrow  N, i \leftarrow  \lfloor (l+u)/2 \rfloor
$$

Algorithm U(uniform binary search):

$$
i \leftarrow  \lceil N/2 \rceil, m \leftarrow  \lfloor N/2 \rfloor;  i \leftarrow i \pm \lceil m/2 \rceil, m \leftarrow \lfloor m/2 \rfloor
$$

Fibonacci search: an alternative to binary search

Fibonacci tree( FTree(k) ): order k
(1) k = 0或k = 1: 空树
(2) k >= 2: 根为 $F_{k}$ ; 左子树为FTree(k-1); 右子树为FTree(k-2), 每个节点加上 $F_{k}$.

Fibonacci number(https://en.wikipedia.org/wiki/Fibonacci_number)

```
F0    
0     
F1    F2    F3    F4    F5   
1      1    2     3      5    
F6    F7    F8    F9    F10    
8     13    21    34    55    
F11    F12    F13    F14    F15    
89     144    233    377    610    
F16    F17    F18    F19    F20
987    1597   2584   4181   6765
```

性质:

- (1) FTree(k)有 $F_{k+1}-1$ 个内部节点, Fk+1个页节点
- (2) 除页节点外, 左右节点与父节点的差绝对值相同, 值为Fibonacci数
- (3) 当在一内部节点差为 $F_{j}$ 时, 左分支的差为 $F_{j-1}$, 右分支的差为 $F_{j-2}$

Algorithm F(Fibonaccian search):


##### 6.2.2. Binary Tree Searching

符号表算法(symbol table algorithm): 搜索不断增长的表

中序遍历(symmetric order), 生成排序序列.

节点NODE(P):

- KEY(P): 键
- LLINK(P): NODE(P)左子树指针
- RLINK(P): NODE(P)右子树指针

Algorithm T(tree search and insertion): 二叉搜索树, 查找失败则插入. 树插入排序.

LLINK(P)/RLINK(P)不为Λ时, 沿LINK遍历;

LLINK(P)/RLINK(P)为Λ时, 插入新节点.

例子: Figure 10中插入K ← LFO


(1) P ← CAPRICORN(ROOT), K > CAPRICORN: T4 <br/>
(2) P ← PISCES, K < PISCES: T3 <br/>
(3) P ← GEMINI, K > GEMINI: T4 <br/>
(4) P ← LEO, K > LEO: T4 <br/>
(5) P ← LIBRA, K < LIBRA: LLINK(LIBRA)=Λ: T5 <br/>
(6) KEY(Q) ← K, K < LIBRA: LLINK(LIBRA) ← Q □

删除节点Q 思路: 删除序列中下一个节点P, 这个节点总有LLINK(P)=Λ, 在节点Q位置插入P

Algorithm D(tree deletion):

例子:  Figure 10中删除Q ← CAPRICORN(ROOT)

(1) T ← Q[CAPRICORN], RLINK(T) != Λ: D2 <br/>
(2) R ← RLINK(T)[PISCES], LLINK(R) != Λ: D3 <br/>
(3) S ← LLINK(R)[GEMINI], LLINK(S) = Λ(这时S是Q的中序遍历后继): <br/>
(3.1) LLINK(S) ← LLINK(T), LLINK(R) ← RLINK(S), RLINK(S) ← RLINK(T) <br/>
(3.2) free T

最优二叉搜索树: 给定各节点访问频率的条件下

Algorithm K(find optimum binary search tree): ...


##### 6.2.3. Balanced Trees

线性列表上的操作:

(1) 按键查找项 <br/>
(2) 找第k项 <br/>
(3) 插入项 <br/>
(4) 删除项

平衡二叉树: 任意节点的左右子树的高度差不超过1: +1, 0, -1.

导致树不平衡的两种情况(++):

Case 1: B右子树高度+1 <br/>
Case 2: B左子树高度+1, X的子树高度(h,h-1)或(h-1,h) <br/>

保持中序遍历节点顺序的翻转操作(rotation):

Case 1: PA, PB: PA←B; RLINK(A)←LLINK(B), LLINK(B)←A <br/>
Case 2: PA, PB, PX: PA←X; RLINK(A)←LLINK(X), LLINK(B)←RLINK(X); LLINK(X)←A, RLINK(X)←B <br/>

Algorithm A(balanced tree search and insertion):

- B(P): balance factor of NODE(P)
- HEAD: RLINK(HEAD)指向根节点, LLINK(HEAD)跟踪树的高度
- LINK(a,P): a=-1, LLINK(P); a=+1, RLINK(P)


##### 6.2.4. Multiway Trees

外部搜索(external searching)

例子: 7节点页, 8路分支(8 way branching)

indexed-sequential file organization: 3层, 第一层确定磁盘柱面, 第二层确定磁盘磁道, 第三层确认数据记录.


B树

- B-tree wikipedia: https://en.wikipedia.org/wiki/B-tree
- B+ tree wikipedia: https://en.wikipedia.org/wiki/B%2B_tree
- B+ Tree Visualization: http://www.cs.usfca.edu/~galles/visualization/BPlusTree.html


m为节点中指针数量.

包含j个键的节点: $P_{0}, K_{1}, P_{1}, K_{2}, P_{2}, \cdots, P_{j-1}, K_{j}, P_{j}$


如果搜索键K: $K_{i} < K <K_{i-1}$, 在 $P_{i}$ 指向的节点中查找.


区间划分: $P_{0}(-\infty, K_{1}), P_{1}[K{1},K_{2}), …, P_{i}[K_{i},K_{i+1}), ..., P_{j}[K_{j},+\infty)$


插入键可能引起节点分裂(overflow): P为原父节点指向该节点的指针, 将键 $K_{\lceil m/2 \rceil}$ 插入父节点中(父节点… $P|K_{\lceil m/2 \rceil}|P’$ …)

可能引起分裂向上传递: 父节点分裂, 根节点分裂

删除键可能引起节点合并(underflow): 向兄弟节点借元素/与兄弟节点合并

变种:

(1) B+树: 叶子节点有指向下一个叶子节点的指针, 以加速顺序访问 <br/>
(2) B*树, a B* tree of order m



#### 6.3. Digital Searching
#### 6.4. Hashing
#### 6.5. Retrieval on Secondary Keys

## 总结

<!-- 概要记录书籍中如何解决关键性问题的. -->

## 应用

<!-- 记录如何使用书籍中方法论解决你自己的问题. -->

## 文献引用

<!-- 记录相关的和进一步阅读资料: 文献、网页链接等. -->

## 其他备注
