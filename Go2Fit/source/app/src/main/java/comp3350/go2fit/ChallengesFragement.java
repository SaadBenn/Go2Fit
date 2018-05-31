package comp3350.go2fit;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragement extends Fragment
{
    private ChallengesModel challengesModel;
    private ChallengeLogic challengeLogic;


    public ChallengesFragement()
    {
        // Required empty public constructor
        challengesModel = new ChallengesModel();
        challengeLogic  = new ChallengeLogic();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_challenges_fragement, container, false);

        final ListView listView = (ListView)view.findViewById(R.id.challengesList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>
        (
            getActivity(),
            android.R.layout.simple_list_item_1,
            challengesModel.getChallenges()
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if(position == 0 || position == 1 || position == 2 || position == 3 ||position == 4)
                {
                    Intent intent = new Intent(getActivity(), ChallengeDetails.class);
                    startActivity(intent);
                }
            }
        });

        challengeLogic.selectChallenge(listView);

        // Inflate the layout for this fragment
        return view;
    }
}
