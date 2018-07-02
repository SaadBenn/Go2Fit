package comp3350.go2fit.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import android.widget.ListView;

import java.util.ArrayList;

import comp3350.go2fit.BuisnessLayer.ChallengesLeaderBoardsService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import comp3350.go2fit.BuisnessLayer.ChallengesLeaderBoardAdapter;

public class ChallengesLeaderBoardUI extends AppCompatActivity
{
    private UserManager                   userManager;
    private ChallengesLeaderBoardsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges_leader_board_ui);

        this.userManager = new UserManager();
        this.service     = new ChallengesLeaderBoardsService();
        HashMap users    = (HashMap)userManager.getAllUsers();

        Collection<UserModel> values   = users.values();
        ArrayList<UserModel> usersList = new ArrayList<UserModel>(values);

        Collections.sort(usersList, new ChallengesLeaderBoardsService());


        ListView listView = (ListView) findViewById(R.id.challenges_leader_board);

        ChallengesLeaderBoardAdapter adapter = new ChallengesLeaderBoardAdapter(this, R.layout.adapter_view_challenges_leaderboard, usersList);
        listView.setAdapter(adapter);
    }
}
