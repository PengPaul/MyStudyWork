package com.java_performance.chapter02.proxy;

public class DBQuery implements IDBQuery {
    public DBQuery(){
        System.out.println("这里有比较重量的初始化");
    }
    @Override
    public String request() {
        return " DBQuery request ";
    }
}
