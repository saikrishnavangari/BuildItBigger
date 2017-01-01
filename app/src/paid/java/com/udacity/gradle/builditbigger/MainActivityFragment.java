package com.udacity.gradle.builditbigger;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by krrish on 1/01/2017.
 */

public class MainActivityFragment extends Fragment {
    @BindView(R.id.tellJoke_btn)
    Button tellJoke;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,root);

        return root;
    }
    @OnClick(R.id.tellJoke_btn)
    public void  DisplayActivity(){
        EndPointsCaller EndPointsCaller = new EndPointsCaller(getActivity());
        EndPointsCaller.execute();
    }
}
