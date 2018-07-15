package comp3350.go2fit.PresentationLayer;

import android.os.Bundle;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.PresentationLayer.Validators.SignUpValidator;
import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordToShortException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.Models.UserModel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;


import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.Exceptions.PasswordsDontMatchException;
import comp3350.go2fit.BuisnessLayer.Exceptions.UserExistsException;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.PresentationLayer.Validators.UpdateProfileValidator;
import comp3350.go2fit.R;

public class UpdateProfilePage extends AppCompatActivity {
    private static int GALLERY_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile_page);

        Button signUpButton = (Button) findViewById(R.id.sign_up_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });
    }

    private void updateUser()
    {
        UserManager userManager = new UserManager();
        HashMap users = (HashMap)userManager.getAllUsers();

        EditText username = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);
        EditText confirmPassword = (EditText) findViewById(R.id.confirm_password_input);

        UpdateProfileValidator.validateNewInfo(users, username, password, confirmPassword, this);
    }

}
