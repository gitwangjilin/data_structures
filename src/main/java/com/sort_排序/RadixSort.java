package com.sort_排序;

import java.time.LocalTime;
import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: RadixSort
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions: 基数排序
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/16   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        //radixSort(arr);
//        radixSortAll(arr);
        int arrTest[] = new int[10000000];
        System.out.println("开始时间：" + LocalTime.now());
        for (int i = 0; i < arrTest.length; i++) {
            arrTest[i] = (int) (Math.random() * 80000);
        }
        System.out.println("加数据时间：" + LocalTime.now());
        int[] temp = new int[arrTest.length]; // 归并排序需要额外的空间

        radixSortAll(arrTest);

        System.out.println("消耗时间：" + LocalTime.now());
    }

    // 基数排序法
    public static void radixSort(int[] arr) {
        // 模拟对一轮(针对每个元素的个位数进行排序处理)

        // 定义一个二维数组,表示一个二维数组, 每个桶就是一个一维数组
        // 说明 二维数组包含10个一维数组
        //     为了防止放入数的时候 数据溢出 ,则每一个一维数组的大小为array.length()
        //     很明显 空间换时间
        int[][] bucket = new int[10][arr.length];
        // 为了记录每个桶中 实际存放了多少个数据 我们定义一个一维数组来记录每个桶的个数
        // bucketElementCounts[0] 就是bucket[0] 的放入数据的个数
        int[] bucketElementCounts = new int[10];
        for (int j = 0; j < arr.length; j++) {
            // 取数每个元素的个位
            int digitOfElement = arr[j] % 10;
            // 放入到对应的桶
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 将桶里的数据放入
        int index = 0;
        // 遍历每一个桶 将桶里的数据放入 原来的数组中
        for (int k = 0; k < bucket.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int j = 0; j < bucketElementCounts[k]; j++) {
                    arr[index++] = bucket[k][j];
                }
            }
            // 第一轮需要对bucketElementCounts数组置零
            bucketElementCounts[k] = 0;
        }
//        System.out.println("第一轮 对个位数进行处理后的数组:" + Arrays.toString(arr));

        // 模拟对二轮(针对每个元素的十位数进行排序处理)

        for (int j = 0; j < arr.length; j++) {
            // 取数每个元素的十位
            int digitOfElement = arr[j] / 10 % 10;
            // 放入到对应的桶
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 将桶里的数据放入
        index = 0;
        // 遍历每一个桶 将桶里的数据放入 原来的数组中
        for (int k = 0; k < bucket.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int j = 0; j < bucketElementCounts[k]; j++) {
                    arr[index++] = bucket[k][j];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第二轮 对十位数进行处理后的数组:" + Arrays.toString(arr));

        // 模拟对三轮(针对每个元素的百位数进行排序处理)

        for (int j = 0; j < arr.length; j++) {
            // 取数每个元素的百位
            int digitOfElement = arr[j] / 100 % 10;
            // 放入到对应的桶
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
        }
        // 将桶里的数据放入
        index = 0;
        // 遍历每一个桶 将桶里的数据放入 原来的数组中
        for (int k = 0; k < bucket.length; k++) {
            if (bucketElementCounts[k] != 0) {
                for (int j = 0; j < bucketElementCounts[k]; j++) {
                    arr[index++] = bucket[k][j];
                }
            }
            bucketElementCounts[k] = 0;
        }
        System.out.println("第三轮 对百位数进行处理后的数组:" + Arrays.toString(arr));

    }

    // 总的基数排序
    public static void radixSortAll(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCounts = new int[10];
        int index;
        // 需要获取最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                // 放入到对应的桶
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            // 将桶里的数据放入
            index = 0;
            // 遍历每一个桶 将桶里的数据放入 原来的数组中
            for (int k = 0; k < bucket.length; k++) {
                if (bucketElementCounts[k] != 0) {
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                bucketElementCounts[k] = 0;
            }

        }
//        System.out.println("基数排序的结果" + Arrays.toString(arr));
    }


}