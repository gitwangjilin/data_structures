package com.search_查找;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: InsertValueSearch
 * - @Author: WangJiLIn
 * - Description: 差值查找
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/24   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for(int i = 1; i <= 100;i++){
            arr[i-1] = i;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 100));
    }

    // 编写差值查找算法

    /**
     * 差值查找算法的前提要求也是数组要有序
     * @param arr 传入的数组
     * @param left 左边的索引
     * @param right 右边的索引
     * @param findVal 要查找的值
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal){
        if(left > right || findVal < arr[0] || findVal > arr[arr.length - 1]){ // 优化查找 且防止越界
            return -1;
        }

        // 求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if(findVal > midVal) { // 向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        }else if (findVal < midVal){ // 向左递归
            return insertValueSearch(arr, 0, mid-1, findVal);
        }else {
            return mid;
        }

    }
}