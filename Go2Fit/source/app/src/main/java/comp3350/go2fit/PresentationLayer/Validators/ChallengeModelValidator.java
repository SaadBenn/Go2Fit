package comp3350.go2fit.PresentationLayer.Validators;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.PresentationLayer.Messages;

public class ChallengeModelValidator extends AppCompatActivity{

    public static boolean validateSteps(EditText steps, NumberPicker hours, NumberPicker minutes, Activity context)
    {
        String stepsValue = steps.getText().toString();

        boolean flag = true;
        try
        {
            ChallengesService challengesService = new ChallengesService();
            challengesService.verifyDistance(stepsValue);

            int hoursValue = hours.getValue();
            int minutesValue = minutes.getValue();

            long milliseconds = 0;
            try
            {
                challengesService.verifyTime(minutesValue, hoursValue);
                milliseconds = TimeUnit.MINUTES.toMillis(minutesValue) + TimeUnit.HOURS.toMillis(hoursValue);
            }
            catch(IllegalArgumentException e)
            {
                Messages.warning(context, "You cannot have a time of 0!");
                flag = false;
            }
        }
        catch(NumberFormatException e) {

            steps.setError("You must enter a valid number!");
            flag = false;
        }

        return flag;
    }
}
