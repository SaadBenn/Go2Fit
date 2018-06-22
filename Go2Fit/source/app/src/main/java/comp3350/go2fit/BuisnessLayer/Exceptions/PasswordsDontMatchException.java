package comp3350.go2fit.BuisnessLayer.Exceptions;

public class PasswordsDontMatchException extends Exception {

    public PasswordsDontMatchException(String message)
    {
        super(message);
    }
}
