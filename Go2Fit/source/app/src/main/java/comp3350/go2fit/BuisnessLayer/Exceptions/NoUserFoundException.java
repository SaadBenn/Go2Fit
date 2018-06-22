package comp3350.go2fit.BuisnessLayer.Exceptions;

public class NoUserFoundException extends IllegalArgumentException {

    public NoUserFoundException(String message)
    {
        super(message);
    }
}
