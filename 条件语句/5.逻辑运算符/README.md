# 逻辑运算符

## && —— 逻辑与

### 代码示例

```java
     double temp = 20;

    if (temp <= 30 && temp >= 0) {
        System.out.println("It's warm outside.");
    }
    else {
        System.out.println("It's cold outside.");
    }
```

逻辑与需要**所有条件都为真**，才会为 TRUE

## ! —— 逻辑非

### 代码示例

```java
    boolean isSunny = true;

    if (!isSunny) {
        System.out.println("It's cloudy outside.");
    }
    else {
        System.out.println("It's sunny outside.");
    }
```

逻辑非会将**条件取反**，TRUE 变为 FALSE，FALSE 变为 TRUE

## || —— 逻辑或

### 代码示例
```java
    double temp = 35;
    
    if (temp > 30 || temp < 0) {
        System.out.println("The weather is bad.");
    }
```

逻辑或**只需要有一个条件为真**，就会为 TRUE

[源代码](logic.java)