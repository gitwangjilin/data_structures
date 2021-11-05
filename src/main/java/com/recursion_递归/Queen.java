package com.recursion_递归;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Queen
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/4   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Queen {
    int max = 8;
    static int count = 0;
    int[] arr = new int[max];

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
    }

    private void check(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        System.out.print("第" + (++count) + "种: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
//public class Queen {
//    // 定义一个max表示有多少个皇后
//    int max = 8;
//    static int count = 0;
//    // 定义一个数组 保存皇后放置位置的结果  arr[8] = {0 , 4, 7, 5, 2, 6, 1, 3}
//    int[] arr = new int[max];
//    public static void main(String[] args) {
//        // 测试一把
//        Queen queen = new Queen();
//        queen.check(0); // 放到第一个位置
//
//
//    }
//    // 编写一个方法, 放置第n个皇后
//    // 注意  进入check时 都会有一个for循环,因此会有回溯
//    private void check(int n) {
//        if(n == max){ // max个换后已经放好了
//            print();
//            return;
//        }
//        // 依次放皇后 判断是否冲突
//        for (int i = 0; i < max; i++) {
//            // 先把当前的皇后放到该行的第一列
//            arr[n] = i;
//            // 当放置第那个皇后到i列时 是否冲突
//            if (judge(n)){ // 不冲突
//                check(n + 1);
//            }// 如果冲突则继续执行 arr[n] = i ; 本行后移一个位置
//        }
//    }
//    /**
//     * 查看 当放置第N个皇后时 , 去检测该皇后是否和前面已经摆放的皇后冲突
//     * @param n 第n个皇后
//     * @return
//     */
//    private boolean judge(int n) { // 表示放的第n个皇后
//        for (int i = 0; i < n; i++){
//            // arr[i] == arr[n] 判断第n个皇后和第i个皇后是否在同一直线上
//            // Math.abs(n - i) == Math.abs(arr[n] - arr[i])判断第n个皇后和第i个皇后是否在同一斜线上(是因为当前是一维数组,二维数组需要
//            //   用其他方法)
//            // n = 1 代表第二个皇后 如果放在第二列的第二行 则 arr[1] = 1
//            // Math.abs(1-0) == 1   Math.abs(1 - 0) == Math.abs(1 - 0) 成立
//            // 不需要判断同一行 因为 n在递增
//            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){ // Math.abs 是绝对值
//                return false;
//            }
//        }
//        return true;
//    }
//
//    // 写一个方法 将皇后的位置打印
//    private void print() {
//        System.out.print("第"+(++count)+"种: ");
//        for (int i = 0;i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }
//}