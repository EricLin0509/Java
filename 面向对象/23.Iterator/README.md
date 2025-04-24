# Iterator

## 定义

在Java中，迭代器 (Iterator) 是一种用于遍历[集合 (Collection)](../22.集合/README.md) 中元素的接口 (List、Set、Map、Queue 等) 。它提供了一种统一的方式来访问集合中的元素，而不需要暴露集合的内部实现细节

## 语法

```java
Iterator<T> 变量名 = 集合对象.iterator();
```

### 示例

```java
List<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");
list.add("orange");
Iterator<String> iterator = list.iterator();
```

## 代码示例

### 迭代所有元素

- `Object.hasNext()` 用于判断是否还有下一个元素
- `Object.next()` 用于返回下一个元素

```java
List<String> list = new ArrayList<>();
...
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    System.out.println(element);
}
```

```java
Set<String> set = new HashSet();
...
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    System.out.println(element);
}
```

### 迭代泛型元素

此时需要需要需要对 `Object.next()` 的返回值进行转型

```java
List list = new ArrayList<>();
...
Iterator iterator = list.iterator();
while(iterator.hasNext()) {
    String next = (String) iterator.next();
    System.out.println(next);
}
```

### 在迭代过程中修改集合

**在迭代过程中修改集合会导致抛出 `ConcurrentModificationException` 异常**

这是因为在迭代过程中，**集合的结构可能会发生变化，例如添加或删除元素，这会导致迭代器无法正确地跟踪集合的状态**。为了避免这种情况，Java 提供了一种机制，即 fail-fast 机制。当在迭代过程中修改集合时，迭代器会立即抛出 `ConcurrentModificationException` 异常，以提醒开发者不要在迭代过程中修改集合

```java
List<String> list = new ArrayList<>();
...
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    if (element.equals("banana")) {
        list.remove(list.size() - 1); // 会抛出 ConcurrentModificationException 异常
    }
}
```

```
Exception in thread "main" java.util.ConcurrentModificationException
        at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
        at iterator.main(iterator.java:13)
```

### 在迭代过程中删除元素

虽说在迭代过程中修改集合会导致抛出 `ConcurrentModificationException` 异常，但在迭代过程中删除元素是可以的

使用 `Object.remove()` (`iterator.remove()`) 即可

```java
List<String> list = new ArrayList<>();
...
Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String element = iterator.next();
    if (element.equals("banana")) {
        iterator.remove(); // 不会抛出 ConcurrentModificationException 异常
    }
    System.out.println(list.size());
}
```

```
0
```

### ListIterator

相比于 `Iterator`，`ListIterator` 具有更多的功能，可以实现双向遍历、修改元素等操作

- `Object.hasNext()` 用于判断是否还有下一个元素
- `Object.next()` 用于返回下一个元素
- `Object.hasPrevious()` 用于判断是否还有上一个元素
- `Object.previous()` 用于返回上一个元素

```java
List<String> list = new ArrayList<>();
...
ListIterator<String> iterator = list.listIterator();
while (iterator.hasNext()) { // 正向遍历
    String element = iterator.next();
    System.out.println(element);
}

System.out.println("-----------------");

while (iterator.hasPrevious()) { // 反向遍历
    String element = iterator.previous();
    System.out.println(element);
}
```

```
Java
C
Rust
Python
-----------------
Python
Rust
C
Java
```

### forEachRemaining() 方法

`forEachRemaining()` 方法用于遍历剩余的元素

```java
List<String> list = new ArrayList<>();
...
Iterator<String> iterator = list.iterator();
iterator.forEachRemaining((element) -> {
    System.out.println(element);
});
```

## 总结

- Iterator 是一种用于遍历集合中元素的接口，它提供了一种统一的方式来访问集合中的元素，而不需要暴露集合的内部实现细节
- Iterator 可以用于遍历 List、Set、Map、Queue 等集合
- Iterator 提供了 `Object.hasNext()` 和 `Object.next()` 方法，用于判断是否还有下一个元素和返回下一个元素