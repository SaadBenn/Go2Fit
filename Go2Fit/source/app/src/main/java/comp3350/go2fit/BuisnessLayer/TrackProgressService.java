package comp3350.go2fit.BuisnessLayer;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistence;
import comp3350.go2fit.PersistenceLayer.TrackProgressPersistenceStub;

public class TrackProgressService {
    long previousTime;
    TrackProgressPersistence database;
    public TrackProgressService()
    {
        previousTime = 0;
        database = new TrackProgressPersistenceStub();
        database.initializeDatabase();
    }
    public TrackProgressModel getAccelerometer(SensorEvent event, TrackProgressModel current, int goalSteps) {
        int numSteps = current.getNumSteps();

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
            current.setNumSteps(numSteps);

            double percentage = ((double) current.getNumSteps() / goalSteps);
            current.setPercentageComplete((int)(percentage * 100));
            previousTime = actualTime;
        }

        return current;
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

    public double calculateDistance(TrackProgressModel model)
    {
        double distanceFeet = model.getNumSteps() * 2.3; //number of steps * 2.3 feet per step
        double distanceMeters = distanceFeet * 0.3048; //convert the distance in feet to meters...simpler this way

        model.setDistance(distanceMeters);
        return distanceMeters;
    }

    public double calculateCaloriesBurned(TrackProgressModel model)
    {
        double mileComplete = model.getDistance() / 1609.34; //take the number of meters walked divded by number of meters in a mile
        double calories = (150 * 0.53) * mileComplete;

        return calories;
    }


    public TrackProgressModel getProgress(int userId)
    {
        return database.getProgress(userId);
    }

    public void updateDatabase(TrackProgressModel progress)
    {
        database.add(progress);
    }
}