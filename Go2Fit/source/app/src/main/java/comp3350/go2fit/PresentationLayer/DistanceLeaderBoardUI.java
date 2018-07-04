package comp3350.go2fit.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import android.widget.ListView;

import java.util.ArrayList;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.DistanceLeaderBoardsService;
import comp3350.go2fit.PresentationLayer.Adapters.DistanceLeaderBoardAdapter;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

public class DistanceLeaderBoardUI extends AppCompatActivity
{
    private UserManager                 userManager;
    private DistanceLeaderBoardsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_leader_board_ui);

        this.userManager = new UserManager();
        this.service     = new DistanceLeaderBoardsService();
        HashMap users    = (HashMap)userManager.getAllUsers();

        Collection<UserModel> values   = users.values();
        ArrayList<UserModel> usersList = new ArrayList<UserModel>(values);

        Collections.sort(usersList, new DistanceLeaderBoardsService());

//        ListView listView = (ListView) findViewById(R.id.distance_leader_board);
//
//        ArrayAdapter<UserModel> adapter = new ArrayAdapter<UserModel>(this,
//                android.R.layout.simple_list_item_1, usersList);
//
//        listView.setAdapter(adapter);

        ListView listView = (ListView) findViewById(R.id.distance_leader_board);

        DistanceLeaderBoardAdapter adapter = new DistanceLeaderBoardAdapter(this, R.layout.adapter_view_distance_leaderboard, usersList);
        listView.setAdapter(adapter);
    }
}
