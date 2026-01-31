package model;

import model.interfaces.Borrowable;
import model.interfaces.Validatable;

public class Book extends BaseEntity implements Validatable, Borrowable {
    private final Author author; // Fixed: Field is now final
    private boolean isAvailable = true;

    public Book(String title, Author author) {
        this.setName(title);
        this.author = author;
    }

    @Override
    public String getItemType() {
        return "BOOK";
    }

    @Override
    public void validate() {
        if (getName() == null || getName().trim().isEmpty()) {
            throw new RuntimeException("Book title cannot be empty!");
        }
        if (author == null) {
            throw new RuntimeException("Book must have an author!");
        }
    }

    @Override
    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Success! Borrowed '" + getName() + "' by " + author.getName());
        } else {
            System.out.println("Error: '" + getName() + "' is already borrowed.");
        }
    }

    // Fixed: Added the missing returnBook method
    @Override
    public void returnBook() {
        isAvailable = true;
        System.out.println("Status: '" + getName() + "' has been returned.");
    }
}