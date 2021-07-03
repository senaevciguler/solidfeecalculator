package com.grafanalabs.exception;

public class GrafanaException extends RuntimeException {
    public GrafanaException(String message) {
        super(message);
    }
}

