public class stringmethod {
    public static void main(String[] args) {
        
        String str = "   Hello World!   ";

        int str_length = str.length(); // 字符串长度
        System.out.println(str_length);

        char letter = str.charAt(0); // 字符串指定位置字符，即 'H'
        System.out.println(letter);

        int index = str.indexOf('l'); // 字符串指定字符首次出现位置，即 2
        System.out.println(index);

        int last_index = str.lastIndexOf('l'); // 字符串指定字符最后出现位置，即 3
        System.out.println(last_index);

        str = str.toUpperCase(); // 字符串转大写
        System.out.println(str);

        str = str.toLowerCase(); // 字符串转小写
        System.out.println(str);

        str = str.trim(); // 字符串去首尾空格
        System.out.println(str);

        str = str.replace('l', 'w'); // 字符串替换
        System.out.println(str);

        System.out.println(str.isEmpty()); // 判断字符串是否为空

        System.out.println(str.contains(" ")); // 判断字符串是否包含指定字符
        
        System.out.println(str.equals("hello world!")); // 判断字符串是否相等

        str = str.substring(1, 3); // 字符串截取，范围左闭右开，即 'ew'
        System.out.println(str);

        char chars[] = str.toCharArray(); // 字符串转字符数组
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println();

        String str2 = String.valueOf(chars); // 字符数组转字符串
        System.out.println(str2);
    }
}
