package com.example.mytest;

import android.app.Application;
import android.os.Debug;
import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 *  优化方案：
 *   1.开线程     没建handler    没操作UI   对异步要求不高
 *   2.懒加载     用到的时候再初始化，如网络，数据库操作
 */
public class App extends Application {
    private static final String TAG = "App";
    @Override
    public void onCreate() {
        super.onCreate();
        File file = new File(this.getExternalFilesDir(""),"peng.trace");
        Log.i(TAG,"onCreate:" +file.getAbsolutePath());
        //把分析结果存在文件
        Debug.startMethodTracing(file.getAbsolutePath());

        System.out.println("aaa");

        try {
            //比较耗时的可以在子线程去做
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Debug.stopMethodTracing();
    }

}
