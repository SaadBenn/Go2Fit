package comp3350.go2fit.BuisnessLayer;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoPasswordFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;

public class PasswordService {

    public void validatePassword(String userModelPassword, String entryPassword) throws NoPasswordFoundException
    {
        if(!userModelPassword.equals(entryPassword)){
            throw new NoPasswordFoundException();
        }
    }

    public void passwordsMatch(String password1, String password2) throws PasswordsDontMatchException
    {
        if(!password1.equals(password2))
        {
            throw new PasswordsDontMatchException();
        }
    }

    public void validatePasswordLength(String password) throws PasswordToShortException
    {
        if(password.length() < 7)
        {
            throw new PasswordToShortException();
        }
    }
}
