import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Target({ElementType.TYPE, ElementType.METHOD}) // 允许作用于类、接口、注解、方法
@Retention(RetentionPolicy.RUNTIME) // 运行时保留
public @interface Animal {
    String Type();
}