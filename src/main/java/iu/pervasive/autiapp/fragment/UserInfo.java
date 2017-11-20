package iu.pervasive.autiapp.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import iu.pervasive.autiapp.R;
import ivb.com.materialstepper.stepperFragment;

public class UserInfo extends stepperFragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.fragment_user_info, container, false);
    }
    @Override
    public boolean onNextButtonHandler() {
        return true;
    }
}
