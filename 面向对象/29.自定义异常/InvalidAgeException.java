public class InvalidAgeException extends Exception {
    public InvalidAgeException() {}
    public InvalidAgeException(String message) {
        super(message);
    }
    public InvalidAgeException(Throwable cause) {
        super(cause);
    }
    public InvalidAgeException(String message, Throwable cause) { // 也可以添加异常信息和异常原因
        super(message, cause);
    }
}
