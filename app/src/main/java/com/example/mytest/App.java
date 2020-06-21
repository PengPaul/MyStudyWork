package com.example.mytest;

import android.app.Application;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import java.io.File;

public class App extends Application {
    private static final String TAG = "App";

    @Override
    public void onCreate() {
        super.onCreate();
        File file = new File(this.getExternalFilesDir(""),"peng.trace");
        Log.i(TAG,"onCreate:" +file.getAbsolutePath());
        //把分析结果存在文件
        Debug.startMethodTracing(file.getAbsolutePath());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Debug.stopMethodTracing();
    }
}
