package com.search_查找;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: FibonacciSearch
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/24   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr, 1234));
    }

    // 因为后面我们mid = low+F(k - 1)-1. 需要使用斐波那契数列, 因此我们需要先获取到斐波那契数列
    // 用非递归的方法得到一个大小为20的斐波那契数列
    public static int[] fbn() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    // 非递归的方式编写斐波那契数列查找算法

    /**
     * @param a
     * @param key 需要查找的值
     * @return 返回对应的下标 没有则返回-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0; // 表示斐波那契分割数值的下标  mid = low+F(k - 1)-1
        int mid = 0;
        int[] f = fbn(); // 获取斐波那契数列
        // 获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        // 因为 f[k] 可能大于数组a 的长度 需要一个Array类 构造一个新的数组 并指向temp[]
        int[] temp = Arrays.copyOf(a, f[k]); // 多出来的部分用0补起来
        // 实际上需要使用a最后的数填充temp
        // 举例 :temp = {int[8]@529} [1, 8, 10, 89, 1000, 1234, 0, 0]
        // temp:{1,8,10,89,1000,1234,0,0} =>temp:{1,8,10,89,1000,1234,1234,1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        // 使用while循环查找我们的key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//说明应该向数组的前一部分查找(左边)
                high = mid - 1;
                // 为什么是k--
                // 1 全部元素 = 前面的元素 + 后边的元素
                // 2 f[k] = f[k-1] + f[k-2];
                // 因为前面有f[k-1]个元素,所以我们继续拆分   f[k-1] = f[k-2] + f[k-3];
                // 即在f[k-1] 的前面继续查找 k--
                // 即下次在循环的时候 mid = f[k-1-1] -1
                k--;
            } else if (key > temp[mid]) { // 我们继续向数组的右边查找
                low = mid + 1;
                // 为什么是k-2
                // 1 全部元素 = 前面的元素 + 后边的元素
                // 2 f[k] = f[k-1] + f[k-2];
                // 3 因为后面有f[k-2] 所以加足拆分 f[k -2] = f[k-3] + f[k-4];
                // 4 即在f[k-2] 的前面继续查找
                // 下次循环mid = f[k-1-2] -1
                k -= 2;
            } else { // 找到
                // 需要确定返回的是哪个下标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1; // 没有找到

    }
}