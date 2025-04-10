public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", 432);
        Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger", 224);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 281);
        Book book4 = new Book("1984", "George Orwell", 328);
        Book[] books = {book1, book2, book3, book4};
        
        Library library = new Library("Library of Alexandria", 1985, books);

        library.displayInfo();
    }
}