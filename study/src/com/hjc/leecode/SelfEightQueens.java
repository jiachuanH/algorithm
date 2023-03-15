package com.hjc.leecode;

public class SelfEightQueens {

    int[] next = new int[8];

    public void calc8Queens(int row) {
        if (row == 8) {
            printArray(next);
            return;
        }

        for (int column = 0; column < 8; ++column) {
            // 检测当前行是否合适 合适的话放入next数组 计算下一行，colume +1&& row +1
            if (isOK(row, column)) {
                next[row] = column;
                calc8Queens(row + 1);
            }
        }
    }

    private boolean isOK(int row, int column) {
        int leftup = column - 1, rightup = column + 1;
        for (int i = row - 1; i >= 0; --i) {
            // 检测上方是否有棋子阻挡
            if (next[i] == column) {
                return false;
            }
            // 检测左上方是否有棋子阻挡
            if (leftup >= 0) {
                if (next[i] == leftup)
                    return false;
            }
            // 检测右上方是否有棋子阻挡
            if (rightup <= 8) {
                if (next[i] == rightup)
                    return false;

            }
            --leftup;
            ++rightup;
        }
        // 正常结束循环表示没有棋子阻挡 返回true
        return true;
    }

    private void printArray(int[] next2) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // 循环打印数组 next2数组中下标为i的行所表示的值  与列值j相等  表示有棋子(数据) 打印Q
                if (next2[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelfEightQueens selfEightQueens = new SelfEightQueens();
        selfEightQueens.calc8Queens(0);
    }

}
