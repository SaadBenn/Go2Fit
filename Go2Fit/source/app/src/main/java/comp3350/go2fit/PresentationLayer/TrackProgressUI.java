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

import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.BuisnessLayer.TrackProgressService;

public class TrackProgressUI extends Fragment implements SensorEventListener {
    private SensorManager sensorManager;
    private TrackProgressModel progressModel;
    private TrackProgressService progressService;
    private int goalSteps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            //setup sensor and logic class
            sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
            progressService = new TrackProgressService();

            //get the current user
            UserModel user = progressService.getUser(3);
            //Determine the challenge the current user is doing
            goalSteps = progressService.getChallenge(user.getCurrentChallenge()).getStepsRequired();

            //now starting challenge
            if(progressService.getProgress(user.getId()) == null)
            {
                progressModel = new TrackProgressModel();
                progressModel.setUserId(user.getId());
                progressService.addProgress(progressModel);
            }
            else
            {
                //the challenge may have started already, so get the progress info for the user
                progressModel = progressService.getProgress(user.getId());
            }
        }
        catch (Exception e)
        {
            sensorManager.unregisterListener(this);
            Messages.fatalError(this.getActivity(), e.getMessage());
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.track_progress, container, false);

        final TextView timerText = (TextView) view.findViewById(R.id.timer_text);

        new CountDownTimer(4500000, 1000) { //Sets 10 second remaining

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
        TrackProgressModel tempProgressModel = new TrackProgressModel();
        ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.track_progress_bar);
        TextView numStepsText = (TextView) getView().findViewById(R.id.text_progress);
        TextView distanceText = (TextView) getView().findViewById(R.id.distance_number);
        TextView calorieText = (TextView) getView().findViewById(R.id.calories_number);

        try {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                //update number of steps
                progressService.getAccelerometer(event, progressModel, goalSteps);
                progressBar.setProgress(progressModel.getPercentageComplete());
                numStepsText.setText(progressModel.getNumSteps() + "/" + goalSteps + " Steps");

                //update distance
                String distanceRounded = String.format("%.2f", progressService.calculateDistance(progressModel));
                distanceText.setText(distanceRounded + "m");

                //update calories
                String caloriesRounded = String.format("%.2f", progressService.calculateCaloriesBurned(progressModel));
                calorieText.setText(caloriesRounded);

                //update the data database after each step recorded
                progressService.updateDatabase(progressModel);
            }
        }
        catch (Exception e)
        {
            Messages.fatalError(this.getActivity(), e.getMessage());
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}