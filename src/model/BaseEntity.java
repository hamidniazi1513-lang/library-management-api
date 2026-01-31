package model;

public abstract class BaseEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // This is the method the error is complaining about!
    public abstract String getItemType();
}