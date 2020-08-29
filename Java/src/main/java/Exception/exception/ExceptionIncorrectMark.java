package Exception.exception;

public class ExceptionIncorrectMark extends Exception {
    public ExceptionIncorrectMark() {
    }

    public ExceptionIncorrectMark(String message) {
        super(message);
    }

    public ExceptionIncorrectMark(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionIncorrectMark(Throwable cause) {
        super(cause);
    }

    public ExceptionIncorrectMark(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
