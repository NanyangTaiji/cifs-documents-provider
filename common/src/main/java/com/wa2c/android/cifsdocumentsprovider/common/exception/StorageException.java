package com.wa2c.android.cifsdocumentsprovider.common.exception;

import java.io.IOException;

/**
 * Edit exception.
 */
public abstract class StorageException extends IOException {

    public StorageException(String message) {
        super(message);
    }

    /**
     * File not found exception.
     */
    public static class FileNotFoundException extends StorageException {
        public FileNotFoundException() {
            super("File is not found.");
        }
    }

    /**
     * Access mode exception.
     */
    public static class AccessModeException extends StorageException {
        public AccessModeException() {
            super("Writing is not allowed in reading mode.");
        }
    }

    /**
     * Read-only exception.
     */
    public static class ReadOnlyException extends StorageException {
        public ReadOnlyException() {
            super("Writing is not allowed in options.");
        }
    }

    /**
     * Document ID exception.
     */
    public static class DocumentIdException extends StorageException {
        public DocumentIdException() {
            super("Invalid document id.");
        }
    }

    /**
     * Random access not permitted exception.
     */
    public static class RandomAccessNotPermittedException extends StorageException {
        public RandomAccessNotPermittedException() {
            super("This type does not support random writing.");
        }
    }
}

