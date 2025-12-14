import java.util.Scanner;

class Book {
    String name;
    String author;
    int price;
    int numPages;

    Book(String name, String author, int price, int numPages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "Book Name: " + name + "\n"
             + "Author Name: " + author + "\n"
             + "Price: " + price + "\n"
             + "Number of Pages: " + numPages + "\n";
    }
}

public class BookStore {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = s.nextInt();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            s.nextLine(); // clear buffer
            System.out.println("\nEnter details for Book " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = s.nextLine();

            System.out.print("Author: ");
            String author = s.nextLine();

            System.out.print("Price: ");
            int price = s.nextInt();

            System.out.print("Number of pages: ");
            int numPages = s.nextInt();

            books[i] = new Book(name, author, price, numPages);
        }

        System.out.println("\n--- Book Details ---");
        for (Book b : books) {
            System.out.println(b);
        }

        s.close();
    }
}
