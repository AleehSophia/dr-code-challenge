package com.digitalrepublic.codechallenge.services.exceptions;

public class BalanceCantCompleteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BalanceCantCompleteException(String msg) {
        super(msg);
    }
}