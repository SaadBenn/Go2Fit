package comp3350.go2fit.BuisnessLayer;

import android.hardware.SensorEvent;

/**Track progress service interface **/
public interface TrackProgressServiceInterface
{
    double calculateDistance(int numSteps);
    double calculateCaloriesBurned(double distance);
    int    determineProgress(int numSteps, int goalSteps);
}
