package comp3350.go2fit.PresentationLayer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
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
import comp3350.go2fit.PersistenceLayer.ChallengePersistenceStub;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragement extends Fragment {
    private ChallengePersistenceStub challengeStub;
    private ChallengesModel challengesModel;
    private ChallengesService challengesService;
    private HashMap<Integer, ChallengesModel> allChallenges;
    private ArrayList<String> challengeTypes;
    ArrayAdapter<String> listViewAdapter;

    public ChallengesFragement() {
        // Required empty public constructor
        challengesModel   = new ChallengesModel();
        challengesService = new ChallengesService();
        challengeStub     = new ChallengePersistenceStub();
        challengeStub.initializeDatabase();
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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position >= 0)
                {

                    //creating challengeModel based on the item pressed in the challenge list
                    challengesModel.setChallengeType(challengeStub.getChallengeType(position));
                    challengesModel.setId(position);


                    Intent intent = new Intent(getActivity(), CurrentChallenge.class);
                    intent.putExtra("Current Challenge", challengesModel);

                    startActivity(intent);
                }
            }
        });


        Button button = (Button) view.findViewById(R.id.create_challenge);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openModalWindow(view);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }


    public void openModalWindow(View view)
    {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.create_challenge_dialog,null); // specify your xml layout here

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.create_challenge_dialog);
        dialog.setTitle("Create a challenge!");
        dialog.show();

        Button button = (Button) layout.findViewById(R.id.done_button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
