package com.mathlesson.trigonometry;

public class NotATriangleException extends Exception {

    public NotATriangleException() {
        super();
    }

    public NotATriangleException(String message) {
        super(message);
    }

    public NotATriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotATriangleException(Throwable cause) {
        super(cause);
    }

    protected NotATriangleException(String message, Throwable cause,
                                    boolean enableSuppression,
                                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
