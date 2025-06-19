# @Component

## 简介

跟 `@Configuration` 类似，`@Component` 注解也可用于将类标记为 Spring Bean

## 代码示例

### 删除 `Config.java` 文件

由于使用 `@Component` 注解，所以之前使用 `@Configuration` 注解配置Bean的类不需要再使用 `@Configuration` 注解了

![delete](imgs/delete.png)

此时会报错

```
Parameter 0 of constructor in com.example.colour.ColourApplication required a bean of type 'com.example.colour.services.ColourPrinter' that could not be found.
```

这是因为 `com.example.colour.services.ColourPrinter` 是一个 Bean，但由于 `ColourApplication` 类没有使用 `@Component` 注解，所以 Spring 无法识别它

### 添加 `@Component` 注解

在 `src/main/java/com/example/colour/impl/ColourPrinterImpl.java` 文件上方添加 `@Component` 注解

![add](imgs/add.png)

这相当于告诉 Spring 这个类是一个 Bean，并将其注册到 Spring 容器中

同时这个类的**构造函数**相当于告诉 Spring **需要哪些依赖**才能实例化这个 Bean

所以也要在依赖类上 (此处为 `Red`、`Green`、`Blue` 类) 添加 `@Component` 注解

![add2](imgs/add2.png)
![add3](imgs/add3.png)
![add4](imgs/add4.png)

这样就可以正常运行了

```
2025-06-19T23:30:11.269+08:00  INFO 44827 --- [colour] [           main] com.example.colour.ColourApplication     : red, blue, green
```

### 切换依赖

如果需要切换依赖，只需要修改 `@Component` 注解的类名即可

假设现在要用中文输出 (此处为 `RedCN`、`GreenCN`、`BlueCN` 类)，只需要先移除英文依赖，再添加中文依赖

![switch](imgs/switch.png)

```
2025-06-19T23:33:48.570+08:00  INFO 46423 --- [colour] [           main] com.example.colour.ColourApplication     : 红色, 蓝色, 绿色
```

## 区别

| 注解 | 核心目的 | 适用场景 |
| :------: | :----------: | :----------: |
| `@Configuration` | **显式声明Bean配置**，定义如何创建复杂的、需要控制的Bean | 专门用于配置类（如数据源、整合第三方组件） |
| `@Component` | **通用组件扫描**，标记自动注册的Bean | 业务逻辑层（如`@Service`, `@Controller`, `@Repository`，由Spring自动管理生命周期） |

### 使用场景

| 场景 | 选择注解 |
| :--------: | :----------: |
| 定义需要手动初始化的Bean（如配置第三方库） | `@Configuration` + `@Bean` |
| 多个Bean存在相互依赖，需保证单例 | `@Configuration`（避免`@Component`导致重复实例化） |
| 业务逻辑组件（如Service、Mapper） | `@Component`或其派生注解（如`@Service`） |
| 需要自动扫描并注入的普通类 | `@Component` |
