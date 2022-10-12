package com.digitalrepublic.codechallenge.services.exceptions;

public class CantCompleteException extends RuntimeException {
        private static final long serialVersionUID = 1L;

    public CantCompleteException(String msg) {
            super(msg);
    }
}