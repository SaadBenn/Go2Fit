package comp3350.go2fit.PresentationLayer;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.BuisnessLayer.AchieveService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.AchieveManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.AchieveModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

public class AchieveUI extends Fragment{
    private AchieveService achieveService;
    private AchieveManager achieveManager;
    private ArrayList<String> achieveName;
    private ArrayAdapter<String> listViewAdapter;
    int IMAGES  = R.drawable.calories_burned;
    String [] NAMES = {"Speed Invincible You get Badge [Speed Jaguar]",
            "Strength Unstopable You get Badge [Strength Lion]",
            "Action Flexible You get Badge[Agile Monkey]",
            "Give up too early You get [Chicken]"};
    public AchieveUI(){
        achieveService = new AchieveService();
        achieveManager = new AchieveManager();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_achieve_listview, container, false);
//        ListView listView =(ListView) view.findViewById(R.id.achieve_listview);
//
//        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(
//                getActivity(),
//                android.R.layout.simple_list_item_1,
//                NAMES
//        );
//        listView.setAdapter(listAdapter);
        try {
            //call the service class and get all the challenges from db
            final LinkedHashMap<Integer, AchieveModel> allAchieve = achieveManager.getAllAchieve();

            UserManager userManager = new UserManager();
            UserModel userModel = userManager.getUser(CurrentUserService.getUserId());

            //get all the challenge types
            this.achieveName = userModel.getAchievements();

            //populat the list view with the challenges
            ListView listView = (ListView) view.findViewById(R.id.achieve_listview);
            this.listViewAdapter = new ArrayAdapter<>
                    (
                            getContext(),
                            android.R.layout.simple_list_item_1,
                            this.achieveName
                    );

            listView.setAdapter(listViewAdapter);

        }
        catch(NullPointerException e)
        {
            Messages.fatalError(this.getActivity(), "Oops, something went wrong!");
        }

        return view;
    }
}