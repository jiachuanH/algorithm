package com.hjc.geektime;

public class KMPStudy {
    // a, b 分别是主串和模式串；n, m 分别是主串和模式串的长度。
    public static int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            // 这里 a[i] 和 b[j] 设定 j = next[j - 1] + 1; 就表示为在匹配时匹配到不等的字符了 
            // 用next找到字串为最长的可匹配前缀字符串的结尾下标 进行移动后匹配 看是否存在某个字串匹配
            while (j > 0 && a[i] != b[j]) { // 一直找到 a[i] 和 b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    // b 表示模式串，m 表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];

        // 下标为0的前缀就一个字符串所以标记为 -1 ,-1表示不存在最长的可匹配前缀字符串的结尾下标
        next[0] = -1;
        // 这里的k表示的当前下表为x匹配串的 第x-1个字符
        int k = -1;
        // i为1 则初始比较的时第二个字符 b[1]
        for (int i = 1; i < m; ++i) {
            //  k != -1: 过滤掉首字符的匹配
            //  b[k + 1] != b[i]:上一个最长的可匹配前缀字符串的结尾下标和当前子串的最后一个字符比较  i要>k+1
            //不等表示 当前k的next[] 就是最长的可匹配前缀字符串的结尾下标
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            //相等的话 则顺延至下一个字符
            if (b[k + 1] == b[i]) {
                ++k;
            }
            //匹配完成 返回next[i]的值k
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String a ="abckdjascas";
        String b ="ca";
        char[] test01 = a.toCharArray();
        char[] test02 = b.toCharArray();
        char[] test03 = {'a','c','l','m'};
        int kmp = kmp(test01, test01.length, test02, test02.length);
        System.out.println(kmp);
    }

}
