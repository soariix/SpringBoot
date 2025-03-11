package com.nelioalves.workshopmongo.services.exception;

public class ObjectNoFoundEception extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNoFoundEception(String msg) {
        super(msg);
    }
}
