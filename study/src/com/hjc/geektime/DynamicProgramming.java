package com.hjc.geektime;

// 动态规划
public class DynamicProgramming {
    // 动态规划之状态转移表法
    // 求解最短路径 P38
    public int minDistDP(int[][] matrix, int n) {
        int[][] states = new int[n][n];
        int sum = 0;
        for (int j = 0; j < n; ++j) { // 初始化 states 的第一行数据
            sum += matrix[0][j];
            states[0][j] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; ++i) { // 初始化 states 的第一列数据
            sum += matrix[i][0];
            states[i][0] = sum;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < n; ++j) {
                states[i][j] = matrix[i][j] + Math.min(states[i][j - 1], states[i - 1][j]);
            }
        }
        return states[n - 1][n - 1];
    }

    // 动态规划之状态转移方程
    private int[][] matrix = 
         {{1,3,5,9}, {2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private int n = 4;
    private int[][] mem = new int[4][4];

    public int minDist(int i, int j) { // 调用 minDist(n-1, n-1);
        // 已经遍历到最顶端了返回原始值
        if (i == 0 && j == 0)
            return matrix[0][0];
        // 设置备忘录 以免重复计算
        if (mem[i][j] > 0)
            return mem[i][j];
        int minLeft = Integer.MAX_VALUE;
        // 从左边找 递归调用
        if (j - 1 >= 0) {
            minLeft = minDist(i, j - 1);
        }
        int minUp = Integer.MAX_VALUE;
        // 从右边找 递归调用
        if (i - 1 >= 0) {
            minUp = minDist(i - 1, j);
        }

        // 记录最小值
        int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
        mem[i][j] = currMinDist;
        return currMinDist;
    }

    public static void main(String[] args) {
        DynamicProgramming dp = new DynamicProgramming();
       int minDist = dp.minDist(dp.n-1, dp.n-1);
       System.out.println(minDist);
    }
}
