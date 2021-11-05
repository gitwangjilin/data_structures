package com.queue_队列;

import java.util.Scanner;
/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: ArrayQueueDemo
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
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrQueue arrQueue = new ArrQueue(3);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):推出程序");
            System.out.println("a(add):添加数据队列");
            System.out.println("g(get):从队列中取出数据");
            System.out.println("h(head):查看队列数据");
            switch (key){
                case 'a':
                    System.out.println();
            }
        }

    }

}

class ArrQueue {
    //最多容量
    private int maxSize;
    //队列头
    private int front;
    //队列尾
    private int rear;
    //该用于存储数据，模拟队列
    private int[] arr;

    //初始化数据
    public ArrQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否为空
    public boolean ifFull() {
        return rear == maxSize - 1;
    }

    //添加数据
    public void addQueue(int n) {
        if (ifFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[++rear] = n;
    }

    //去除数据
    public int getQueue() {
        if (isEnpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    private boolean isEnpty() {
        return false;
    }

    //显示所有数据
    public void showQueue() {
        if (isEnpty()) {
            System.out.println("空数据");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示头数据
    public int headQueue() {
        if (isEnpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}