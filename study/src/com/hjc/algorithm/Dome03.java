package com.hjc.algorithm;

import java.util.Collections;
import java.util.List;

public class Dome03 {

    private String name = "zs";

    public Dome03() {
        System.out.println("Dome03构造器");
        print();
    }

    public void print() {
        System.out.println("Person print方法: name = " + name);
    }

    public static void main(String[] args) {
        new Test1() {

            @Override
            public void method() {
                System.out.println("实现了方法");
            }
        }.method();

    }

    public static List randomSortList(List list) {
        // 使用给定的随机源对指定列表进行置换
        Collections.shuffle(list);
        return list;

    }

}

interface Test1 {
    public void method();
}
