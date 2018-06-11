package comp3350.go2fit.BuisnessLayer;

import android.hardware.SensorEvent;

/**Track progress service interface **/
public interface TrackProgressServiceInterface
{
    String determineHours(long milliseconds);
    String determineMinutes(long milliseconds);
    String determineSeconds(long milliseconds);
    double calculateDistance(int numSteps);
    double calculateCaloriesBurned(double distance);
    int    determineProgress(int numSteps, int goalSteps);
}
