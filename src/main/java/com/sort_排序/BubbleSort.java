package com.sort_排序;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: BubbleSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/10   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
        bubbleSort(arr);
        int arrTest[] = new int[100000];
        System.out.println("开始时间：" + LocalTime.now());
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = (int) (Math.random() * 80000);
        }
        System.out.println("加数据时间：" + LocalTime.now());

        bubbleSort(arrTest);
        System.out.println("消耗时间：" + LocalTime.now());
//        开始时间：11:11:59.484
//        加数据时间：11:11:59.488
//        消耗时间：11:12:08.934
        int temp = 0;
        boolean flag = false;
        int count = 0; // 标记跑了几趟
        System.out.println("====================================");
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }

        }
        System.out.println("第一趟");
        System.out.println(Arrays.toString(arr));
        // 第二趟排序 , 把第二大的数放在倒数第二位  最后一个数字不参与排序
        for (int j = 0; j < arr.length - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第三趟排序 , 把第三大的数放在倒数第三位  最后两个数字不参与排序
        for (int j = 0; j < arr.length - 3; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序 , 把第四大的数放在倒数第四位  最后三个数字不参与排序
        for (int j = 0; j < arr.length - 4; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));
    }

    private static int[] bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        int count = 0; // 标记跑了几趟
        for (int i = 0; i < arr.length - 1; i++) {
            count++;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) { // 一次交换都没有发生 代表已经排好序了  不用再去进行n-1趟
                break;
            } else {
                flag = false;
            }
        }
//        System.out.println("跑了" + count + "趟");
//        System.out.println("冒泡排序后的数组");
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

}
