package com.sort_排序;

import java.time.LocalTime;
import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: SelectSort
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
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
        int arrTest[] = new int[100000];
        System.out.println("开始时间：" + LocalTime.now());
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = (int) (Math.random() * 80000);
        }
        System.out.println("加数据时间：" + LocalTime.now());

        selectSort(arrTest);
        System.out.println("消耗时间：" + LocalTime.now());
    }

    private static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }

            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
//            System.out.println(Arrays.toString(arr));
        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            int minIndex = i;
//            int min = arr[i];
//            for (int j = i + 1; j < arr.length; j++) {
//                if (min > arr[j]) {
//                    min = arr[j];
//                    minIndex = j;
//                }
//            }
//            if (minIndex != i) {
//                arr[minIndex] = arr[i];
//                arr[i] = min;
//            }
//            System.out.println(Arrays.toString(arr));
//        }
    }

}
