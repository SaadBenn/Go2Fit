package comp3350.go2fit.Application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.os.Process;


import comp3350.go2fit.R;

public class StartUp extends AppCompatActivity {

    public Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
    }

    public void startApp() {
        Intent startApp = new Intent(this, MainActivity.class);
        startActivity(startApp);
    }

    public void exitApp(View v) {
        moveTaskToBack(true);
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
