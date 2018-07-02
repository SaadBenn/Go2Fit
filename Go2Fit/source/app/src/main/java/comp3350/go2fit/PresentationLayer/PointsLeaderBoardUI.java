package comp3350.go2fit.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import android.widget.ListView;

import java.util.ArrayList;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.PointsLeaderBoardsService;
import comp3350.go2fit.PresentationLayer.Adapters.PointsLeaderBoardAdapter;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

public class PointsLeaderBoardUI extends AppCompatActivity
{
    private UserManager               userManager;
    private PointsLeaderBoardsService service;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_leader_board_ui);

        this.userManager = new UserManager();
        this.service     = new PointsLeaderBoardsService();
        HashMap users    = (HashMap)userManager.getAllUsers();

        Collection<UserModel> values   = users.values();
        ArrayList<UserModel> usersList = new ArrayList<UserModel>(values);

        Collections.sort(usersList, new PointsLeaderBoardsService());


        ListView listView = (ListView)findViewById(R.id.points_leader_board);

        PointsLeaderBoardAdapter adapter = new PointsLeaderBoardAdapter(this, R.layout.adapter_view_points_leaderboard, usersList);
        listView.setAdapter(adapter);
    }
}
