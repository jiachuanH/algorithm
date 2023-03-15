package com.hjc.geektime;

// 动态规划之01背包问题  knapsack ：背包
public class Knapsack {

    // 利用2维数组解决
    public int knapsack(int[] weight, int n, int w) {
        // 默认值 false
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                // 此处判断上一层的该列是否有值 是为了找到已经处理的上一行的该列
                // 因为该问题是前后依赖的
                if (states[i - 1][j] == true)
                    // 与上一行值一致 表示该物品处理完后背包容量不变,也就是不放入背包
                    states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {// 把第 i 个物品放入背包
                if (states[i - 1][j] == true)
                    // 此处上一行表示的列 处理完了可以直接将物品的重量取出,
                    // 与当前背包容量 j 相加得到处理后的列下表进行标记
                    states[i][j + weight[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i] == true)
                return i;
        }
        return 0;
    }

    // 利用一维数组解决
    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值 false
        states[0] = true; // 第一行的数据要特殊处理，可以利用哨兵优化
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {// 把第 i 个物品放入背包
                if (states[j] == true)
                    states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true)
                return i;
        }
        return 0;
    }

    public int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        for (int i = 0; i < n; ++i) { // 初始化 states
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < n; ++i) { // 动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
                if (states[i - 1][j] >= 0)
                    states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) { // 选择第 i 个物品
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue)
                maxvalue = states[n - 1][j];
        }
        return maxvalue;
    }

    private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
    private int[] items = { 2, 2, 4, 6, 3 }; // 物品的重量
    private int[] value = { 3, 4, 8, 9, 6 }; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int knapsack3 = knapsack.knapsack3(knapsack.items, knapsack.value, knapsack.n, knapsack.w);
        System.out.println(knapsack3);
    }
}
