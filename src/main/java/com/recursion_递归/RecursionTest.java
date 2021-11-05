package com.recursion_递归;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Recursion
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
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int factorial = factorial(2);
        System.out.println(factorial);
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    private static void test(int i) {
        if (i > 2) {
            test(i - 1);
        }
//        } else {
//            System.out.println(i); //2
//        }
        System.out.println(i);
    }

}
