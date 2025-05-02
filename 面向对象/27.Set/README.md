# Set

## 定义

`Set` 在Java中是一个接口，它继承了 `Collection` 接口，是一个集合，但是**它的元素是不重复的，并且是无序的**

## 语法

```java
Set<泛型> 变量名 = new HashSet<> / TreeSet<>() / LinkedHashSet<>();
```

## 代码示例

### Set 方法

#### 添加元素

```java
Set<String> set = new HashSet<>();
set.add("a"); // 添加元素
set.add("b");
set.add("c");
set.add("d");
System.out.println(set);
```

```
[a, b, c, d]
```

#### 尝试添加重复元素

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("a"); // 重复元素
System.out.println(set);
```

**此时只会添加一个元素**

```
[a]
```

#### 查看是否包含元素

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set.add("d");
System.out.println(set.contains("a")); // 查看是否包含元素
System.out.println(set.contains("e")); // 查看是否包含元素
```

```
true
false
```

#### 查看元素个数

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set.add("d");
System.out.println(set.size()); // 查看元素个数
```

```
4
```

#### 移除元素

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set.add("d");
set.remove("a"); // 移除元素
System.out.println(set);
```

```
[b, c, d]
```

#### 检查是否为空

```java
Set<String> set = new HashSet<>();
System.out.println(set.isEmpty()); // 检查是否为空
set.add("a");
System.out.println(set.isEmpty()); // 检查是否为空
```

```
true
false
```

#### 清空集合

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
System.out.println(set.isEmpty()); // 检查是否为空
set.clear(); // 清空集合
System.out.println(set.isEmpty()); // 检查是否为空
```

```
false
true
```

#### 遍历集合

##### 增强for循环

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set.add("d");
for (String s : set) {
    System.out.println(s); // 遍历集合
}
```

##### forEach方法

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set.add("d");
set.forEach(System.out::println); // 遍历集合
```

##### 迭代器

```java
Set<String> set = new HashSet<>();
set.add("a");
set.add("b");
set.add("c");
set.add("d");
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next()); // 遍历集合
}
```

```
a
b
c
d
```

### Set 实现类

#### HashSet

`HashSet` 是 `Set` 接口的一个实现类，它是基于哈希表 (`HashMap`) 的实现，插入和查找的时间复杂度是O(1)，但是**它是无序的，并且不能保证跟插入顺序一致**

```java
Set<String> set = new HashSet<>();
// 插入顺序为 b, d, a, c
set.add("b");
set.add("d");
set.add("a");
set.add("c");
System.out.println(set); // 输出顺序为 a, b, c, d
```

```
[a, b, c, d]
```

#### TreeSet

`TreeSet` 是 `Set` 接口的一个实现类，它是基于红黑树 (`TreeMap`) 的实现，插入和查找的时间复杂度是O(log n)，**它使用 `compareTo` 方法进行排序**

```java
Set<String> set = new TreeSet<>();
// 插入顺序为 b, d, a, c
set.add("b");
set.add("d");
set.add("a");
set.add("c");
System.out.println(set); // 输出顺序为 a, b, c, d
```

```
[a, b, c, d]
```

**注意：如果元素没有实现 `Comparable` 接口，会抛出 `ClassCastException` 异常**

例如插入 `Student` 对象

```java
// Student.java

public class Student {
    public String name;
    public int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new Student("a", 1));
        set.add(new Student("b", 2));
        set.add(new Student("c", 3));
        set.add(new Student("d", 4));
        System.out.println(set);
    }
}
```

此时会抛出 `ClassCastException` 异常

```
Exception in thread "main" java.lang.ClassCastException: Student cannot be cast to java.lang.Comparable
	at java.base/java.util.TreeMap.compare(TreeMap.java:1352)
	at java.base/java.util.TreeMap.put(TreeMap.java:537)
```

需要在 `Student` 类中**实现 `Comparable` 接口**

```java
// Student.java

public class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        if (this.age != other.age) {
            return this.age - other.age;
        }
        else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() { // 重写toString方法，方便输出
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();
        set.add(new student("b", 18));
        set.add(new student("d", 20));
        set.add(new student("a", 19));
        set.add(new student("c", 19));
        System.out.println(set);
    }
}
```

```
[Student{name='b', age=18}, Student{name='a', age=19}, Student{name='c', age=19}, Student{name='d', age=20}]
```

#### LinkedHashSet

`LinkedHashSet` 是 `Set` 接口的一个实现类，它是基于哈希表 (`HashMap`) 和链表 (`LinkedList`) 的实现，插入和查找的时间复杂度是O(1)，**它可以保证跟插入顺序一致**

```java
Set<String> set = new LinkedHashSet<>();
// 插入顺序为 b, d, a, c
set.add("b");
set.add("d");
set.add("a");
set.add("c");
System.out.println(set); // 输出顺序为 b, d, a, c
```

```
[b, d, a, c]
```