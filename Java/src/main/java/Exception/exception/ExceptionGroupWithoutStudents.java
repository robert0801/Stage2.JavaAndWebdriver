package Exception.exception;

public class ExceptionGroupWithoutStudents extends Exception {
    public ExceptionGroupWithoutStudents() {
    }

    public ExceptionGroupWithoutStudents(String message) {
        super(message);
    }

    public ExceptionGroupWithoutStudents(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionGroupWithoutStudents(Throwable cause) {
        super(cause);
    }

    public ExceptionGroupWithoutStudents(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
