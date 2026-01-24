import model.Author;
import model.Book;
import service.BookService;

public class Main {

    public static void main(String[] args) {

        BookService service = new BookService();

        Author author = new Author(1, "Fyodor Dostoevsky");
        Book book = new Book(0, "Crime and Punishment", author);

        service.addBook(book);

        System.out.println("📚 All Books:");
        service.listBooks().forEach(Book::displayInfo);

        service.removeBook(0);
        System.out.println("❌ Book deleted");
    }
}
