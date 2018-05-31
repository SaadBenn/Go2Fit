package comp3350.go2fit.PresentationLayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import comp3350.go2fit.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragement extends Fragment {


    public HomePageFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page_fragement, container, false);
    }

}
