package com.traulko.task6.exception;

public class BookStorageServiceException extends Exception {
    public BookStorageServiceException() {
        super();
    }

    public BookStorageServiceException(String message) {
        super(message);
    }

    public BookStorageServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public BookStorageServiceException(Throwable throwable) {
        super(throwable);
    }
}
