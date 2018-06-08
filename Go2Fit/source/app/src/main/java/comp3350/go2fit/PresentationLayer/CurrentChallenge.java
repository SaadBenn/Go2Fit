package comp3350.go2fit.PresentationLayer;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
//import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.go2fit.Application.PagerAdapter;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

public class CurrentChallenge extends AppCompatActivity
{
    public CurrentChallenge()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        final UserManager userManager = new UserManager();
        setContentView(R.layout.activity_current_challenge);

        Intent intent = getIntent();

        final ChallengesModel currentChallenge = intent.getParcelableExtra("Current Challenge");

        String challengeName = currentChallenge.getChallengeName();
        String challengeType = currentChallenge.getChallengeType();
        int numSteps = currentChallenge.getStepsRequired();
        int numPoints = currentChallenge.getPoints();
        long time = currentChallenge.getTime();

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(challengeName);

        TextView type = (TextView) findViewById(R.id.challenge_type);
        type.setText(type.getText() + challengeType);

        TextView steps = (TextView) findViewById(R.id.steps);
        steps.setText(steps.getText() + Integer.toString(numSteps));

        TextView points = (TextView) findViewById(R.id.points);
        points.setText(points.getText() + Integer.toString(numPoints));

        TextView timeAmount = (TextView) findViewById(R.id.time);
        timeAmount.setText(points.getText() + Integer.toString(numPoints));

        //TextView Id = findViewById(R.id.Id);
        //Id.setText("" + id);


        /** Called when the user touches the button */
        final Button button= (Button)findViewById(R.id.button);

        if(!userManager.getUser(2).getChallengeStarted())
        {
            button.setEnabled(true);
        }
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                // click handling code
                UserModel user = userManager.getUser(2);
                user.setCurrentChallenge(currentChallenge.getId());
                user.setChallengeStarted(true);
                userManager.updateUser(user);

                Messages.notify(CurrentChallenge.this,"You have just started a challenge! " +
                                        "Head over to the progress page to see your current progress!");

                button.setEnabled(false);

            }
        });
    }

}