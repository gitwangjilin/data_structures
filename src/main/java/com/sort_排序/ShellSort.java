package com.sort_排序;

import java.time.LocalTime;
import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: ShellSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/11   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class ShellSort {
    public static int shellSort = 0;
    public static int count = 0;
    public static int hellSortBetter = 0;

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7};

        hellSortBetter(arr);

        hellSortBetter(arr);
        int arrTest[] = new int[100000];
        System.out.println("开始时间：" + LocalTime.now());
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = (int) (Math.random() * 800002);
        }
        System.out.println("加数据时间：" + LocalTime.now());
        shellSort(arrTest);
        System.out.println("shellSort:" + shellSort);

        hellSortBetter(arr);
        System.out.println("hellSortBetter:" + hellSortBetter);

//        shellSort(arrTest);
        System.out.println("消耗时间：" + LocalTime.now());
        System.out.println(Arrays.toString(arr));

    }

    private static void shellSort(int[] arr) {
        int temp = 0;
        for (int c = arr.length / 2; c > 0; c /= 2) {
            for (int i = 5; i < arr.length; i++) {
                for (int j = i - c; j >= 0; j -= c) {
                    if (arr[j] > arr[j + c]) {
                        shellSort++;
                        temp = arr[j];
                        arr[j] = arr[j + c];
                        arr[j + c] = temp;
                    }
                }

            }

        }

//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("=========================");
//
//        for (int i = 5; i < arr.length; i++) {
//            for (int j = i - 5; j >= 0; j -= 5) {
//                if (arr[j] > arr[j + 5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//
//        }
//        System.out.println(Arrays.toString(arr));
//
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//
//        }
//        for (int i = 1; i < arr.length; i++) {
//            for (int j = i - 1; j >= 0; j -= 1) {
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//
//        }
//        System.out.println(Arrays.toString(arr));

    }

    // 对交换式的希尔排序法进行优化 -> 移位法
    public static void hellSortBetter(int[] input) {
        int group = input.length / 2;
        int insertIndex = 0;
        int insertValue = 0;
        while (group != 0) {
            for (int i = group; i < input.length; i++) {
                insertIndex = i - group;
                insertValue = input[i];
                while (insertIndex >= 0 && insertValue < input[insertIndex]) {
                    hellSortBetter++;
                    input[insertIndex + group] = input[insertIndex];
                    insertIndex -= group;
                }
                input[insertIndex + group] = insertValue;
            }
            group /= 2;
        }

    }

}