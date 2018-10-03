/*
 * Copyright (c) by Sujoy Datta. Created on 2018. For any issues please contact sujoydatta26@gmail.com
 */

package application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class CustomApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            //This process is dedicated to leak canary for heap analysis
            //Do not init app in this process
            return;
        }
        LeakCanary.install(this);
        //initialize your app configurations here
    }
}
