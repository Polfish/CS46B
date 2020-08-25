package dna;

/**
 * An exception that is thrown when a record is in the wrong format
 */
public class RecordFormatException extends Exception {
    public RecordFormatException(String message) {
        super(message);
    }
}
