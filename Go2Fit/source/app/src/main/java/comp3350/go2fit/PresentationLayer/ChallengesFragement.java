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
import android.app.Dialog;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragement extends Fragment
{
    private ChallengesService challengesService;
    private ChallengeManager challengeManager;
    private ArrayList<String> challengeTypes;
    private ArrayAdapter<String> listViewAdapter;
    private Dialog dialog;

    public ChallengesFragement()
    {
        // Required empty public constructor
        challengesService = new ChallengesService();
        challengeManager = new ChallengeManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_challenges_fragement, container, false);

        //ensure that there is valid challenges in db
        try {
            //call the service class and get all the challenges from db
            final LinkedHashMap<Integer, ChallengesModel> allChallenges = challengeManager.getAllChallenges();

            //get all the challenge types
            this.challengeTypes = challengesService.getAllChallengeNames(allChallenges);

            //populat the list view with the challenges
            ListView listView = (ListView) view.findViewById(R.id.challengesList);
            this.listViewAdapter = new ArrayAdapter<>
                    (
                            getContext(),
                            android.R.layout.simple_list_item_1,
                            this.challengeTypes
                    );

            listView.setAdapter(listViewAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position >= 0) {
                        Intent intent = new Intent(getActivity(), CurrentChallenge.class);
                        ChallengesModelParceable parceable = new ChallengesModelParceable(allChallenges.get(position));
                        intent.putExtra("Current Challenge", parceable);

                        startActivity(intent);
                    }
                }
            });
        }
        catch(NullPointerException e)
        {
            Messages.fatalError(this.getActivity(), e.getMessage());
        }

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
        int allValid = 0;

        try
        {
            challengesService.verifyDistance(stepsValue);
            allValid++;
        }
        catch(NumberFormatException e) {

            steps.setError("You must enter a valid number!");
        }

        NumberPicker numberPickerHours = (NumberPicker) dialog.findViewById(R.id.timePicker1);
        NumberPicker numberPickerMinutes = (NumberPicker) dialog.findViewById(R.id.timePicker);

        int hours = numberPickerHours.getValue();
        int minutes = numberPickerMinutes.getValue();

        long milliseconds = 0;
        try
        {
            challengesService.verifyTime(minutes, hours);
            milliseconds = TimeUnit.MINUTES.toMillis(minutes) + TimeUnit.HOURS.toMillis(hours);
            allValid++;
        }
        catch(IllegalArgumentException e)
        {
            Messages.warning(this.getActivity(), "You cannot have a time of 0!");
        }

        if(allValid == 2)
        {
            int points = challengesService.determinePoints(Integer.parseInt(stepsValue), milliseconds);

            ChallengesModel model = new ChallengesModel(name, text, Integer.parseInt(stepsValue), milliseconds, points);

            challengeManager.addChallenge(model);
            challengeTypes.add(name);
            listViewAdapter.notifyDataSetChanged();

            dialog.dismiss();

            Messages.notify(this.getActivity(), "You created a challenge worth " + points + " points!");
        }
    }
}
