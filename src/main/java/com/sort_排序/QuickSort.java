package com.sort_排序;

import java.time.LocalTime;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: QuickSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/16   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);

        int arrTest[] = new int[50000000];
        System.out.println("开始时间：" + LocalTime.now());
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = (int) (Math.random() * 80000);
        }
        System.out.println("加数据时间：" + LocalTime.now());

        quickSort(arrTest, 0, arrTest.length - 1);
        System.out.println("消耗时间：" + LocalTime.now());
    }

    /**
     * @param arr
     * @param left  左边的索引
     * @param right 右边的索引
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left; // 左下标
        int r = right; // 右下标
        int temp = 0; //临时变量
        // pivot 中轴
        int pivot = arr[(left + right) / 2];
        // 只要右边的索引大于左边的索引就继续循环  目的是 让 比pivot小的值放到左边 比 pivot 值大的放在右边
        while (l < r) {
            // 在pivot的左边 一直找 找到大于等于pivot的值 ,才退出
            while (arr[l] < pivot) { //最多找到pivot本身
                l += 1;
            }
            // 在pivot的左边 一直找 找到小于等于pivot的值 ,才退出
            while (arr[r] > pivot) { //最多找到pivot本身
                r -= 1;
            }
            // 如果成立 说明 pivot 左边的值, 已经全部小于等于pivot的值, 右边, 已经全部大于等于pivot的值
            if (l >= r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 判断 如果交换完后 发现arr[l] = pivot r向前移动 l--
            if (arr[l] == pivot) {
                r -= 1;
            } else if (arr[r] == pivot) {// 判断 如果交换完后 发现arr[r] = pivot l向后移动 l++
                l++;
            }
        }
        // 如果 l == r 必须 l++ 和 r--, 否则会出现栈溢出
        if (l == r) {
            l++;
            r--;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
