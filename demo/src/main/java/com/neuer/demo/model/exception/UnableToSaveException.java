package com.neuer.demo.model.exception;

public class UnableToSaveException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public UnableToSaveException() {
        super();
    }

    public UnableToSaveException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnableToSaveException(String message) {
        super(message);
    }

    public UnableToSaveException(Throwable cause) {
        super(cause);
    }
}
