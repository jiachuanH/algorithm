package com.hjc.geektime;

public class Sort {

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

    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort(int[] a, int n) {

        if (n <= 1)
            return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j]; // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }

    }

    // 选择排序

   public static int[] selectionSort(int[] array) {
    if (array.length == 0)
        return array;
    for (int i = 0; i < array.length; i++) {
        int minIndex = i;
        for (int j = i; j < array.length; j++) {
            if (array[j] < array[minIndex]) //找到最小的数
                minIndex = j; //将最小数的索引保存
        }
        int temp = array[minIndex];
        array[minIndex] = array[i];
        array[i] = temp;
    }
    return array;
}

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] b = { 4, 2, 3, 5, 6, 8 };
        sort.insertionSort(b, 6);
        for (int b2 : b) {
            System.out.println(b2);

        }

        System.out.println("======================================");

        int[] selectionSort = selectionSort(b);
        for (int i : selectionSort) {
            System.out.println(i);
        }
    }

}
