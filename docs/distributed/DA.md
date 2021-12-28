# Notes of **Distributed Algorithms**


|时间|内容|
|:---|:---|
|20211227|kick off.|

## 术语

<!-- 记录阅读过程中出现的关键字及其简单的解释. -->

## 介绍

<!-- 描述书籍阐述观点的来源、拟解决的关键性问题和采用的方法论等. -->

1 同步网络算法

```
模型I: 同步网络模型
同步环中Leader选举
通用的同步网络中算法
带链路失败的分布式共识
带进程失败的分布式共识
其他共识问题
```

2 异步算法

```
模型II: 异步系统模型
```

2.1 异步共享内存算法

```
模型III: 异步共享内存模型
互斥
资源分配
共识
原子对象
```

2.2 异步网络算法

```
模型IV: 异步网络模型
基本的异步网络算法
同步器Synchronizer
共享内存 v.s. 网络
逻辑时间
全局快照, 稳定属性
网络资源分配
带进程失败的异步网络
数据链路协议
```

3 半同步算法

```
模型V: 半同步系统模型
带半同步的互斥
带半同步的共识
```


## 动机

<!-- 描述阅读书籍的动机, 要达到什么目的等. -->

Gain the concepts and tools for developing and analyzing distributed algorithms.

## 概念结构

<!-- 描述书籍的行文结构, 核心主题和子主题的内容结构和关系. -->

#### 1  Introduction
##### 1.1  The Subject Matter

types of **uncertainty** and **independence**:

- unknown number of processors,
- unknown network topology,
- independent inputs at different locations,
- several programs executing at once, starting at different times, and operating at different speeds,
- processor nondeterminism,
- uncertain message dilivery times,
- unknown message ordering,
- processor and communication failures.

For a distributed algorithm, instead of understanding everything about its behavior, the best that we usually can do is to understand **certain selected properties of its behavior**.

The general style of work in distributed algorithms is:

1. **problems** of significance in pratical distributed computing are identified, and abstract versions of these problems, suitable for mathematical study, are defined.

2. **algorithms** that solve the problems are developed. these are describe precisely and proved to solve the stated problems, and their complexity, according to various measures, is analyzed.

3. **impossibility results** and **lower bound** are proved, demonstrating limitations on what problems can be solved and with what costs.

4. underlying all of this work are **mathematical models for distributed systems**.

##### 1.2  Our Viewpoint

The timing models we consider:

- **the synchronous model**: assume components take steps simultaneously,
- **the asynchronous model**: assume seperate components take steps in arbitraty orders,
- **the partially synchronous (timing-based) model**: assume some restrictions on the relative timing of events, but execution is not completely lock-step as it is in the synchronous model.

IPC mechanism classification:

- shared memory,
- messaging passing.


**modular** presentatition:

- compose algorithms to obtain other algorithms,
- develope algorithms using levels of abstraction,
- transforme algorithms for one model into algorithms for other models.

##### 1.3  Overview of Chapter 2-25

1. models and proof methods

- state machine,
- the method of invariant assertions,
- the method of simulations
- Chapter 2,8,9,14,23.

2. synchronous network algorithms

- Chapter 3-7.

3. asynchronous shared memory algorithms

- Chapter 10-13.

4. Asynchronous network algorithms

- Chapter 15-22.

5. partially synchronous algorithms

- Chapter 24-25.

##### 1.4  Bibliographic Notes
##### 1.5  Notation

- $\mathbb{N}$: the natural numbers, $\{0,1,2,\cdots \}$,
- $\mathbb{N}^{+}$: the positive natural number, $\{1,2,\cdots\}$,
- $R^{\ge 0}$: the nonnegative real numbers,
- $R^{+}$: the positive real numbers,
- $\lambda$: the empty string,
- if $\beta$ is any sequence and $S$ is any set, then $\beta|S$: the subsequence of $\beta$ consisting of all the elements of $S$ in $\beta$.

### Part I Synchronous Network Algorithms

#### 2  Modelling I: Synchronous Network Model
##### 2.1  Synchronous Network Systems
##### 2.2  Failures
##### 2.3  Inputs and Outputs
##### 2.4  Executions
##### 2.5  Proof Methods
##### 2.6  Complexity Measures
##### 2.7  Randomization
##### 2.8  Bibliographic Notes

#### 3  Leader Election in a Synchronous Ring
##### 3.1  The Problem
##### 3.2  Impossibility Result for Identical Processes
##### 3.3  A Basic Algorithm
##### 3.4  An algorithm with O (n log n) Communication Complexity
##### 3.5  Non-Comparison-Based Algorithms
###### 3.5.1  The TimeSlice Algorithm
###### 3.5.2  The Variable Speeds Algorithm
##### 3.6  Lower Bound for Comparison-Based Algorithms
##### 3.7  Lower Bound for Non-comparison-Based Algorithms
##### 3.8  Bibliographic Notes
##### 3.9  Exercises

#### 4  Algorithms in General Synchronous Networks
##### 4.1  Leader Election in a General Network
###### 4.1.1  The Problem
###### 4.1.2  A Simple flooding Algorithm
###### 4.1.3  Reducing the Communication Complexity
##### 4.2  Breadth-First Search
###### 4.2.1  The Problem
###### 4.2.2  A Basic Breadth-First Search Algorithm
###### 4.2.3  Applications
##### 4.3  Shortest Paths
##### 4.4  Minimum Spanning Tree
###### 4.4.1  The Problem
###### 4.4.2  Basic Theory
###### 4.4.3  The Algorithm
##### 4.5  Maximal Independent Set
###### 4.5.1  The Problem
###### 4.5.2  A Randomized Algorithm
###### 4.5.3  Analysis
##### 4.6  Bibliographic Notes
##### 4.7  Exercises

#### 5  Distributed Consensus with Link Failures
##### 5.1  The Coordinated Attack Problem - Deterministic Version
##### 5.2  The Coordinated Attack Problem - Randomized Version
###### 5.2.1  Formal Modelling
###### 5.2.2  An Algorithm
###### 5.2.3  A Lower Bound on Disagreement
##### 5.3  Bibliographic Notes
##### 5.4  Exercises

#### 6  Distributed Consensus with Process Failures
##### 6.1  The Problem
##### 6.2  Algorithms for Stopping Failures
###### 6.2.1  A Basic Algorithm
###### 6.2.2  Reducing the Communication
###### 6.2.3  Exponential Information Gathering Algorithms
###### 6.2.4  Byzantine Agreement with Authentication
##### 6.3  Algorithms for Byzantine Failures
###### 6.3.1  An Example
###### 6.3.2  EIG Algorithm for Byzantine Agreement
###### 6.3.3  General Byzantine Agreement Using Binary Byzantine Agreement
###### 6.3.4  Reducing the Communication Cost
##### 6.4  Number of Processes for Byzantine Agreement
##### 6.5  Byzantine Agreement in General Graphs
##### 6.6  Weak Byzantine Agreement
##### 6.7  Number of Rounds with Stopping Failures
##### 6.8  Bibliographic Notes
##### 6.9  Exercises

#### 7  More Consensus Problems
##### 7.1  k-Agreement
###### 7.1.1  The Problem
###### 7.1.2  An Algorithm
###### 7.1.3  Lower Bound
##### 7.2  Approximate Agreement
##### 7.3  The Commit Problem
###### 7.3.1  The Problem
###### 7.3.2  Two-Phase Commit
###### 7.3.3  Three-Phase Commit
###### 7.3.4  Lower Bound on the Number of Messages
##### 7.4  Bibliographic Notes
##### 7.5  Exercises

### Part II Asynchronous Algorithms

#### 8  Modelling II: Asynchronous System Model
##### 8.1  I/O Automata
##### 8.2  Operations on Automata
###### 8.2.1  Composition
###### 8.2.2  Hiding
##### 8.3  Fairness
##### 8.4  Inputs and Outputs for Problems
##### 8.5  Properties and Proof Methods
###### 8.5.1  Invariant Assertions
###### 8.5.2  Trace Properties
###### 8.5.3  Safety and Liveness Properties
###### 8.5.4  Compositional Reasoning
###### 8.5.5  Hierarchical Proofs
##### 8.6  Complexity Measures
##### 8.7  Indistinguishable Executions
##### 8.8  Randomization
##### 8.9  Bibliographic Notes
##### 8.10  Exercises

### Part IIA Asynchronous Shared Memory Algorithms

#### 9  Modelling III: Asynchronous Shared Memory Model
##### 9.1  Shared Memory Systems
##### 9.2  Environment Model
##### 9.3  Indistinguishable States
##### 9.4  Shared Variable Types
##### 9.5  Complexity Measures
##### 9.6  Failures
##### 9.7  Randomization
##### 9.8  Bibliographic Notes
##### 9.9  Exercises

#### 10  Mutual Exclusion
##### 10.1  Asynchronous Shared Memory Model
##### 10.2  The Problem
##### 10.3  Dijkstra's Mutual Exclusion Algorithm
###### 10.3.1  The Algorithm
###### 10.3.2  A Correctness Argument
###### 10.3.3  An Assertional Proof of the Mutual Exclusion Condition
###### 10.3.4  Running Time
##### 10.4  Stronger Conditions for Mutual Exclusion Algorithms
##### 10.5  Lockout-Free Mutual Exclusion Algorithms
###### 10.5.1  A Two-Process Algorithm
###### 10.5.2  An n-Process Algorithm
###### 10.5.3  Tournament Algorithm
##### 10.6  An Algorithm Using Single-Writer Shared Registers
##### 10.7  The Bakery Algorithm
##### 10.8  Lower Bound on the Number of Registers
###### 10.8.1  Basic Facts
###### 10.8.2  Single-Writer Shared Variables
###### 10.8.3  Multi-Writer Shared Variables
##### 10.9  Mutual Exclusion Using Read-Modify-Write Shared Variables
###### 10.9.1  The Basic Problem
###### 10.9.2  Bounded Bypass
###### 10.9.3  Lockout-Freedom
###### 10.9.4  A Simulation Proof
##### 10.10  Bibliographic Notes
##### 10.11  Exercises

#### 11  Resource Allocation
##### 11.1  The Problem
###### 11.1.1  Explicit Resource Specifications and Exclusion Specifications
###### 11.1.2  Resource-Allocation Problem
###### 11.1.3  Dining Philosophers Problem
###### 11.1.4  Restricted Form of Solutions
##### 11.2  Nonexistence of Symmetric Dining Philosophers Algorithms
##### 11.3  Right-Left Dining Philosophers Algorithm
###### 11.3.1  Waiting Chains
###### 11.3.2  The Basic Algorithm
###### 11.3.3  A Generalization
##### 11.4  Randomized Dining Philosophers Algorithm
###### 11.4.1  The Algorithm
###### 11.4.2  Correctness
##### 11.5  Bibliographic Notes

#### 12  Consensus
##### 12.1  The Problem
##### 12.2 Agreement Using Read/Write Shared Memory
###### 12.2.1  Restrictions
###### 12.2.2  Terminology
###### 12.2.3  Bivalent Initializations
###### 12.2.4  Impossibility for Wait-Free Termination
###### 12.2.5  Impossibility for Single-Failure Termination
##### 12.3  Agreement Using Read-Modify-Write Shared Memory
##### 12.4  Other Types of Shared Memory
##### 12.5  Computability in Asynchronous Shared Memory Systems
##### 12.6  Bibliographic Notes
##### 12.7  Exercises

#### 13  Atomic Objects
##### 13.1  Definitions and Basic Results
###### 13.1.1  Atomic Object Definition
###### 13.1.2  A Canonical Wait-Free Atomic Object Automaton
###### 13.1.3  Composition of Atomic Objects
###### 13.1.4  Atomic Objects versus Shared Variables
###### 13.1.5  A Sufficient Condition for Showing Atomicity
##### 13.2  Implementing Read-Modify-Write Atomic Objects in Terms of Read/Write Variables
##### 13.3  Atomic Snapshots of Shared Memory
###### 13.3.1  The Problem
###### 13.3.2  An Algorithm with Unbounded Variables
###### 13.3.3  An Algorithm with Bounded Variables
##### 13.4  Read/Write Atomic Objects
###### 13.4.1  The Problem
###### 13.4.2  Another Lemma for Showing Atomicity
###### 13.4.3  An Algorithm with Unbounded Variables
###### 13.4.4  A Bounded Algorithm Using Snapshots
##### 13.5  Bibliographic Notes
##### 13.6  Exercises

### Part IIB Synchronous Network Algorithms

#### 14  Modelling IV: Asynchronous Network Model
##### 14.1  Send/Receive Systems
###### 14.1.1  Processes
###### 14.1.2  Send/Receive Channels
###### 14.1.3  Asynchronous Send/Receive Systems
###### 14.1.4  Properties of Send/Receive Systems with Reliable FIFO Channels
###### 14.1.5  Complexity Measures
##### 14.2  Broadcast Systems
###### 14.2.1  Processes
###### 14.2.2  Broadcast Channel
###### 14.2.3  Asynchronous Broadcast Systems
###### 14.2.4  Properties of Broadcast Systems with Reliable Broadcast Channels
###### 14.2.5  Complexity Measures
##### 14.3  Multicast Systems
###### 14.3.1  Processes
###### 14.3.2  Multicast Channel
###### 14.3.3 Asynchronous Multicast Systems
##### 14.4  Bibliographic Notes
##### 14.5  Exercises

#### 15  Basic Asynchronous Network Algorithms
##### 15.1  Leader Election in a Ring
###### 15.1.1  The LCR Algorithm
###### 15.1.2  The HS Algorithm
###### 15.1.3  The Peterson Leader-Election Algorithm
###### 15.1.4  A Lower Bound on Communication Complexity
##### 15.2  Leader Election in an Arbitrary Network
##### 15.3  Spanning Tree Construction, Broadcast and Convergecast
##### 15.4  Breadth-First Search and Shortest Paths
##### 15.5  Minimum Spanning Tree
###### 15.5.1  Problem Statement
###### 15.5.2  The Synchronous Algorithm: Review
###### 15.5.3  The GHS Algorithm: Outline
###### 15.5.4  In More Detail
###### 15.5.5  Specific Messages
###### 15.5.6 Complexity Analysis
###### 15.5.7  Proving Correctness for the GHS Algorithm
###### 15.5.8  A Simpler" Synchronous" Strategy
###### 15.5.9  Application to Leader Election
##### 15.6  Bibliographic Notes
##### 15.7  Exercises

#### 16  Synchronizers
##### 16.1  The Problem
##### 16.2  The Local Synchronizer
##### 16.3  The Safe Synchronizer
###### 16.3.1  Front-End Automata
###### 16.3.2  Channel Automata
###### 16.3.3  The Safe Synchronizer
###### 16.3.4  Correctness
##### 16.4  Safe Synchronizer Implementations
###### 16.4.1  Synchronizer Alpha
###### 16.4.2  Synchronizer Beta
###### 16.4.3  Synchronizer Gamma
##### 16.5  Applications
###### 16.5.1  Leader Election
###### 16.5.2  Breadth-Firth Search
###### 16.5.3  Shortest Paths
###### 16.5.4  Broadcast and Acknowledgment
###### 16.5.5  Maximal Independent Set
##### 16.6  Lower Bound on Time
##### 16.7  Bibliographic Notes
##### 16.8  Exercises

#### 17  Shared Memory versus Networks
##### 17.1  Transformations from the Shared Memory Model to the Network Model
###### 17.1.1  The Problem
###### 17.1.2  Strategies Assuming No Failures
###### 17.1.3  An algorithm Tolerating Process Failures
###### 17.1.4  An Impossibility Result for n/2 Failures
##### 17.2  Transformations form the Network Model to the Shared Memory Model
###### 17.2.1  Send/Receive Systems
###### 17.2.2  Broadcast Systems
###### 17.2.3  Impossibility of Agreement in Asynchronous Networks
##### 17.3  Bibliographic Notes
##### 17.4  Exercises

#### 18  Logical Time
##### 18.1  Logical Time for Asynchronous Networks
###### 18.1.1  Send/ Receive Systems
###### 18.1.2  Broadcast Systems
##### 18.2  Adding Logical Time to Asynchronous Algorithms
###### 18.2.1  Advancing the Clock
###### 18.2.2  Delaying Future Events
##### 18.3  Applications
###### 18.3.1  Banking System
###### 18.3.2  Global Snapshots
###### 18.3.3  Simulating a Single State Machine
##### 18.4  Transforming Real-Time Algorithms to Logical-Time Algorithms
##### 18.5  Bibliographic Notes
##### 18.6  Exercises

#### 19  Global Snapshots and Stable Properties
##### 19.1  Termination-Detection for Diffusing Algorithms
###### 19.1.1  The Problem
###### 19.1.2  The DijkstraScholten Algorithm
##### 19.2  Consistent Global Snapshots
###### 19.2.1  The Problem
###### 19.2.2  The Chandy-Lamport Algorithm
###### 19.2.3  Applications
##### 19.3  Bibliographic Notes
##### 19.4  Exercises

#### 20  Network Resource Allocation
##### 20.1  Mutual Exclusion
###### 20.1.1  The Problem
###### 20.1.2  Simulating Shared Memory
###### 20.1.3  Circulating Token Algorithm
###### 20.1.4  An Algorithm Based on Logical Time
###### 20.1.5  Improvements to the LogicalTimeME Algorithm
##### 20.2  General Resource Allocation
###### 20.2.1  The Problem
###### 20.2.2  Coloring Algorithm
###### 20.2.3  Algorithms Based on Logical Time
###### 20.2.4  Acyclic Digraph Algorithm
###### 20.2.5  Drinking Philosophers
##### 20.3  Bibliographic Notes
##### 20.4  Exercises

#### 21  Asynchronous Networks with Process Failures
##### 21.1  The Network Model
##### 21.2  Impossibility of Agreement in the Presence of Faults
##### 21.3  A Randomized Algorithm
##### 21.4  Failure Detectors
##### 21.5  k-Agreement
##### 21.6  Approximate Agreement
##### 21.7  Computability in Asynchronous Networks
##### 21.8  Bibliographic Notes
##### 21.9  Exercises

#### 22  Data Link Protocols
##### 22.1  The Problem
##### 22.2  Stenning's Protocol
##### 22.3  Alternating Bit Protocol
##### 22.4  Bounded Tag Protocols Tolerating Reordering
###### 22.4.1  Impossibility Result for Reordering and Duplication
###### 22.4.2  A Bounded Tag Protocol Tolerating Loss and Reordering
###### 22.4.3  Nonexistence of Efficient Protocols Tolerating Loss and Reordering
##### 22.5  Tolerating Crashes
###### 22.5.1  A Simple Impossibility Result
###### 22.5.2  A Harder Impossibility Result
###### 22.5.3  A Practical Protocol
##### 22.6  Bibliographic Notes
##### 22.7  Exercises

### Part III Partially Synchronous Algorithms

#### 23  Partially Synchronous System Models
##### 23.1  MMT Times Automata
###### 23.1.1  Basic Definitions
###### 23.1.2  Operations
##### 23.2  General Timed Automata
###### 23.2.1  Basic Definitions
###### 23.2.2  Transforming MMT Automata into General Timed Automata
###### 23.2.3  Operations
##### 23.3  Properties and Proof Methods
###### 23.3.1  Invariant Assertions
###### 23.3.2  Timed Trace Properties
###### 23.3.3  Simulations
##### 23.4  Modelling Shared Memory and Network Systems
###### 23.4.1  Shared Memory Systems
###### 23.4.2  Networks
##### 23.5  Bibliographic Notes
##### 23.6  Exercises

#### 24  Mutual Exclusion with Partial Synchrony
##### 24.1  The Problem
##### 24.2  A Single-Register Algorithm
##### 24.3  Resilience to Timing Failures
##### 24.4 Impossibility Results
###### 24.4.1  A Lower Bound on the Time
###### 24.4.2  Impossibility Result for Eventual Time Bounds
##### 24.5  Bibliographic Notes
##### 24.6  Exercises

#### 25  Consensus with Partial Synchrony
##### 25.1  The Problem
##### 25.2  A Failure Detector
##### 25.3  Basic Results
###### 25.3.1  Upper Bound
###### 25.3.2  Lower Bound
##### 25.4  An Efficient Algorithm
###### 25.4.1  The Algorithm
###### 25.4.2  Safety Properties
###### 25.4.3  Liveness and Complexity
##### 25.5  A Lower Bound Involving the Timing Uncertainty
##### 25.6  Other Results
###### 25.6.1  Synchronous Processes, Asynchronous Channels
###### 25.6.2  Asynchronous Processes, Synchronous Channels
###### 25.6.3  Eventual Time Bounds
##### 25.7  Postscript
##### 25.8  Bibliographic Notes
##### 25.9  Exercises

## 总结

<!-- 概要记录书籍中如何解决关键性问题的. -->

## 应用

<!-- 记录如何使用书籍中方法论解决你自己的问题. -->

## 文献引用

<!-- 记录相关的和进一步阅读资料: 文献、网页链接等. -->

- Nancy A. Lynch. **Distributed Algorithms**. Morgan Kaufmann, 1996.

## 其他备注
