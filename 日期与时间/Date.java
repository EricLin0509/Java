import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Date {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期: " + today);

        LocalTime time = LocalTime.now();
        System.out.println("当前的时间: " + time);

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println("今天的日期和时间: " + datetime);

        Instant timestamp = Instant.now();
        System.out.println("当前的时间戳: " + timestamp);

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateFormatted = today.format(format1);
        System.out.println("日期格式化: " + dateFormatted);

        LocalDate date = LocalDate.of(2025, 4, 4);
        System.out.println("自定义日期: " + date);

        datetime = LocalDateTime.of(2025, 4, 4, 10, 20, 30);
        System.out.println("自定义日期和时间: " + datetime);

        time = LocalTime.of(10, 20, 30);
        System.out.println("自定义时间: " + time);
    }
}