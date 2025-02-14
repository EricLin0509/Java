# 可变参数

## 定义

可变参数，是指参数的个数是可变的，用户可以传入0个或任意多个参数

## 语法

### 写法

```java
返回值 方法名(参数类型... 参数名) {
    执行语句
}
```

**Java 会将可变参数当做数组处理**

### 代码示例

#### 计算多个数的和

```java
public static void main(String[] args) {
    int sum = add(1, 2, 3, 4, 5);
    System.out.println(sum);
}
static int add(int... numbers) {
    int sum = 0;
    for (int number : numbers) {
        sum += number;
    }
    return sum;
}
```

#### 计算多个数的平均值

```java
public static void main(String[] args) {
    double average = average(1, 2, 3, 4, 5);
    System.out.println(average);
}
static double average(double... numbers) {
    double sum = 0;
    for (double number : numbers) {
        sum += number;
    }
    return sum / numbers.length;
}