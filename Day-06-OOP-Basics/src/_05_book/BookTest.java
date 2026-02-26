package _05_book;

class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author, int pages, double price) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.isAvailable = true;    // Available by default
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Methods
    public void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + title + "' borrowed successfully!");
        } else {
            System.out.println("Book '" + title + "' is not available.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Book'" + title + "' returned successfully!");
        } else {
            System.out.println("Book '" + title + "' was not borrowed.");
        }
    }

    public void displayInfo() {
        System.out.println("\n--- Book Information ---");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Pages: " + pages);
        System.out.println("Price: $" + price);
        System.out.println("Status: " + (isAvailable() ? "Available" : "Borrowed"));
        System.out.println("----------------------\n");
    }
}

public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Robert Martin", 464, 45.99);
        Book book2 = new Book("Java Programming", "James Gosling", 800, 55.00);

        book1.displayInfo();
        book2.displayInfo();

        book1.borrowBook();
        book1.displayInfo();

        book1.returnBook();
        book1.displayInfo();
    }
}
