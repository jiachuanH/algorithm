package com.hjc.geektime;

public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n; // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n)
            return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            i = i / 2;
        }
    }

    // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
    private void swap(int[] a2, int i, int j) {
        int temp = a2[i];
        a2[i] = a2[j];
        a2[j] = temp;
    }

    public void removeMax() {
        if (count == 0)
            return; // 堆中没有数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2])
                maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1])
                maxPos = i * 2 + 1;
            if (maxPos == i)
                break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(3);

    }
}
