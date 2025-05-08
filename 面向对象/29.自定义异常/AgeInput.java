public class AgeInput {
    public static void main(String[] args) throws InvalidAgeException {
        validAge(121);
    }

    public static void validAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Invalid age", new RuntimeException());
        }
    }
}