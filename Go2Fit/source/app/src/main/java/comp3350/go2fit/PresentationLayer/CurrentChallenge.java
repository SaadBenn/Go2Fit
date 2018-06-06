package comp3350.go2fit.PresentationLayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.R;

public class CurrentChallenge extends AppCompatActivity
{
    private ChallengesService challengesService;

    public CurrentChallenge()
    {
        challengesService = new ChallengesService();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_challenge);


        /** Called when the user touches the button */
        Button button= (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                // click handling code
//              challengesService.launchTrackProgesss();

            }
        });



        Intent intent = getIntent();

        ChallengesModel currentChallenge = intent.getParcelableExtra("Current Challenge");

        String challengeType = currentChallenge.getChallengeName();
        int id               = currentChallenge.getId();


        TextView Type = findViewById(R.id.Type);
        Type.setText(challengeType);

        TextView Id = findViewById(R.id.Id);
        Id.setText("" + id);

    }

}
