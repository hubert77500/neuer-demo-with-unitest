package com.neuer.demo.model.exception;

public class UnableToDeleteException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public UnableToDeleteException() {
        super();
    }

    public UnableToDeleteException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToDeleteException(String message) {
        super(message);
    }

    public UnableToDeleteException(Throwable cause) {
        super(cause);
    }
}
