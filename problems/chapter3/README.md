# Interview Problems from Cracking the Code Interview

## Chapter 3 - Stacks and Queues

### 1. [Three In One](./ThreeInOne.java)

Three in One: Describe how you could use a single array to implement three stacks.

### 2. [Stack Min](./StackMin.java)

Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.

### 3. [Stack of Plates](./StackOfPlates.java)

Stack of Plates: Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetO-fStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function `popAt(int index)` which performs a pop operation on a specific sub-stack.

### 4. [Queue via Stacks](./MyQueue.java)

Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
