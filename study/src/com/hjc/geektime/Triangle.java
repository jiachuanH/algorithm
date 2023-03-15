package com.hjc.geektime;

import java.util.Scanner;

public class Triangle {
    public double getArea(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一条边");
        double side1 = scanner.nextDouble();
        System.out.println("请输入第二条边");
        double side2 = scanner.nextDouble();
        System.out.println("请输入第三条边");
        double side3 = scanner.nextDouble();
        double result = triangle.getArea(side1, side2, side3);
        // double result = triangle.getArea(18.9, 37, 42.7);
        System.out.println(result * 0.0015 + "  亩");
        System.out.println(result * 0.0015 * 42000 + "  元");
    }
}
