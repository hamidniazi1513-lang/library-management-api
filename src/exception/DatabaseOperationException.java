package exception;

public class DatabaseOperationException extends RuntimeException {
    public DatabaseOperationException(String msg, Throwable e) {
        super(msg, e);
    }
}