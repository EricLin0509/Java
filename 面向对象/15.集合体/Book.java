public class Book {

    String title;
    String author;
    int pages;

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    String displayInfo() {
        return this.title + " by " + this.author + " (" + this.pages + " pages)";
    }

}