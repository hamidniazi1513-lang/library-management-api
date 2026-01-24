package service;

import model.Book;
import repository.BookRepository;

import java.util.List;

public class BookService {

    private final BookRepository repository =
            new BookRepository();

    public void addBook(Book book) {
        repository.create(book);
    }

    public List<Book> listBooks() {
        return repository.getAll();
    }

    public void removeBook(int id) {
        repository.delete(id);
    }
}