package model.interfaces;

public interface Validatable {

    static void printInfo() {
        System.out.println("Validatable interface is active");
    }

    void validate();

    default boolean isValid() {
        try {
            validate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
