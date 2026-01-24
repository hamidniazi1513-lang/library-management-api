package Model;

import exception.InvalidInputException;

public class Book extends model.LibraryItem implements Validatable, model.Borrowable {

    private Model.Author author;
    private int pages;
    private boolean available = true;

    public Book(int id, String title, Model.Author author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public void displayInfo() {
        // نام نویسنده را از شیء Author می‌گیرد
        System.out.println("Book: " + getTitle() + " | " + (author != null ? author.getName() : "Unknown"));
    }

    @Override
    public void validate() {
        // فیلد title در کلاس LibraryItem تعریف شده، مطمئن شوید دسترسی دارد
        if (getTitle() == null || getTitle().isEmpty())
            throw new InvalidInputException("Title cannot be empty");
        if (pages <= 0)
            throw new InvalidInputException("Pages must be > 0");
        if (author == null)
            throw new InvalidInputException("Author required");
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // گترها برای استفاده در BookRepository جهت ذخیره در دیتابیس
    public Author getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }
}