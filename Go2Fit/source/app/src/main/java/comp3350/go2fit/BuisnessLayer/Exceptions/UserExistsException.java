package comp3350.go2fit.BuisnessLayer.Exceptions;

public class UserExistsException extends IllegalArgumentException {

    public UserExistsException(String message)
    {
        super(message);
    }
}
