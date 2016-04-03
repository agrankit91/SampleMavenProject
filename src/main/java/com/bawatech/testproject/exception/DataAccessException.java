package com.bawatech.testproject.exception;

/**
 * Created by ankit on 4/2/2016.
 */
public class DataAccessException extends Exception {
    public DataAccessException() {
        super();
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
