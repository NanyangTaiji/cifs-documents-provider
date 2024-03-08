package com.wa2c.android.cifsdocumentsprovider.common.exception;

/**
 * Edit exception.
 */
public abstract class EditException extends RuntimeException {

    /**
     * Input required exception.
     */
    public static class InputRequiredException extends EditException {}

    /**
     * Invalid ID exception.
     */
    public static class InvalidIdException extends EditException {}

    /**
     * Duplicated ID exception.
     */
    public static class DuplicatedIdException extends EditException {}
}

