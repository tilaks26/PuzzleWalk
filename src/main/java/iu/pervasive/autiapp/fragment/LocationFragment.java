package iu.pervasive.autiapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iu.pervasive.autiapp.R;
import ivb.com.materialstepper.stepperFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationFragment extends stepperFragment {


    public LocationFragment() {
        // Required empty public constructor
    }

    @Override
    public boolean onNextButtonHandler() {
        return true;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location, container, false);
    }

}
