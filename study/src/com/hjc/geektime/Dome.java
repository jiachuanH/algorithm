package com.hjc.geektime;

import java.util.HashMap;
public class Dome {
    public static void main(String[] args) {
        Dome dome = new Dome();
        System.out.println(dome.findWay(9));

    }

    HashMap<Integer, Integer> map = new HashMap<>();

    public int findWay(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = findWay(n - 1) + findWay(n - 2);
        map.put(n, res);
        return res;

    }

    // 冒泡排序，a 表示数组，n 表示数组大小
    public void bubbleSort(int[] a, int n) {
        if (n <= 1)
            return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true; // 表示有数据交换
                }
            }
            if (!flag)
                break; // 没有数据交换，提前退出
        }
    }

}
