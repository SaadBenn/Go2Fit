package comp3350.go2fit.Application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.os.Process;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import comp3350.go2fit.BuisnessLayer.Exceptions.NoPasswordFoundException;
import comp3350.go2fit.BuisnessLayer.Exceptions.NoUserFoundException;
import comp3350.go2fit.BuisnessLayer.PasswordService;
import comp3350.go2fit.BuisnessLayer.UserService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.PresentationLayer.SignUpPage;
import comp3350.go2fit.R;


/**The start up to the application**/
public class StartUp extends AppCompatActivity
{
    public Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_up);

        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startApp();
            }
        });

        TextView signUp = (TextView) findViewById(R.id.textView11);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });
    }

    public void startApp()
    {
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        UserManager userManager = new UserManager();
        HashMap users = userManager.getAllUsers();

        UserService userService = new UserService();
        try {
            int index = userService.findUser(users, username.getText().toString());

            UserModel userModel = (UserModel) users.get(index);

            try {
                PasswordService passwordService = new PasswordService();
                passwordService.validatePassword(userModel.getPassword(), password.getText().toString());

                CurrentUserService.setUserId(index);

                Intent startApp = new Intent(this, MainActivity.class);
                startActivity(startApp);
            }
            catch(NoPasswordFoundException e)
            {
                password.setError(e.getMessage());
            }

        }
        catch(NoUserFoundException e)
        {
            username.setError(e.getMessage());
        }
    }

    public void signUpUser()
    {
        Intent signUp = new Intent(this, SignUpPage.class);
        startActivity(signUp);
    }

    public void exitApp(View v)
    {
        moveTaskToBack(true);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
