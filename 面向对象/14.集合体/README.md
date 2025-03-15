# 集合体 (Aggregation)

## 定义

- 表示类之间的 'has-a' 关系
    -  'has-a' 关系表示一个类由另一个类的对象组成
    -  例如，一个部门由多个员工组成，一个公司由多个部门组成
- 一个类包含另一个类当作其中部分结构，但可以独立存在

## 代码示例

### 创建一个 `Book` 类

```java
// Book.java

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
```

### 测试 `Book` 类

```java
// Main.java

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Pride and Prejudice", "Jane Austen", 432);
        Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger", 224);
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee", 281);
        Book book4 = new Book("1984", "George Orwell", 328);
        Book[] books = {book1, book2, book3, book4};

        for (Book book : books) {
            System.out.println(book.displayInfo());
        }
    }
}
```

```
Pride and Prejudice by Jane Austen (432 pages)
The Catcher in the Rye by J.D. Salinger (224 pages)
To Kill a Mockingbird by Harper Lee (281 pages)
1984 by George Orwell (328 pages)
```

### 创建一个 `Library` 类并集合 `Book` 对象

```java
// Library.java

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
```

### 创建 `Library` 对象并测试

```java
// Main.java

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
```

```
The 1985 Library of Alexandria
Books available:
Pride and Prejudice by Jane Austen (432 pages)
The Catcher in the Rye by J.D. Salinger (224 pages)
To Kill a Mockingbird by Harper Lee (281 pages)
1984 by George Orwell (328 pages)
```

可以看到，`Library` 类包含了 `Book` 对象，并且可以独立存在，假设删除 `Library` 类，`Book` 对象仍然可以独立存在