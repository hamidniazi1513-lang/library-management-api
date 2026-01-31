package model;

import model.interfaces.Validatable;

public class Author extends BaseEntity implements Validatable {

    public Author(String name) {
        this.setName(name);
    }

    @Override
    public String getItemType() {
        return "AUTHOR";
    }

    @Override
    public void validate() {
        if (getName() == null || getName().trim().isEmpty()) {
            throw new RuntimeException("Author name cannot be empty!");
        }
    }
}