# Algorithms and Data Structures - Java

All problems and content are from Cracking the Coding Interview Book by Gayle Laakmann McDowell

## Arrays and Strings

### Hash Tables

Hash tables is a data structure that maps keys to values for highly efficiency lookup. There are many ways if implementing this.

In a simple implementation you would use an array of linked lists. To insert a key and value we follow the following steps:

1. Compute the hash code for the key, which will usually be an `int` or `long`. Not that different <b>keys might have the same hash code</b>.

2. Map the hash code to an index in the array. This could be done using something like `hash(key) % array_length`. Two different hash codes <b>could map to the same index</b>.

3. At this index,there is a linked list of keys and values. Store the key and value in this index. We must use a linked list because of collisions.

To retrieve the value by its pair key, we repeat this process.Compute the hash code from the key, and then compute the index from the hash code. Then search through the linked list for the value with this key.

Summary
`key` -> `hashCode` -> `index` -> `(key, value)`

<img src="./resources/hash_table.png" width="800px"/>
