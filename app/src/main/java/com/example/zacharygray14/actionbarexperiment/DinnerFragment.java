package com.example.zacharygray14.actionbarexperiment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;



/**
 * Created by zacharygray14 on 3/19/2018.
 */

public class DinnerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dinner, container, false);
    }


}