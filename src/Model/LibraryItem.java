package model;

public abstract class LibraryItem {

    protected int id;
    protected String title;

    public LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public abstract String getItemType();
    public abstract void displayInfo();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}