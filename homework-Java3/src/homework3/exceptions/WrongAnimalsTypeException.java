package homework3.exceptions;

public class WrongAnimalsTypeException extends Exception{
    public WrongAnimalsTypeException(String message) {
        super(message);
    }
}