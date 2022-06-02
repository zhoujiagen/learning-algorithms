# 13 Register Allocation
## 13.1 Introduction
## 13.2 Background Issues
### 13.2.1 Memory versus Registers
### 13.2.2 Allocation versus Assignment
### 13.2.3 Register Classes
## 13.3 Local Register Allocation and Assignment
### 13.3.1 Top-Down Local Register Allocation
### 13.3.2 Bottom-Up Local Register Allocation
### 13.3.3 Moving Beyond Single Blocks
## 13.4 Global Register Allocation and Assignment
### 13.4.1 Discovering Global Live Ranges
### 13.4.2 Estimating Global Spill Costs
### 13.4.3 Interferences and the Interference Graph
### 13.4.4 Top-Down Coloring
### 13.4.5 Bottom-Up Coloring
### 13.4.6 Coalescing Copies to Reduce Degree
### 13.4.7 Comparing Top-Down and Bottom-Up Global Allocators
### 13.4.8 Encoding Machine Constraints in the Interference Graph
## 13.5 Advanced Topics
### 13.5.1 Variations on Graph-Coloring Allocation
### 13.5.2 Global Register Allocation over SSA Form
## 13.6 Summary and Perspective
