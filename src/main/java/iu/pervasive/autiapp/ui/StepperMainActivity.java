package iu.pervasive.autiapp.ui;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import iu.pervasive.autiapp.fragment.FinishFragment;
import iu.pervasive.autiapp.fragment.LocationFragment;
import iu.pervasive.autiapp.fragment.UserInfo;
import ivb.com.materialstepper.progressMobileStepper;

/**
 * Created by Sachin on 11/19/2017.
 */

public class StepperMainActivity extends progressMobileStepper {

    List<Class> stepperFragmentList = new ArrayList<>();

    @Override
    public void onStepperCompleted() {
        Intent mainIntent = new Intent(this, LocationActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public List<Class> init() {
        stepperFragmentList.add(UserInfo.class);
        stepperFragmentList.add(LocationFragment.class);
        stepperFragmentList.add(FinishFragment.class);

        return stepperFragmentList;
    }
}
