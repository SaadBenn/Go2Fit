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

import java.util.HashMap;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.BuisnessLayer.ChallengesService;
import comp3350.go2fit.PresentationLayer.ChallengesModelParceable;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.ChallengesModel;

public class MainLeaderBoardsUI extends AppCompatActivity  implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_leader_boards_ui);

        Button one = (Button) findViewById(R.id.points);
        one.setOnClickListener(this); // calling onClick() method

        Button two = (Button) findViewById(R.id.challenges);
        two.setOnClickListener(this);

        Button four = (Button) findViewById(R.id.distance);
        four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.points:
                Intent intent1 = new Intent(this, PointsLeaderBoardUI.class);
                startActivity(intent1);
                break;

            case R.id.challenges:
                Intent intent2 = new Intent(this, ChallengesLeaderBoardUI.class);
                startActivity(intent2);
                break;

            case R.id.distance:
                Intent intent3 = new Intent(this, DistanceLeaderBoardUI.class);
                startActivity(intent3);
                break;

            default:
                break;
        }
    }
}
