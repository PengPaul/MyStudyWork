package com.java_performance.chapter02.singleton;

public class LazySingleton {
    private LazySingleton(){
        System.out.println("LazySingleton2 is create");
    }

    private static volatile LazySingleton mLazySingleton2 = null;

    public static synchronized LazySingleton getInstance(){
        if (mLazySingleton2 == null){
            mLazySingleton2 = new LazySingleton();
        }
        return mLazySingleton2;
    }
    //双重锁
    public static synchronized LazySingleton getLazySingleton2(){
        if (mLazySingleton2 == null){
            synchronized (LazySingleton.class){
                if (mLazySingleton2 == null){
                    mLazySingleton2 = new LazySingleton();
                }
            }
        }
        return mLazySingleton2;
    }
}
