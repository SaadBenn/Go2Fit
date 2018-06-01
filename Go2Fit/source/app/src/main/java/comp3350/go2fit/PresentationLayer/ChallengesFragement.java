package comp3350.go2fit.PresentationLayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.app.Dialog;
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

import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChallengesFragement extends Fragment {
    private ChallengesModel challengesModel;


    public ChallengesFragement() {
        // Required empty public constructor
        challengesModel = new ChallengesModel();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_challenges_fragement, container, false);

        ListView listView = (ListView) view.findViewById(R.id.challengesList);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<>
                (
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        challengesModel.getChallenges()
                );

        listView.setAdapter(listViewAdapter);

        Button button = (Button) view.findViewById(R.id.create_challenge);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openModalWindow(view);
            }
        });
        return view;
    }

    public void openModalWindow(View view) {

        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.create_challenge_dialog);
        dialog.setTitle("Hello");
        dialog.show();
    }
}
