package comp3350.go2fit.BuisnessLayer;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;
import comp3350.go2fit.PersistenceLayer.ChallengePersistenceStub;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.Application.Services;
import comp3350.go2fit.PersistenceLayer.UserPersistence;

public class TrackProgressService {
    long previousTime;

    public TrackProgressService()
    {
        previousTime = 0;
    }

    public int getAccelerometer(SensorEvent event, int currentSteps, int goalSteps) {
        int numSteps = currentSteps;

        float[] values = event.values;
        // Movement
        float x = values[0];
        float y = values[1];
        float z = values[2];

        float accelationSquareRoot = (x * x + y * y + z * z)
                / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
        long actualTime = System.currentTimeMillis()/1000;;

        if (accelationSquareRoot >= 2 && actualTime - previousTime > 0.5) //
        {
            numSteps++;
            previousTime = actualTime;
        }

        return numSteps;
    }

    public int determineProgress(int numSteps, int goalSteps)
    {
        double percentage = ((double) numSteps / goalSteps);
        return (int)(percentage * 100);

    }

    public String determineHours(long milliseconds)
    {
        String hours = Integer.toString((int)((milliseconds / (1000*60*60)) % 24));

        if(hours.length() == 1)
        {
            hours = "0" + hours;
        }
        return hours;
    }

    public String determineMinutes(long milliseconds)
    {
        String minutes = Integer.toString((int)((milliseconds / (1000*60)) % 60));

        if(minutes.length() == 1)
        {
            minutes = "0" + minutes;
        }
        return minutes;
    }
    public String determineSeconds(long milliseconds)
    {
        String seconds = Integer.toString((int)(milliseconds / 1000) % 60);

        if(seconds.length() == 1)
        {
            seconds = "0" + seconds;
        }
        return seconds;
    }

    public double calculateDistance(int numSteps)
    {
        double distanceFeet = numSteps * 2.3; //number of steps * 2.3 feet per step
        double distanceMeters = distanceFeet * 0.3048; //convert the distance in feet to meters...simpler this way

        return distanceMeters;
    }

    public double calculateCaloriesBurned(double distance)
    {
        double mileComplete = distance / 1609.34; //take the number of meters walked divided by number of meters in a mile
        double calories = (150 * 0.53) * mileComplete;

        return calories;
    }
}
