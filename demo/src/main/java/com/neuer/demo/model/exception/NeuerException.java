package com.neuer.demo.model.exception;

public class NeuerException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public NeuerException() {
        super();
    }

    public NeuerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NeuerException(String message) {
        super(message);
    }

    public NeuerException(Throwable cause) {
        super(cause);
    }
}
