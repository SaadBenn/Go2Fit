package comp3350.go2fit.PresentationLayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import comp3350.go2fit.Application.CurrentUserService;
import comp3350.go2fit.BuisnessLayer.DatabaseManagers.UserManager;
import comp3350.go2fit.Models.UserModel;
import comp3350.go2fit.R;

public class HomePageFragement extends Fragment {

    public HomePageFragement()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_home_page_fragement, container, false);

        TextView textView = (TextView) view.findViewById(R.id.username_text);
        TextView points = (TextView) view.findViewById(R.id.textView17);
        TextView calories = (TextView) view.findViewById(R.id.textView22);
        TextView distance = (TextView) view.findViewById(R.id.textView23);

        UserManager userManager = new UserManager();
        UserModel userModel = userManager.getUser(CurrentUserService.getUserId());

        textView.setText(textView.getText() + "\n" + userModel.getName());
        points.setText("" + userModel.getTotalPoints());
        calories.setText(String.format("%.2f", userModel.getTotalCalories()));
        distance.setText(String.format("%.2f", userModel.getTotalDistance()) + "m");
        return view;
    }
}
