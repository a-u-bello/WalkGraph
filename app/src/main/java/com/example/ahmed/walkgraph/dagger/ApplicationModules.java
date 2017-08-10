package com.example.ahmed.walkgraph.dagger;

import android.app.Application;
import android.content.Context;

import com.example.ahmed.walkgraph.data.prefs.Preferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ahmed on 8/9/17.
 */
@Module
public class ApplicationModules {
    private Application application;

    public ApplicationModules(Application application){
        this.application = application;
    }

    @Provides
    @Singleton
    public Context providesContext(){
        return application;
    }

    @Provides
    @Singleton
    public Preferences providePreference(Context context){
        return new Preferences(context);
    }
}