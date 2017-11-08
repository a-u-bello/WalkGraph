package com.example.ahmed.walkgraph.presentation;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.ahmed.walkgraph.App;
import com.example.ahmed.walkgraph.R;
import com.example.ahmed.walkgraph.presentation.list.GraphListImpl;
import com.example.ahmed.walkgraph.presentation.map.MapFragmentImpl;
import com.example.ahmed.walkgraph.presentation.settings.SettingsFragment;
import com.example.ahmed.walkgraph.presentation.splash.SplashFragmentImpl;

import javax.inject.Inject;

/**
 * Created by ahmed on 8/9/17.
 */

public class ContainerActivity extends AppCompatActivity implements
        //splash fragment
        SplashFragmentImpl.SplashCallback,
        //map fragment
        MapFragmentImpl.MapCallBack,
        //graph fragment
        GraphListImpl.GraphListCallBack{

    @Inject
    SplashFragmentImpl splashFragment;

    @Inject
    MapFragmentImpl mapFragment;

    @Inject
    SettingsFragment settingsFragment;

    @Inject
    GraphListImpl graphList;

    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getComponent().inject(this);

        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fragment_container, splashFragment)
                .commit();
    }

    //splash fragment callback
    @Override
    public void changeToMap() {
        manager.beginTransaction()
                .replace(R.id.fragment_container, graphList)
                .commit();
    }

    @Override
    public void onBackPressed(){
        Fragment fragment = manager.findFragmentById(R.id.fragment_container);
        if (fragment.getClass().getName().equals(mapFragment.getClass().getName())){
            manager.beginTransaction()
                    .replace(R.id.fragment_container, graphList)
                    .commit();
        }else if (fragment.getClass().getName().equals(settingsFragment.getClass().getName())){
            manager.beginTransaction()
                    .replace(R.id.fragment_container, graphList)
                    .commit();
        }else
            super.onBackPressed();
    }

    // settings fragment callback
    private void switchToList() {
       manager.beginTransaction()
               .replace(R.id.fragment_container, graphList)
               .commit();
    }

    @Override
    public void switchToMap() {
        manager.beginTransaction()
                .replace(R.id.fragment_container, mapFragment)
                .commit();
    }

    //graphList fragment's specific callback
    @Override
    public void switchToSettings() {
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, settingsFragment)
                .commit();
    }

    //map fragment's callback
    @Override
    public void returnToList() {
        switchToList();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == MapFragmentImpl.permissionCode){
            mapFragment.onActivityResult(requestCode, resultCode, data);
            Log.d("Activity Container", "Passing result to fragment");
        }
    }
}
