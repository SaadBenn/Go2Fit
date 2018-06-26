package comp3350.go2fit.PresentationLayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.ChallengesLeaderBoardsService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.PointsLeaderBoardsService;
import comp3350.go2fit.Models.ChallengesModelParceable;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;

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
        HashMap users    = userManager.getAllUsers();

        Collection<UserModel> values   = users.values();
        ArrayList<UserModel> usersList = new ArrayList<UserModel>(values);

        Collections.sort(usersList, new PointsLeaderBoardsService());

        ListView listView = (ListView)findViewById(R.id.points_leader_board);

        ArrayAdapter<UserModel> adapter = new ArrayAdapter<UserModel>(this,
                android.R.layout.simple_list_item_1, usersList);

        listView.setAdapter(adapter);
    }
}
