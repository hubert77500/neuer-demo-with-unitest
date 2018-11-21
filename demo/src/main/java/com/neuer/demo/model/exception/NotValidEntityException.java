package com.neuer.demo.model.exception;

public class NotValidEntityException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public NotValidEntityException() {
        super();
    }

    public NotValidEntityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotValidEntityException(String message) {
        super(message);
    }

    public NotValidEntityException(Throwable cause) {
        super(cause);
    }
}
