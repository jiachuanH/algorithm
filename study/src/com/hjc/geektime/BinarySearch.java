package com.hjc.geektime;


public class BinarySearch {
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;

        while (low <= hight) {
            int mid = (hight - low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] > value) {
                hight = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // 变体一、查找第一个值等于给定值的元素
    public static int bsearch1(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || a[mid - 1] != value)
                    return mid;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    // 变体二、查找最后一个值等于给定值的元素
    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value))
                    return mid;
                else
                    low = mid + 1;
            }
        }

        return -1;
    }

    // 变体三、查找第一个大于等于给定值的元素
    public static int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value))
                    return mid;
                else
                    high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    // 变体四、查找最后一个小于等于给定值的元素
    public static int bsearch4(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] <= value) {
                if ((mid == n - 1) || (a[mid + 1] > value))
                    return mid;
                else
                    low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] b = { 1, 2, 3, 4, 5, 8, 8, 9 };
        

        int result = bsearch(b, b.length, 8);
        int result1 = bsearch1(b, b.length, 8);
        int result2 = bsearch2(b, b.length, 8);
        int result3 = bsearch3(b, b.length, 5);
        int result4 = bsearch4(b, b.length, 5);
        System.out.println(result4);
    }
}
