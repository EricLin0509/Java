public class ternary {
    public static void main(String[] args) {
        
        // 判断成绩是否及格
        int score = 55;
        String result = score >= 60 ? "及格" : "不及格";
        System.out.println(result);


        // 判断是否为偶数
        int num = 10;
        String even_or_odd = num % 2 == 0? "偶数" : "奇数";
        System.out.println(even_or_odd);

    }
}
