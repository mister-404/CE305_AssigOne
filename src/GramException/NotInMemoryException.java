package GramException;

public class NotInMemoryException extends GramException {
    public NotInMemoryException(String unknownToken) {
        super("The token: \"" + unknownToken + "\" is not recognized as a keyword and cannot be found in memory");
    }
}
