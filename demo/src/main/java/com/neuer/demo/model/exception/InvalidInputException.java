package com.neuer.demo.model.exception;

public class InvalidInputException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
