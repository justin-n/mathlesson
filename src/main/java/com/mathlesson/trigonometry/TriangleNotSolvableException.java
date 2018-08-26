package com.mathlesson.trigonometry;

public class TriangleNotSolvableException extends Exception {

    public TriangleNotSolvableException() {
        super();
    }

    public TriangleNotSolvableException(String message) {
        super(message);
    }

    public TriangleNotSolvableException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleNotSolvableException(Throwable cause) {
        super(cause);
    }

    protected TriangleNotSolvableException(String message, Throwable cause,
                                           boolean enableSuppression,
                                           boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
