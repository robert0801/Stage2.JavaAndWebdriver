package Exception.exception;

public class ExceptionStudentsWithoutSubject extends Exception {
    public ExceptionStudentsWithoutSubject() {
    }

    public ExceptionStudentsWithoutSubject(String message) {
        super(message);
    }

    public ExceptionStudentsWithoutSubject(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionStudentsWithoutSubject(Throwable cause) {
        super(cause);
    }

    public ExceptionStudentsWithoutSubject(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
