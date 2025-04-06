# 日期与时间

在Java中，有4个类与日期和时间相关：

- `LocalDate` —— 日期，如 2014-03-11，它可以存储生日、纪念日、加盟日期等
- `LocalTime` —— 时间，如 13:45:20
- `LocalDateTime` —— 日期和时间，如 2014-03-11 13:45:20
- `UTC Timestamp` —— 时间戳，如 2014-03-11T13:45:20Z

## 代码示例

### LocalDate

使用 `LocalDate.now()` 可以获取当前日期

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期: " + today);
    }
}
```

```
今天的日期: 2025-04-05
```

### LocalTime
使用 `LocalTime.now()` 可以获取当前时间


```java
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        System.out.println("当前的时间: " + time);
    }
}
```

```
当前的时间: 22:41:58.415960454
```

### LocalDateTime
使用 `LocalDateTime.now()` 可以获取当前**日期和时间**

```java
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        System.out.println("今天的日期和时间: " + today);
    }
}
```

```
今天的日期和时间: 2025-04-05T22:42:48.415960454
```

### UTC Timestamp

使用 `Instant.now()` 可以获取当前的时间戳

```java
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Instant timestamp = Instant.now();
        System.out.println("当前的时间戳: " + timestamp);
    }
}
```

```
当前的时间戳: 2025-04-05T14:44:32.247571840Z
```

### 格式化日期

使用 `DateTimeFormatter` 可以将日期格式化为字符串

```java
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println("今天的日期: " + date);
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String strDate1 = date.format(format1);
        System.out.println("日期格式化: " + strDate1);
    }
}
```

```
今天的日期: 2025-04-05
日期格式化: 05/04/2025
```

### 自定义日期

- `LocalDate.of()` 可以创建一个自定义的日期
- `LocalDateTime.of()` 可以创建一个自定义的日期和时间
- `LocalTime.of()` 可以创建一个自定义的时间

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 4, 4);
        System.out.println("自定义日期: " + date);
    }
}
```

```
自定义日期: 2025-04-04
```

```java
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(2025, 4, 4, 10, 20, 30);
        System.out.println("自定义日期和时间: " + date);
    }
}
```

```
自定义日期和时间: 2025-04-04T10:20:30
```

```java
import java.time.LocalTime;
public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.of(10, 20, 30);
        System.out.println("自定义时间: " + time);
    }
}
```

```
自定义时间: 10:20:30
```

### 比较日期

使用 `isBefore()`、`isAfter()`、`isEqual()` 可以比较日期

```java
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2025, 4, 4);
        if (date1.isBefore(date2)) {
            System.out.println("date1 在 date2 之前");
        }
        else if (date1.isAfter(date2)) {
            System.out.println("date1 在 date2 之后");
        }
        else if (date1.isEqual(date2)) {
            System.out.println("date1 与 date2 相等");
        }
    }
}

```
date1 在 date2 之前
```