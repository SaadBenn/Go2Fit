package comp3350.go2fit.PresentationLayer;
import android.support.v7.app.AppCompatActivity;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ChallengeManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.ProgressManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.PrizesManager;
import comp3350.go2fit.Models.PrizesModel;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;
import comp3350.go2fit.Models.TrackProgressModel;
import comp3350.go2fit.BuisnessLayer.TrackProgressService;
import android.widget.ListView;
import android.os.Bundle;
import comp3350.go2fit.Application.CustomList;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class RedeemPrizes extends AppCompatActivity{
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.redeem_prizes);

        PrizesManager prizesManager = new PrizesManager();
        final HashMap<Integer, PrizesModel> allPrizes = (HashMap)prizesManager.getAllPrizes();

        Integer[] imageList = getImages(allPrizes);
        String[] descriptionList = getDescriptions(allPrizes);
        Integer[] pointsList = getPoints(allPrizes);

        CustomList adapter=new CustomList(this, descriptionList, imageList, pointsList);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }

    private Integer[] getImages(HashMap map)
    {
        Set<Integer> set = map.keySet();
        ArrayList<Integer> values = new ArrayList<>();
        for(Integer value : set)
        {
            PrizesModel model = (PrizesModel) map.get(value);
            values.add(model.getImage());
        }

        Integer[] images = new Integer[values.size()];
        for(int i=0;i<values.size();i++)
        {
            images[i] = values.get(i);
        }
        return images;
    }

    private String[] getDescriptions(HashMap map)
    {
        Set<Integer> set = map.keySet();
        ArrayList<String> values = new ArrayList<>();
        for(Integer value : set)
        {
            PrizesModel model = (PrizesModel) map.get(value);
            values.add(model.getDescription());
        }

        String[] descriptions = new String[values.size()];
        for(int i=0;i<values.size();i++)
        {
            descriptions[i] = values.get(i);
        }
        return descriptions;
    }

    private Integer[] getPoints(HashMap map)
    {
        Set<Integer> set = map.keySet();
        ArrayList<Integer> values = new ArrayList<>();
        for(Integer value : set)
        {
            PrizesModel model = (PrizesModel) map.get(value);
            values.add(model.getPointsRequired());
        }

        Integer[] points = new Integer[values.size()];
        for(int i=0;i<values.size();i++)
        {
            points[i] = values.get(i);
        }
        return points;
    }
}
