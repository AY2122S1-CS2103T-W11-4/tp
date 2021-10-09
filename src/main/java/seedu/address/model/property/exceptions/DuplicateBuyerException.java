package seedu.address.model.property.exceptions;

/**
 * Signals that the operation will result in duplicate Properties (Properties are considered duplicates
 * if they have the same identity).
 */
public class DuplicateBuyerException extends RuntimeException {
    public DuplicateBuyerException() {
        super("Operation would result in duplicate buyers");
    }
}