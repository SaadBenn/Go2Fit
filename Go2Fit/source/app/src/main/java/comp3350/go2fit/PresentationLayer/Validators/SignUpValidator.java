package comp3350.go2fit.PresentationLayer.Validators;

import android.app.Activity;
import android.widget.EditText;

import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PresentationLayer.Messages;

public class SignUpValidator {
    public static void validateUser(HashMap users, EditText username, EditText password, EditText confirmPassword, Activity context)
    {
        UserManager userManager = new UserManager();
        try
        {
            UserService userService = new UserService();
            userService.validateNoUser(users, username.getText().toString());
            try
            {
                PasswordService passwordService = new PasswordService();
                passwordService.passwordsMatch(password.getText().toString(), confirmPassword.getText().toString());

                try
                {
                    passwordService.validatePasswordLength(password.getText().toString());

                    UserModel userModel = new UserModel();
                    userModel.setName(username.getText().toString());
                    userModel.setPassword(password.getText().toString());

                    userManager.addUser(userModel);

                    Messages.notify(context, "Your all signed up!");
                }
                catch(PasswordToShortException e)
                {
                    password.setError("Password must be 7 characters long");
                }
            }
            catch(PasswordsDontMatchException e)
            {
                confirmPassword.setError("The passwords do not match!");
            }
        }
        catch(UserExistsException e)
        {
            username.setError("This username is already taken!");
        }

    }
}
