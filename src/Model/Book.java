package model;

public class Book extends LibraryItem implements Validatable, Borrowable {

    private Author author;
    private boolean borrowed = false;

    // ===== Constructor =====
    public Book(int id, String title, Author author) {
        super(id, title); // calls LibraryItem constructor
        this.author = author;
        validate();       // validate author and title
    }

    // ===== Validation =====
    @Override
    public void validate() {
        if (title == null || title.trim().isEmpty()) {  // replaced isBlank() with trim().isEmpty()
            throw new IllegalArgumentException("Book title cannot be empty");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
    }

    // ===== Borrowable methods =====
    @Override
    public void borrow() {
        borrowed = true;
    }

    @Override
    public void returnItem() {
        borrowed = false;
    }

    @Override
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

    // ===== Getter =====
    public Author getAuthor() {
        return author;
    }
}
