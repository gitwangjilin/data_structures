package com.search_查找;

import java.util.ArrayList;
import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: BinarySearch
 * - @Author: WangJiLIn
 * - Description: 二分查找
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/19   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1000, 1000, 1000, 1000, 1001, 1002};
//        System.out.println(binarySearch(arr, 0, arr.length - 1, 1000));
        System.out.println(binarySearchUpgrade(arr, 0, arr.length - 1, 1000));
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

    // 对多个相同值的查找
    // 思路分析 在找到mid的时候不要马上返回 向mid的索引的左/右边扫描  将所有满足的查找值1000的所有下标 放入数组中

    public static ArrayList<Integer> binarySearchUpgrade(int[] arr, int left, int right, int findVal) {
        ArrayList<Integer> resIndexList = new ArrayList<>();
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (left > right) {
            resIndexList.add(-1);// 没有找到
            return resIndexList;
        }
        if (findVal > midVal) { // 向右递归
            return binarySearchUpgrade(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向右递归
            return binarySearchUpgrade(arr, left, mid, findVal);
        } else {
            int temp = mid;
            // 向左扫描
            Stack stack = new Stack();
            while (arr[--temp] == midVal) {
                stack.push(temp);
            }
            if (stack.isEmpty()) {
                resIndexList.add((Integer) stack.pop());
            }
            // 向右扫描
            while (arr[++temp] == midVal) {
                resIndexList.add(temp);
            }
//            resIndexList.add(mid);
            return resIndexList;
        }
    }


}