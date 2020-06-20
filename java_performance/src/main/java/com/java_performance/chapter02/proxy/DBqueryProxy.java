package com.java_performance.chapter02.proxy;

public class DBqueryProxy implements IDBQuery {
    private DBQuery real = null;

    @Override
    public String request() {
        if (real == null){
            real = new DBQuery();
        }
        return real.request();
    }
}
