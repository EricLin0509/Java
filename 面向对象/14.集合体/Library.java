public class Library {
    
    String name;
    int year;
    Book[] books; // 集合 Book 对象

    Library(String name, int year, Book[] books) {
        this.name = name;
        this.year = year;
        this.books = books;
    }

    void displayInfo() {
        System.out.println("The " + this.year + " " + this.name);
        System.out.println("Books available: ");
        for (Book book : this.books) {
            System.out.println(book.displayInfo());
        }
    }

}