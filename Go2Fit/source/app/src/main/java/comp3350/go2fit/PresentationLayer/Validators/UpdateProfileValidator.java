package comp3350.go2fit.PresentationLayer.Validators;

import android.app.Activity;
import android.widget.EditText;

import java.util.HashMap;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PresentationLayer.Messages;

public class UpdateProfileValidator {
    public static void validateNewInfo(HashMap users, EditText username, EditText password, EditText confirmPassword, Activity context)
    {
        UserManager userManager = new UserManager();
        UserModel userModel = userManager.getUser(CurrentUserService.getUserId());

        System.out.println("hbhjbjhbjhbuybhjn" + password.getText().toString());
        //if only username is being updated
        if(!username.getText().toString().equals("") && password.getText().toString().equals(""))
        {
            try {
                UserService userService = new UserService();
                userService.validateNoUser(users, username.getText().toString());

                userModel.setName(username.getText().toString());

                userManager.updateUser(userModel);

                Messages.notify(context, "You have updated your user name!");
            }
            catch(UserExistsException e)
            {
                username.setError("This username is already taken!");
            }
        }

        //if only password is being updated
        else if(username.getText().toString().equals("") && !password.getText().toString().equals(""))
        {
            try
            {
                PasswordService passwordService = new PasswordService();
                passwordService.passwordsMatch(password.getText().toString(), confirmPassword.getText().toString());

                try
                {
                    passwordService.validatePasswordLength(password.getText().toString());

                    userModel.setPassword(password.getText().toString());

                    userManager.updateUser(userModel);

                    Messages.notify(context, "Your Password is changed!");
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

        //if both are being updated
        else if(!username.getText().toString().equals("") && !password.getText().toString().equals("")) {
            try {
                UserService userService = new UserService();
                userService.validateNoUser(users, username.getText().toString());
                try {
                    PasswordService passwordService = new PasswordService();
                    passwordService.passwordsMatch(password.getText().toString(), confirmPassword.getText().toString());

                    try {
                        passwordService.validatePasswordLength(password.getText().toString());

                        userModel.setName(username.getText().toString());
                        userModel.setPassword(password.getText().toString());

                        userManager.updateUser(userModel);

                        Messages.notify(context, "You updated your information!");
                    } catch (PasswordToShortException e) {
                        password.setError("Password must be 7 characters long");
                    }
                } catch (PasswordsDontMatchException e) {
                    confirmPassword.setError("The passwords do not match!");
                }
            } catch (UserExistsException e) {
                username.setError("This username is already taken!");
            }
        }
    }
}
