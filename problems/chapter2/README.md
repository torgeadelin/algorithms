# Interview Problems from Cracking the Code Interview

## Chapter 2 - Linked Lists

### 1. [Remove Dups](./RemoveDups.java)

Remove Dups! Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?

### 2. [Return Kth to Last](./KthToLast.java)

Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.

### 3. [Delete Middle Node](./DeleteMiddle.java)

Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.

EXAMPLE
**Input:** the node c from the linked list `a->b->c->d->e->f`
**Result:** nothing is returned, but the new linked list looks like `a->b->d->e->f`

### 4. [Partition](./Partition.java)

Partition: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.

EXAMPLE
**Input**: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition=5]
**Output**: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
