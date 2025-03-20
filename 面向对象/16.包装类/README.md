# 包装类

## 定义

- 允许基本类型 (int, double, boolean, char) 打包为对象
- **除非需要，否则不应该使用包装类**
- 允许使用集合框架静态实用方法

## 代码示例

### 使用包装类初始化对象

```java
Integer a = new Integer(100);
Double b = new Double(3.14);
Boolean c = new Boolean(true);
Character d = new Character('A');
```

但是这样会弹出警告：

```
The constructor Integer(int) has been deprecated since version 9 and marked for removal
The constructor Double(double) has been deprecated since version 9 and marked for removal
The constructor Boolean(boolean) has been deprecated since version 9 and marked for removal
The constructor Character(char) has been deprecated since version 9 and marked for removal
```

这是因为从 Java 9 开始，**这些构造函数被标记为过时的**，所以**直接初始化**即可

```java
Integer a = 100;
Double b = 3.14;
Boolean c = true;
Character d = 'A';
```

### 自动装箱

自动装箱是指**将<mark>基本类型</mark>自动转换为<mark>包装类对象</mark>的过程**

```java
Integer a = 100;
Double b = 3.14;
Boolean c = true;
Character d = 'A';
String e = "Hello"; // 字符串不是基本类型
```

### 自动拆箱

自动拆箱是指**将<mark>包装类对象</mark>自动转换为<mark>基本类型</mark>的过程**

```java
Integer a = 100;
int x = a; // 自动拆箱

Double b = 3.14;
double y = b; // 自动拆箱
```

### 调用包装类的实例方法


#### Object.toString()

用于将包装类对象转换为字符串

```java
String a = Integer.toString(100);
String b = Double.toString(3.14);
String c = Character.toString('@');
String d = Boolean.toString(true);

String x = a + b + c + d;
System.out.println(x);
```

###### 运行

```
1003.14@true
```

#### Object.parseXxx()

用于将字符串转换为基本类型

**注意： `char` 没有 `parseChar` 方法，需要使用 `String.charAt()` 方法获取指定位置的字符**

```java
int a = Integer.parseInt("100");
double b = Double.parseDouble("3.14");
// char c = Character.parseChar("@"); // char 没有 parseChar 方法
char c = "Hello".charAt(0); // 字符串可以使用 charAt 方法获取指定位置的字符
boolean d = Boolean.parseBoolean("true");

// String x = a + b + c + d; // 不能将 int、double、char、boolean 直接拼接为字符串
```

#### Character.isLetter()

用于判断字符是否为字母

```java
char a = 'A';
char b = '&';

System.out.println(Character.isLetter(a)); // true
System.out.println(Character.isLetter(b)); // false
```

##### 运行
```
true
false
```

#### Character.isUpperCase()

用于判断字符是否为大写字母

```java
char a = 'A';
char b = 'a';
System.out.println(Character.isUpperCase(a)); // true
System.out.println(Character.isUpperCase(b)); // false
```

##### 运行

```
true
false
```