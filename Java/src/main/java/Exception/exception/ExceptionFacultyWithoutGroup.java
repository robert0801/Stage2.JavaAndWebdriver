package Exception.exception;

public class ExceptionFacultyWithoutGroup extends Exception {
    public ExceptionFacultyWithoutGroup() {
    }

    public ExceptionFacultyWithoutGroup(String message) {
        super(message);
    }

    public ExceptionFacultyWithoutGroup(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionFacultyWithoutGroup(Throwable cause) {
        super(cause);
    }

    public ExceptionFacultyWithoutGroup(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
