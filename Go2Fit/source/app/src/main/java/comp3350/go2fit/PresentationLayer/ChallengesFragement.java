package comp3350.go2fit.PresentationLayer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.content.Context;
import android.view.View.OnClickListener;
import android.app.Dialog;

import java.sql.Time;
import java.util.HashMap;
import java.util.Arrays;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.Application.Services;
import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;
import comp3350.go2fit.PersistenceLayer.ChallengePersistenceStub;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragement extends Fragment {
    private ChallengePersistenceStub challengeStub;
    private ChallengesService challengesService;
    private HashMap<Integer, ChallengesModel> allChallenges;
    private ArrayList<String> challengeTypes;
    private ArrayAdapter<String> listViewAdapter;
    private Dialog dialog;

    public ChallengesFragement() {
        // Required empty public constructor
        challengesService = new ChallengesService();
        challengeStub     = new ChallengePersistenceStub();
        challengeStub.initializeDatabase();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.allChallenges = challengesService.getAllChallenges();//call the service class and get all the challenges from db
        this.challengeTypes = challengesService.getAllChallengeNames(this.allChallenges);//get all the challenge types


        View view = inflater.inflate(R.layout.fragment_challenges_fragement, container, false);

        //populat the list view with the challenges
        ListView listView = (ListView)view.findViewById(R.id.challengesList);
        this.listViewAdapter = new ArrayAdapter<>
                (
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        this.challengeTypes
                );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position >= 0)
                {

                    System.out.println("THE CHALLENGE IS: " +allChallenges.get(0).getChallengeName());


                    Intent intent = new Intent(getActivity(), CurrentChallenge.class);
                    intent.putExtra("Current Challenge",  allChallenges.get(position));

                    startActivity(intent);
                }
            }
        });


        Button button = (Button) view.findViewById(R.id.create_challenge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModalWindow(view);

                //when the done button is pressed in the dialog
                Button doneButton = (Button) dialog.findViewById(R.id.done_button);

                doneButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        userInput();
                    }
                });
            }
        });

        LayoutInflater newInflator = LayoutInflater.from(this.getActivity());
        View layout = newInflator.inflate(R.layout.create_challenge_dialog,null); // specify your xml layout here
        // Inflate the layout for this fragment
        return view;
    }


    public void openModalWindow(View view)
    {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.create_challenge_dialog);
        dialog.setTitle("Create a challenge!");

        //Set the time picker with 24 values, representing hours
        NumberPicker numberPickerHours = (NumberPicker) dialog.findViewById(R.id.timePicker1);
        numberPickerHours.setMinValue(0);
        numberPickerHours.setMaxValue(24);

        //Set the time picker with 24 values, representing hours
        NumberPicker numberPickerMinutes = (NumberPicker) dialog.findViewById(R.id.timePicker);
        numberPickerMinutes.setMinValue(0);
        numberPickerMinutes.setMaxValue(60);

        dialog.show();

    }

    public void userInput()
    {
        EditText challengeName = (EditText) dialog.findViewById(R.id.challenge_name);
        String name = challengeName.getText().toString();

        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner1);
        String text = spinner.getSelectedItem().toString();

        EditText steps = (EditText) dialog.findViewById(R.id.edittext);
        String stepsValue = steps.getText().toString();

        //ensure the distance entered is valid
        boolean validDistance = challengesService.verifyDistance(stepsValue);

        int allValid = 0;
        if(validDistance)
        {
            allValid++;
        }
        else
        {
            steps.setError("You must enter a valid number!");
        }

        NumberPicker numberPickerHours = (NumberPicker) dialog.findViewById(R.id.timePicker1);
        NumberPicker numberPickerMinutes = (NumberPicker) dialog.findViewById(R.id.timePicker);

        int hours = numberPickerHours.getValue();
        int minutes = numberPickerMinutes.getValue();

        boolean validTime = challengesService.verifyTime(hours, minutes);

        long milliseconds = 0;
        if(validTime)
        {
            milliseconds = TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.HOURS.toMillis(hours);
            System.out.println("MILLISECONDS: "+milliseconds);
            allValid++;
        }
        else
        {
            Messages.warning(this.getActivity(), "You cannot have a time of 0!");
        }

        if(allValid == 2)
        {
            int points = challengesService.determinePoints(Integer.parseInt(stepsValue), milliseconds);

            ChallengesModel model = new ChallengesModel(name, text, Integer.parseInt(stepsValue), milliseconds, points);

            challengesService.addChallenge(model);
            challengeTypes.add(name);
            listViewAdapter.notifyDataSetChanged();

            dialog.dismiss();

            Messages.notify(this.getActivity(), "You created a challenge worth " + points + " points!");
        }
    }
}
