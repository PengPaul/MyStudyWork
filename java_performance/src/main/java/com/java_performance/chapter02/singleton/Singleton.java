package com.java_performance.chapter02.singleton;

public class Singleton {
    /**
     * 私有的构造方法
     */
    private Singleton(){
        System.out.println("Singleton1 is create");
    }
    private static Singleton mSingleton1 = new Singleton();
    public static Singleton getInstance(){
        return mSingleton1;
    }
}
