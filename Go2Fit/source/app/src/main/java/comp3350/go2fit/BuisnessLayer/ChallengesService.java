package comp3350.go2fit.BuisnessLayer;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import comp3350.go2fit.Models.ChallengesModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.PersistenceLayer.ChallengePersistence;

import comp3350.go2fit.Application.Services;

import comp3350.go2fit.PersistenceLayer.ChallengePersistenceStub;
import comp3350.go2fit.PersistenceLayer.UserPersistence;
import comp3350.go2fit.PresentationLayer.TrackProgressUI;


public class ChallengesService
{
    public void verifyDistance(String distance) throws NumberFormatException
    {
        Integer.parseInt(distance);
    }

    public void verifyTime(int hours, int minutes)
    {
        if(hours <= 0 && minutes <= 0)
        {
            throw new IllegalArgumentException("Time cannot be 0!");
        }
    }

    public int determinePoints(int steps, long time)
    {
        return ((steps * 2) - (int)(TimeUnit.MILLISECONDS.toMinutes(time)));
    }

    public ArrayList<String> getAllChallengeNames(HashMap map)
    {
        Set<Integer> set=map.keySet();
        ArrayList<String> values = new ArrayList<>();
        int count = 0;
        for(Integer value : set)
        {
            ChallengesModel model = (ChallengesModel)map.get(value);
            values.add(model.getChallengeName());
            count++;
        }
        return values;
    }

}
