import model.Author;
import model.Book;
import service.BookService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Welcome to the Library Management System ---");

        try {
            // 1. Collect Data
            System.out.print("Enter Author Name: ");
            String authorName = scanner.nextLine();

            System.out.print("Enter Book Title: ");
            String bookTitle = scanner.nextLine();

            // 2. Register the book (Saves to Database - ONLY CALL ONCE)
            bookService.registerNewBook(bookTitle, authorName);

            // 3. Handle the "Borrowing" logic
            System.out.print("\nDo you want to borrow this book? (yes/no): ");
            String answer = scanner.nextLine();

            String status = "AVAILABLE"; // Default status

            if (answer.equalsIgnoreCase("yes")) {
                // Create local objects to use the interfaces
                Author author = new Author(authorName);
                Book book = new Book(bookTitle, author);

                book.borrow(); // This prints "Success! Borrowed..."
                status = "BORROWED";
            }

            // 4. Final Professional Output
            System.out.println("\n==========================================");
            System.out.println("            LIBRARY RECEIPT               ");
            System.out.println("==========================================");
            System.out.println("ID | Title           | Author       | Status");
            System.out.println("------------------------------------------");
            // Use printf to keep the columns lined up nicely
            System.out.printf("1  | %-15s | %-12s | %s\n", bookTitle, authorName, status);
            System.out.println("==========================================");
            System.out.println("SUCCESS! Operation completed.");

        } catch (Exception e) {
            System.out.println("\n[ERROR]: " + e.getMessage());
            System.out.println("TIP: Check if the 'author_name' column exists in your database!");
        } finally {
            scanner.close();
        }
    }
}