# break和continue语句

## break 语句

break 语句用于跳出循环

### 语法

#### break 语句写法

```java
while(布尔表达式) {
  //循环内容
  if(布尔表达式) {
    break;
  }
}
```

#### 代码示例

例如循环10次强制退出循环

```java
int i = 0;
while (true) {
    i++;
    System.out.print(i + " ");
    if (i == 10) {
        break;
    }
}
System.out.println();
```

或者

```java
for (int i = 1; true; i++) {
  System.out.print(i + " ");
  if (i == 10) {
    break;
  }
}
System.out.println();
```

[源代码](Break.java)

#### 运行结果

```
1 2 3 4 5 6 7 8 9 10
```


## continue 语句

continue 适用于任何循环控制结构中的作用是让程序立刻跳转到下一次循环的迭代

在 for 循环中，continue 语句使程序立即跳转到更新语句

在 while 或者 do…while 循环中，程序立即跳转到布尔表达式的判断语句

### 语法

#### continue 语句写法

```java
while(布尔表达式) {
  //循环内容
  if(布尔表达式) {
    continue;
  }
}
```

#### 代码示例

例如循环10次，当i=5时，强制跳过本次循环

```java
int i = 0;
while (i < 10) {
    i++;
    if (i == 5) {
        continue;
    }
    System.out.print(i + " ");
}
System.out.println();
```

或者

```java
for (int i = 1; i < 10; i++) {
  if (i == 10) {
    continue;
  }
  System.out.print(i + " ");
}
System.out.println();
```

[源代码](Continue.java)

#### 运行结果

```
1 2 3 4 6 7 8 9 10
```