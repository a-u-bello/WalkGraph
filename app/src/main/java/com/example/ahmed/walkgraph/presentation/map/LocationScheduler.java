package com.example.ahmed.walkgraph.presentation.map;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

/**
 * Created by ahmed on 8/12/17.
 */

public class LocationScheduler extends JobService {
    private static final String TAG = "LocationScheduler";
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.d(TAG, "OnStartJob called");
        //use location scheduler for notification
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.d(TAG, "OnStopJob called");
        return false;
    }
}
