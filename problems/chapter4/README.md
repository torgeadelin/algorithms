# Interview Problems from Cracking the Code Interview

## Chapter 4 - Trees and Graphs

### 1. [Route Between Nodes](./PathBetween.java)

Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a route between two nodes.

### 2. [Minimal Tree](./MinimalTree.java)

Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algo­
rithm to create a binary search tree with minimal height.

### 3. [List of Depths](./ListOfDepths.java)

Given a binary tree, design an algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

### 4. [Check Balanced](./CheckBalanced.java)

Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.

### 5. [Successor](./Successor.java)

Successor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree. You may assume that each node has a link to its parent.

### 6. [Build Order](./BuildOrder.java)

Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
EXAMPLE
Input:
projects: a, b, c, d, e, f
dependencies: (a, d), (f, b), (b, d), (f, a), (d, c) Output: f, e, a, b, d, c
