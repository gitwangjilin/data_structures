package com.sparsearray_稀疏;

import com.sparsearray_稀疏.utils.FileUtils;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: SparseArray
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/10/18   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class SparseArray {
    public final static String filePath = "C:\\Users\\Chinadaas\\test\\luban-cloud-public\\data_structures\\src\\main\\java\\com\\sparsearray\\稀疏数组.txt";

    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[5][8] = 10;
        chessArr1[6][8] = 9;
        System.out.println("原始数据");
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            int[] ints = chessArr1[i];
            for (int j = 0; j < ints.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int chessArr[][] = new int[sum + 1][3];
        chessArr[0][0] = 11;
        chessArr[0][1] = 11;
        chessArr[0][2] = sum;
        System.out.println(chessArr.toString());
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    chessArr[count][0] = i;
                    chessArr[count][1] = j;
                    chessArr[count][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("稀疏数组1");
        for (int i = 0; i < chessArr.length; i++) {
            FileUtils.WriteStringToFile2(filePath, chessArr[i][0] + " " + chessArr[i][1] + " " + chessArr[i][2]);
            System.out.printf("%d\t%d\t%d\t\n", chessArr[i][0], chessArr[i][1], chessArr[i][2]);
        }
        int[][] ints = FileUtils.readTxtFile(filePath);
        System.out.println("稀疏数组2");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int chessArr2[][] = new int[ints[0][0]][ints[0][1]];
        for (int i = 1; i < chessArr.length; i++) {
            chessArr2[chessArr[i][0]][chessArr[i][1]] = chessArr[i][2];
        }

    }
}
