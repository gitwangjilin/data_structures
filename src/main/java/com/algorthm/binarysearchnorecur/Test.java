package com.algorthm.binarysearchnorecur;

import java.util.Arrays;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Test
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/12/13   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Test {
    public static void main(String[] args) {
//        nums = [2,7,11,15], target = 9
        int target = 9;
        int[] nums = new int[]{2, 7, 11, 15};
        int[] newNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    newNums[0] = i;
                    newNums[1] = j;
                    break;
                }

            }
        }
        System.out.println(Arrays.toString(newNums));
    }
}
