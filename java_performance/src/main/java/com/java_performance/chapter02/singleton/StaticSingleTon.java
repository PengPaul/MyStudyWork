package com.java_performance.chapter02.singleton;

public class StaticSingleTon {
    private StaticSingleTon (){
        System.out.println("StaticSingleTon is create");
    }

    private static class SingletonHolder{
        private static StaticSingleTon mStaticSingleTon = new StaticSingleTon();
    }

    public static StaticSingleTon getInstance(){
        return SingletonHolder.mStaticSingleTon;
    }
}
