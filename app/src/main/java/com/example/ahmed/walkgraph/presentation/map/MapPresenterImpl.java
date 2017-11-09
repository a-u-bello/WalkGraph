package com.example.ahmed.walkgraph.presentation.map;

import android.location.Location;
import android.util.Log;

import com.example.ahmed.walkgraph.data.local.GraphDAO;
import com.example.ahmed.walkgraph.data.model.Graph;
import com.example.ahmed.walkgraph.utils.AppConstants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ahmed on 8/9/17.
 */

public class MapPresenterImpl implements MapPresenter {
    private GraphDAO graphDAO;
    private static final String TAG = "Map Presenter";

    public MapPresenterImpl(GraphDAO graphDAO){
        this.graphDAO = graphDAO;
    }

    @Override
    public Graph getRecentGraph() {
        int day , month, year;

        Calendar calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        Graph dbGraph = graphDAO.getGraph(day, month, year);
        if (dbGraph == null){
            Log.d(TAG, "Error loading from db");
            dbGraph = testGraph();
        }
        return dbGraph;
    }

    @Override
    public Graph testGraph() {
        Graph graph = new Graph();

        List<Location> locationList = new ArrayList<>();
        Location location = new Location(AppConstants.locationProvider);

        location.setLatitude(6.5229296);
        location.setLongitude(3.3792057);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5480747);
        location.setLongitude(3.3975005);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5243793);
        location.setLongitude(3.3975005);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5229296);
        location.setLongitude(3.3792057);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5229296);
        location.setLongitude(3.3792057);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5229296);
        location.setLongitude(3.3792057);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5229296);
        location.setLongitude(3.3792057);
        locationList.add(location);

        location = new Location(AppConstants.locationProvider);
        location.setLatitude(6.5020794);
        location.setLongitude(3.3737125);
        locationList.add(location);
        int day , month, year;

        Calendar calendar = Calendar.getInstance();

        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        graph.setGraphDate(day, month, year);
        graph.setLocations(locationList);
        return graph;
    }
}
