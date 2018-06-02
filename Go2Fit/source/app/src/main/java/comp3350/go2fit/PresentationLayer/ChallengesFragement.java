package comp3350.go2fit.PresentationLayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.content.Context;
import android.view.View.OnClickListener;
import android.app.Dialog;
import java.util.HashMap;
import java.util.Arrays;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragement extends Fragment {
    private ChallengesModel challengesModel;
    private ChallengesService challengesService;
    private HashMap<Integer, ChallengesModel> allChallenges;
    private ArrayList<String> challengeTypes;
    private ArrayAdapter<String> listViewAdapter;
    private Dialog dialog;

    public ChallengesFragement() {
        // Required empty public constructor
        challengesModel = new ChallengesModel();
        challengesService = new ChallengesService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        this.allChallenges = challengesService.getAllChallenges();//call the service class and get all the challenges from db
        this.challengeTypes = challengesService.getAllChallengeTypes(this.allChallenges);//get all the challenge types

        View view = inflater.inflate(R.layout.fragment_challenges_fragement, container, false);

        ListView listView = (ListView)view.findViewById(R.id.challengesList);
        this.listViewAdapter = new ArrayAdapter<>
                (
                        getContext(),
                        android.R.layout.simple_list_item_1,
                        this.challengeTypes
                );

        listView.setAdapter(listViewAdapter);
        Button button = (Button) view.findViewById(R.id.create_challenge);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openModalWindow(view);
                Button doneButton = (Button) dialog.findViewById(R.id.done_button);

                doneButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        userInput();
                        dialog.dismiss();
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
        dialog.show();
    }

    public void userInput()
    {
        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner1);
        String text = spinner.getSelectedItem().toString();

        ChallengesModel model = new ChallengesModel();
        model.setChallengeType(text);

        challengesService.addChallenge(model);
        challengeTypes.add(text);
        listViewAdapter.notifyDataSetChanged();
        System.out.println(text);
    }
}
