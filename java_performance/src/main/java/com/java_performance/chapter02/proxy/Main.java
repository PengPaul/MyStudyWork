package com.java_performance.chapter02.proxy;

public class Main {
    public static void main(String[] args) {
        IDBQuery query = new DBqueryProxy();//使用代理
        query.request(); //真正使用才初始化真实对象；
    }
}
