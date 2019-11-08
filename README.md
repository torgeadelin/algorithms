# Algorithms and Data Structures - Java 👨🏻‍💻

All problems and content are from Cracking the Coding Interview Book by Gayle Laakmann McDowell

## 1. Arrays and Strings

### 1.1 Hash Tables

#### Abstractions

Hash tables is a data structure that maps keys to values for highly efficiency lookup. There are many ways if implementing this.

In a simple implementation you would use an array of linked lists. To insert a key and value we follow the following steps:

1. Compute the hash code for the key, which will usually be an `int` or `long`. Not that different <b>keys might have the same hash code</b>.

2. Map the hash code to an index in the array. This could be done using something like `hash(key) % array_length`. Two different hash codes <b>could map to the same index</b>.

3. At this index,there is a linked list of keys and values. Store the key and value in this index. We must use a linked list because of collisions.

To retrieve the value by its pair key, we repeat this process.Compute the hash code from the key, and then compute the index from the hash code. Then search through the linked list for the value with this key.

Summary

`key` -> `hashCode` -> `index` -> `(key, value)`

<img src="./resources/hash_table.png" width="800px"/>

#### Complexity

If the number of collisions is very high, the worst case is **O(n)**, where **n** is the number of keys. However, generally we assume we have a good implementation of the hash function and collision is minimized, therefore the lookup worst time is **O(1)** (constant).

Another way we can implement the hash table is with a balanced BST(Binary Search Tree). This gives us an **O(log n)** lookup time. We can also iterate through the keys in order, which can be useful sometimes.

##### Notes

Hashing ins not encryption! Hashing is not reversible.

### Implementation is Java

To store (key, value) pairs in Java we use a Map. These are based on the Hash Table data structure. (There are many more, but I just included the most useful)

| Name    | Get / Put / Remove / Contains Key | Ordering                 |
| ------- | --------------------------------- | ------------------------ |
| HashMap | `O(1)`                            | not guaranteed           |
| TreeMap | `O(1)`                            | sorted, natural ordering |

---

### 1.2 Arrays and Resizable Arrays

#### Abstractions

The main difference between arrays and list is that arrays are fixed in size, while lists can grow as much as we want. When you need an array-like data structure that offers dynamic resizing you'd often use `ArrayList` in Java.

ArrayList is an array that resizes itself when needed and keeps constant **O(n)** time for access. In a typical implementation, when the array is full it doubles its size. Each time it doubles, it takes **O(n)** time but it happens really rarely and therefore the insertion is amortized to **O(1)** (constant time).

**Explanation for the amortized O(1)**
Let's say we have an array with length n. We can work backwards computing how many elements we copied each time we increased the capacity.

- 1st capacity increase : 1 element
- 2nd capacity increase : 2 elements
- ...
- previous capacity increase : n/8
- previous capacity increase : n/4
- final capacity increase : n/2

So the total number of copies to insert n elements, is ~ `n/2 + n/4 + n/8 + ... + 2 + 1` < `n`

Therefore inserting n elements takes **O(n)**. Each insertion takes **O(1)** on average, even tough some insertions take **O(n)** time in the worse case.

A good analogy is to think about a path you have to walk to get to the store = 1 km. You first walk 0.5 km, and then 0.25km and then 0.125km and so on. At the end you'll never walk 1km, but you'll get very close to it.

#### Implementation in Java

| Operation | ArrayList | Array  |
| --------- | --------- | ------ |
| get       | `O(1)`    | `O(1)` |
| add       | `O(n)`    | `O(n)` |
| remove    | `O(n)`    | `O(n)` |

---

### 1.3 StringBuilder

#### Abstractions

The `StringBuilder` in Java represents a mutable sequence of characters. Since the `String` Class in Java creates an **immutable** sequence of characters, the `StringBuilder` class provides an alternative to String Class, as it creates a mutable sequence of characters.

To illustrate why StringBuilder is good, let's look at an example.

Create a single string composed of strings from an array of strings. Think about creating a sentence from multiple words. We assume all words have same length k, and there are n string. If we run the following code:

```java
String joinWords(String[] words) {
    String sentence = "";
    for (String w: words) {
        sentence = sentence + w;
    }
    return sentence;
}
```

The time complexity will be `O(k + 2k + ... + nk)` = **O(k _ (n _ (n+1) / 2))** = **O(k \* n<sup>2</sup>)**

Using the same algorithm but replacing String with StringBuilder makes a big difference.

```java
String joinWords(String[] words) {
    StringBuilder sentence new StringBuilder();
    for (String w : words) {
        sentence.append(w);
    }
    return sentence.toString();
}
```

Time complexity is **O(n)**
