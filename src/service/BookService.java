package service;

import model.Author;
import model.Book;
import repository.AuthorRepository;
import repository.BookRepository;

public class BookService {
    private final AuthorRepository authorRepo = new AuthorRepository();
    private final BookRepository bookRepo = new BookRepository();

    public void registerNewBook(String title, String authorName) throws Exception {
        Author author = new Author(authorName);
        author.validate();

        Book book = new Book(title, author);
        book.validate();

        // Save to database
        authorRepo.save(author);
        bookRepo.save(book);

        System.out.println("Library System: '" + title + "' by " + authorName + " has been registered in the database.");
    }
}