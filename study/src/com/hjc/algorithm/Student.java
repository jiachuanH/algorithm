package com.hjc.algorithm;

public class Student extends Dome03 {
    private String name = "tom";
    {
        System.out.println("Student匿名代码块");
    }
    static {
        System.out.println("Student静态代码块");
    }

    public Student() {
        System.out.println("Student构造器");
    }

    public void print() {
        System.out.println("student print方法: name = " + name);
    }

    public static void main(String[] args) {
        new Student();
        System.out.println("");
    
    }
}
