package com.neuer.demo.model.exception;

public class NoDataFoundException extends RuntimeException {

    /**
     * This is the wrapper to Throw custom Exceptions to use in developed try / catches
     * regarding what can happen in the logic fails and map error occurs in the code development.
     */
    private static final long serialVersionUID = 1L;

    public NoDataFoundException() {
        super();
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(Throwable cause) {
        super(cause);
    }
}
