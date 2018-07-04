package comp3350.go2fit.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
//import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.TrackProgressService;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

/**Current challenge**/
public class CurrentChallenge extends AppCompatActivity
{
    public CurrentChallenge() {}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final UserManager userManager = new UserManager();
        setContentView(R.layout.activity_current_challenge);

        Intent intent = getIntent();

        final ChallengesModelParceable currentChallenge = intent.getParcelableExtra("Current Challenge");

        System.out.println("ASDADADADADADAD"+currentChallenge.getModel().getChallengeName());

        String challengeName = currentChallenge.getModel().getChallengeName();
        String challengeType = currentChallenge.getModel().getChallengeType();
        int    numSteps      = currentChallenge.getModel().getStepsRequired();
        int    numPoints     = currentChallenge.getModel().getPoints();
        long   time          = currentChallenge.getModel().getTime();

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(challengeName);

        TextView type = (TextView) findViewById(R.id.challenge_type);
        type.setText(type.getText() + challengeType);

        TextView steps = (TextView) findViewById(R.id.steps);
        steps.setText(steps.getText() + Integer.toString(numSteps));

        TextView points = (TextView) findViewById(R.id.points);
        points.setText(points.getText() + Integer.toString(numPoints));

        String timeInHMS = TimeUI.convertToHMS(time);


        TextView timeAmount = (TextView) findViewById(R.id.time);
        timeAmount.setText(timeInHMS);


        /** Called when the user touches the button */
        final Button button= (Button)findViewById(R.id.button);

        if(!userManager.getUser(CurrentUserService.getUserId()).getChallengeStarted())
        {
            button.setEnabled(true);
        }
        else
        {
            button.setEnabled(false);
        }
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // click handling code
                UserModel user = userManager.getUser(CurrentUserService.getUserId());
                user.setCurrentChallenge(currentChallenge.getModel().getId());
                user.setChallengeStarted(true);
                userManager.updateUser(user);

                Messages.notify(CurrentChallenge.this,"You have just started a challenge! " +
                                        "Head over to the progress page to see your current progress!");

                button.setEnabled(false);
            }
        });
    }
}
