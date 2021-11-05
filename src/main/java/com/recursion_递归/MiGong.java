package com.recursion_递归;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: MiGong
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
public class MiGong {
    public static void main(String[] args) {
        // 创建一个二维数组 模拟迷宫
        int[][] map = new int[8][7];
        // 使用1表示墙
        // 上下置位1
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右置位1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //
        // 设置挡板 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
        //map[1][2] = 1;
        //map[2][2] = 1;
        // 输出地图
        System.out.println("输出地图");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        // 使用递归回溯 找路 map是引用类型  可以动态改变值 等于公共变量
        if (setWay(map, 1, 1)) {
            // 输出新的地图
            System.out.println("小球的路径");
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("无法找到");
        }


    }

    // 使用递归回溯给小球找路
    // 说明 map是地图
    //     i,j表示从哪个位置开始出发(i,j)
    //     如果小球到map[6][5] = 则说明通路找到
    //     约定 当map[i][j] 为0时 表示该点没有走过 1为墙 2为通路(小球行径路径) 3为该位置已经走过 但是走不通
    //     再走迷宫时 需要确定一个策略(行径方向 当走不通时往策略的下一个方向)  下->右->上->左 ,如果该点都走不通 在回溯

    /**
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到通路 返回true 否则为false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            // 说明通路已经找到
            return true;
        } else {
            //如果当前的点还没有走过
            if (map[i][j] == 0) {
                // 按照上述策略 下->右->上->左尝试
                map[i][j] = 2; // 假的当前点可以走
                if (setWay(map, i + 1, j)) { // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)) { // 向上走
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向左走
                    return true;
                } else {
                    // 都没走通 这个点是个思死路
                    map[i][j] = 3;
                    return false;
                }
            } else { // 肯能为 1是墙 2走过 3不能走
                return false;
            }
        }
    }

}
//        输出地图
//        1 1 1 1 1 1 1
//        1 0 0 0 0 0 1
//        1 0 0 0 0 0 1
//        1 1 1 0 0 0 1
//        1 0 0 0 0 0 1
//        1 0 0 0 0 0 1
//        1 0 0 0 0 0 1
//        1 1 1 1 1 1 1
//        小球的路径
//        1 1 1 1 1 1 1
//        1 2 0 0 0 0 1
//        1 2 2 2 0 0 1
//        1 1 1 2 0 0 1
//        1 0 0 2 0 0 1
//        1 0 0 2 0 0 1
//        1 0 0 2 2 2 1
//        1 1 1 1 1 1 1
