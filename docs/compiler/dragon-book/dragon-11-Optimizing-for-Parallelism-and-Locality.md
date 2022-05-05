# 11 Optimizing for Parallelism and Locality
## 11.1 Basic Concepts
## 11.2 Matrix Multiply: An In-Depth Example
## 11.3 Iteration Spaces
## 11.4 Affine Array Indexes  
## 11.5 Data Reuse
## 11.6 Array Data-Dependence Analysis
## 11.7 Finding Synchronization-Free Parallelism
## 11.8 Synchronization Between Parallel Loops
## 11.9 Pipelining
## 11.10 Locality Optimizations
## 11.11 Other Uses of Affine Transforms  
## 11.12 Summary of Chapter 11
## 11.13 References for Chapter 11

- 1 Abu-Sufah, W., D. J. Kuck, and D. H. Lawrie, **On the performance enhancement of paging systems through program analysis and transformations**, IEEE Trans. on Computing C-30:5 (1981), pp. 341-356.
- 2 Allen, F. E., M. Burke, P. Charles, R. Cytron, and J. Ferrante, **An overview of the PTRAN analysis system for multiprocessing**, J. Paral lel and Distributed Computing 5:5 (1988), pp. 617-640.
- 3 Allen, F. E. and J. Cocke, **A Catalogue of optimizing transformations**, in Design and Optimization of Compilers (R. Rustin, ed.), pp. 1-30, Prentice-Hall, 1972.
- 4 Allen, R. and K. Kennedy, **Automatic translation of Fortran programs to vector form**, ACM Transactions on Programming Languages and Systems 9:4 (1987), pp. 491-542.
- 5 Banerjee, U., **Data Dependence in Ordinary Programs**, Master's thesis, Department of Computer Science, University of Illinois Urbana-Champaign, 1976.
- 6 Banerjee, U., **Speedup of Ordinary Programs**, Ph.D. thesis, Department of Computer Science, University of Illinois Urbana-Champaign, 1979.
- 7 Dantzig, G. and B. C. Eaves, **Fourier-Motzkin elimination and its dual**, J. Combinatorial Theory, A(14) (1973), pp. 288-297.
- 8 Feautrier, P., **Some efficient solutions to the affine scheduling problem: I. One-dimensional time**, International J. Paral lel Programming 21:5 (1992), pp. 313-348,
- 9 Hennessy, J. L. and D. A. Patterson, **Computer Architecture: A Quantitative Approach**, Third Edition, Morgan Kaufman, San Francisco, 2003.
- 10 Kuck, D., Y. Muraoka, and S. Chen, **On the number of operations simultaneously executable in Fortran-like programs and their resulting speedup**, IEEE Transactions on Computers C-21:12 (1972), pp. 1293-1310
- 11 Kung, H. T. and C. E. Leiserson, **Systolic arrays (for VLSI)**, in Du, I. S. and G. W. Stewart (eds.), Sparse Matrix Proceedings pp. 256-282. Society for Industrial and Applied Mathematics, 1978.
- 12 Lam, M. S., E. E. Rothberg, and M. E. Wolf, **The cache performance and optimization of blocked algorithms**, Proc. Sixth International Conference on Architectural Support for Programming Languages and Operating Systems (1991), pp. 63-74.
- 13 Lamport, L., **The parallel execution of DO loops**, Comm. ACM 17:2 (1974), pp. 83-93.
- 14 Lim, A. W., G. I. Cheong, and M. S. Lam, **An ane partitioning algorithm to maximize parallelism and minimize communication**, Proc. 13th International Conference on Supercomputing (1999), pp. 228-237.
- 15 Lim, A. W. and M. S. Lam, **Maximizing parallelism and minimizing synchronization with ane transforms**, Proc. 24th ACM SIGPLAN-SIGACT Symposium on Principles of Programming Languages (1997), pp. 201-214.
- 16 Lim, A. W., S.-W. Liao, and M. S. Lam, **Blocking and array contraction across arbitrarily nested loops using ane partitioning**, Proc. ACM SIGPLAN Symposium on Principles and Practice of Paral lel Programming (2001), pp. 103-112.
- 17 Loveman. D. B., **Program improvement by source-to-source transformation**, J. ACM 24:1 (1977), pp. 121-145.
- 18 Maydan, D. E., J. L. Hennessy, and M. S. Lam, **An ecient method for exact dependence analysis**, Proc. ACM SIGPLAN 1991 Conference on Programming Language Design and Implementation, pp. 1-14.
- 19 McKeller, A. C. and E. G. Coman, **The organization of matrices and matrix operations in a paged multiprogramming environment**, Comm. ACM, 12:3 (1969), pp. 153-165.
- 20 Mowry, T. C., M. S. Lam, and A. Gupta, **Design and evaluation of a compiler algorithm for prefetching**, Proc. Fifth International Conference on Architectural Support for Programming Languages and Operating Systems (1992), pp. 62-73.
- 21 Padua, D. A. and M. J. Wolfe, **Advanced compiler optimizations for supercomputers**, Comm. ACM, 29:12 (1986), pp. 1184-1201.
- 22 Portereld, A., **Software Methods for Improving Cache Performance on Supercomputer Applications**, Ph.D. Thesis, Department of Computer Science, Rice University, 1989.
- 23 Pugh, W. and D. Wonnacott, **Eliminating false positives using the omega test**, Proc. ACM SIGPLAN 1992 Conference on Programming Language Design and Implementation, pp. 140-151.
- 24 Sarkar, V. and G. Gao, **Optimization of array accesses by collective loop transformations**, Proc. 5th International Conference on Supercomputing (1991), pp. 194-205.
- 25 R. Shostak, **Deciding linear inequalities by computing loop residues**, J. ACM, 28:4 (1981), pp. 769-779.
- 26 Towle, R. A., **Control and Data Dependence for Program Transformation**, Ph.D. thesis, Department of Computer Science, University of Illinois Urbana-Champaign, 1976.
- 27 Wolf, M. E. and M. S. Lam, **A data locality optimizing algorithm**, Proc. SIGPLAN 1991 Conference on Programming Language Design and Implementation, pp. 30-44.
- 28 Wolfe, M. J., Techniques for Improving the Inherent Paral lelism in Programs, Master's thesis, Department of Computer Science, University of Illinois Urbana-Champaign, 1978.  
