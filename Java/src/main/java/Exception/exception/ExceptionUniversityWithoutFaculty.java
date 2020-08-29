package Exception.exception;

public class ExceptionUniversityWithoutFaculty extends Exception {
    public ExceptionUniversityWithoutFaculty() {
    }

    public ExceptionUniversityWithoutFaculty(String message) {
        super(message);
    }

    public ExceptionUniversityWithoutFaculty(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionUniversityWithoutFaculty(Throwable cause) {
        super(cause);
    }

    public ExceptionUniversityWithoutFaculty(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
