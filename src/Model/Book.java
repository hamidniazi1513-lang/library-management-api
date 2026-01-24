package model;

public class Book extends LibraryItem
        implements Validatable, Borrowable {

    private Author author;
    private boolean borrowed = false;

    public Book(int id, String title, Author author) {
        super(id, title);
        this.author = author;
        validate();
    }


    @Override
    public void validate() {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
    }


    @Override
    public void borrow() {
        borrowed = true;
    }

    @Override
    public void returnItem() {
        borrowed = false;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    // ===== Polymorphism =====
    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public void displayInfo() {
        System.out.println(
                "Book: " + title +
                        " | Author: " + author.getName() +
                        " | Available: " + (!borrowed)
        );
    }

    // ===== Getters =====
    public Author getAuthor() {
        return author;
    }
}