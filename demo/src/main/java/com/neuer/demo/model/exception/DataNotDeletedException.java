package com.neuer.demo.model.exception;

public class DataNotDeletedException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public DataNotDeletedException() {
        super();
    }

    public DataNotDeletedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNotDeletedException(String message) {
        super(message);
    }

    public DataNotDeletedException(Throwable cause) {
        super(cause);
    }
}
