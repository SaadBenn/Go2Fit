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

        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        progressService = new TrackProgressService();

        progressModel = progressService.getProgress(1);

        goalSteps = 100;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.track_progress, container, false);

        //get the current users progress for the challenge
        //and update the xml. If the user is just starting
        //or has no progress, default values are 0
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.track_progress_bar);
        TextView numStepsText = (TextView) view.findViewById(R.id.text_progress);
        TextView distanceText = (TextView) view.findViewById(R.id.distance_number);
        TextView calorieText = (TextView) view.findViewById(R.id.calories_number);

        progressBar.setProgress(progressModel.getPercentageComplete());

        numStepsText.setText(progressModel.getNumSteps() + "/1000 Steps");

        String distanceRounded = String.format("%.2f", progressModel.getDistance());//round to two decimal points
        distanceText.setText(distanceRounded + "m");

        String caloriesRounded = String.format("%.2f", progressModel.getCalories());//round to two decimal points
        calorieText.setText(caloriesRounded);

        final TextView timerText = (TextView) view.findViewById(R.id.timer_text);

        new CountDownTimer(2000000, 1000) { //Sets 10 second remaining

            @Override
            public void onTick(long milliseconds) {
                String hours = progressService.determineHours(milliseconds);
                String minutes = progressService.determineMinutes(milliseconds);
                String seconds = progressService.determineSeconds(milliseconds);

                timerText.setText("Time Remaining: " + hours + ":" + minutes + ":" + seconds);
            }

            @Override
            public void onFinish() {
                timerText.setText("Challenge Over!");
            }
        }.start();

            /*
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        toolbar.setTitle("Current Challenge Progress");
        setSupportActionBar(toolbar);
        */

        return inflater.inflate(R.layout.track_progress, container, false);
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

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //update number of steps
            progressService.getAccelerometer(event, progressModel, goalSteps);
            progressBar.setProgress(progressModel.getPercentageComplete());
            numStepsText.setText(progressModel.getNumSteps() + "/1000 Steps");

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