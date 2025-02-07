# 变量作用域

## 定义

变量的作用域指的是变量的有效范围，Java分为类变量和局部变量

## 局部变量

局部变量是在函数内部定义的变量，只能在函数内部使用，函数执行完毕后，局部变量会被销毁

### 代码示例

```java
public static void main(String[] args) {
    int a = 10;
    System.out.println(a); // a 是局部变量
}
static void test() {
    System.out.println(a);
}
```

#### 编译

```bash
Main.java:5: 错误: 找不到符号
        System.out.println(a);
                            ^
  符号:   变量 a
  位置: 类 Main
1 个错误
```

这是因为 a 是局部变量，只能在 `main` 函数内部使用

```java
public static void main(String[] args) {
    int a = 10;
    System.out.println(a); // a 是局部变量
    test();
}
static void test() {
    int a = 20;
    System.out.println(a);
}
```
#### 运行

```bash
10
20
```

不同的函数可以定义相同的局部变量，但是它们之间是独立的，互不影响

## 类变量

类变量是在类中定义的变量，它可以在类的任何地方使用，类变量的生命周期是整个程序的运行时间

### 代码示例

```java
int a = 10;

public static void main(String[] args) {
    System.out.println(a);
    test();
}

static void test() {
    System.out.println(a);
}
```

#### 运行

```bash
10
10
```

类变量可以在类的任何地方使用，包括函数内部

```java
int a = 10;

public static void main(String[] args) {
    int a = 20;
    System.out.println(a);
    test();
}

static void test() {
    int a = 30;
    System.out.println(a);
}
```

#### 运行

```bash
20
30
```

类变量可以与局部变量同名，但是Java会优先使用局部变量