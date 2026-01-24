package service;

import repository.BookRepository;

public class BookService {

    private BookRepository repo = new BookRepository();

    public void run() {

        // CREATE
        repo.create("Clean Code", 464, 1);
        repo.create("Effective Java", 416, 2);
        repo.create("Clean Architecture", 432, 3);

        // READ
        repo.findAll();

        // DELETE (اختیاری – اگر استاد CRUD خواست)
        // repo.delete(1);
    }
}