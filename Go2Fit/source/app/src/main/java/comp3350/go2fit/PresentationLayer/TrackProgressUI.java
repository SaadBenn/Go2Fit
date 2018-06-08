package comp3350.go2fit.PresentationLayer;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.CountDownTimer;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ProgressManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.BuisnessLayer.TrackProgressService;

public class TrackProgressUI extends Fragment implements SensorEventListener {
    private SensorManager sensorManager;
    private TrackProgressModel progressModel;
    private TrackProgressService progressService;
    private ProgressManager progressManager;
    private UserManager userManager;
    private ChallengeManager challengeManager;
    private int goalSteps;
    private long time;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setup sensor and logic class
        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        progressService = new TrackProgressService();
        progressManager = new ProgressManager();
        userManager = new UserManager();
        challengeManager = new ChallengeManager();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.track_progress, container, false);

        return view;
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
*/
    @Override
    public void onSensorChanged(SensorEvent event) {
        //Variables for modifying different UI elements
        ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.track_progress_bar);
        TextView numStepsText = (TextView) getView().findViewById(R.id.text_progress);
        TextView distanceText = (TextView) getView().findViewById(R.id.distance_number);
        TextView calorieText = (TextView) getView().findViewById(R.id.calories_number);

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //update number of steps
            int numSteps = progressService.getAccelerometer(event, progressModel.getNumSteps(), goalSteps);
            numStepsText.setText(progressModel.getNumSteps() + "/" + goalSteps + " Steps");
            progressModel.setNumSteps(numSteps);

            //update progress
            int progress = progressService.determineProgress(numSteps, goalSteps);
            progressBar.setProgress(progress);
            progressModel.setPercentageComplete(progress);

            //update distance
            double distance = progressService.calculateDistance(numSteps);
            String distanceRounded = String.format("%.2f", distance);
            distanceText.setText(distanceRounded + "m");
            progressModel.setDistance(distance);

            //update calories
            double calories = progressService.calculateCaloriesBurned(distance);
            String caloriesRounded = String.format("%.2f", calories);
            calorieText.setText(caloriesRounded);
            progressModel.setCalories(calories);

            //update the data database after each step recorded
            progressManager.updateDatabase(progressModel);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    //we must do this in the onResume function because it is the only way to
    //start a challenge once onCreate has been called.
    @Override
    public void onResume() {
        super.onResume();
        //If the user is currently in a challenge
        if(userManager.getUser(2).getChallengeStarted()) {
            UserModel user = userManager.getUser(2);

            goalSteps = challengeManager.getChallenge(user.getCurrentChallenge()).getStepsRequired();
            time = challengeManager.getChallenge(user.getCurrentChallenge()).getTime();

            //now starting challenge
            if(progressManager.getProgress(user.getId()) == null)
            {
                progressModel = new TrackProgressModel();
                progressModel.setUserId(user.getId());

                progressManager.addProgress(progressModel);
            }
            else
            {
                //the challenge may have started already, so get the progress info for the user
                progressModel = progressManager.getProgress(user.getId());
            }


            sensorManager.registerListener(this,
                    sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);

            final TextView timerText = (TextView) getView().findViewById(R.id.timer_text);

            new CountDownTimer(time, 1000) { //Sets 10 second remaining

                public void onTick(long milliseconds) {
                    String hours = progressService.determineHours(milliseconds);
                    String minutes = progressService.determineMinutes(milliseconds);
                    String seconds = progressService.determineSeconds(milliseconds);

                    timerText.setText("Time Remaining: " + hours + ":" + minutes + ":" + seconds);
                }

                public void onFinish() {
                    timerText.setText("Challenge Over!");
                }
            }.start();
        }
        //if the user is not in a challenge, then do not display any progress info
        else {
            sensorManager.unregisterListener(this);
        }
    }

    @Override
    public void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}