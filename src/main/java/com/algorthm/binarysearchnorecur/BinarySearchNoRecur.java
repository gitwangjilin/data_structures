package com.algorthm.binarysearchnorecur;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: BinarySearchNoRecur
 * - @Author: WangJiLIn
 * - Description:  二分查找，递归与非递归
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/12/3   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        //测试
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 2);
        System.out.println("index=" + index);//
        System.out.println(binarySearch(0, arr.length - 1, arr, 2));

    }

    private static int binarySearch(int left, int right, int[] arr, int target) {
        int mid = left + right / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            binarySearch(mid, right, arr, target);
        } else {
            binarySearch(mid, right, arr, target);
        }
        return 0;
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1; //需要向右边查找
            }
        }
        return 122;
    }
    // 二分查找算法

    /**
     * @param arr     数组
     * @param left    查找时 左边的索引
     * @param right   查找时 右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标 没找到返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            return -1;// 没有找到
        }
        if (findVal > midVal) { // 向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向右递归
            return binarySearch(arr, left, mid, findVal);
        } else {
            return mid;
        }
    }
}
