class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println(title + " has been issued.");
        } else {
            System.out.println(title + " is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not issued.");
        }
    }

    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Issued: " + isIssued);
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Library.java
class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void showAvailableBooks() {
        System.out.println("\nAvailable Books:");
        for (Book book : books) {
            if (!book.isIssued()) {
                book.displayInfo();
            }
        }
    }

    public void issueBook(String bookTitle, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && !book.isIssued()) {
                book.issueBook();
                System.out.println("Issued to: " + user.getName());
                return;
            }
        }
        System.out.println("Sorry, book not available for issue.");
    }

    public void returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && book.isIssued()) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling");
        Book b2 = new Book("Data Structures", "Robert Lafore");
        Book b3 = new Book("Effective Java", "Joshua Bloch");

        Library library = new Library(new Book[]{b1, b2, b3});

        User user = new User("Vamshi");

        library.showAvailableBooks();

        library.issueBook("Java Basics", user);

        library.showAvailableBooks();

        library.returnBook("Java Basics");

        library.showAvailableBooks();
    }
}
