package U09_EX_ExceptionsLogging.uebung2.exception;

@SuppressWarnings("unused")
public class InvalidTemperatureException extends Exception{
    /**
     * Default constructor with no message.
     */
    public InvalidTemperatureException() {
        super();
    }

    /**
     * Constructor with a custom error message.
     * @param message the error message
     */
    public InvalidTemperatureException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom error message and a cause.
     * @param message the error message
     * @param cause the cause of the exception
     */
    public InvalidTemperatureException(String message, Throwable cause) {
        super(message, cause);
    }
}
