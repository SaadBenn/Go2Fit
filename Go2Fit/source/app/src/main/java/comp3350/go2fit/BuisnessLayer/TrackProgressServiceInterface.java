package comp3350.go2fit.BuisnessLayer;

import android.hardware.SensorEvent;

public interface TrackProgressServiceInterface {
    int determineProgress(int numSteps, int goalSteps);
    String determineHours(long milliseconds);
    String determineMinutes(long milliseconds);
    String determineSeconds(long milliseconds);
    double calculateDistance(int numSteps);
    double calculateCaloriesBurned(double distance);
}
