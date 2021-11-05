package com.queue_队列;

import java.util.Scanner;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: ArrayQueueDemo1
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
public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 测试
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true; // 控制循环
        // 输出一个菜单
        while (loop){
            System.out.println("s(show): 显示对列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到对列");
            System.out.println("g(get): 从对列取出数据");
            System.out.println("h(head): 查看对列头的数据");
            key = scanner.next().charAt(0); //接收这个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println("取出的数据:"+arrayQueue.getQueue());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("队列头部的数据:"+arrayQueue.headQueue());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default :
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

// 使用数组模拟队列  编写一个ArrayQueue类
class ArrayQueue {
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头部
    private int rear; // 队列尾部
    private int[] arr; // 存放数据  模拟队列

    // 创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr= new int[maxSize];
        front = rear = -1; // 队列头部和尾部 front指向队列头部的头一个位置  rear指向队列尾部的具体位置
    }

    // 判断队列是否满
    public Boolean isFull(){
        return rear == maxSize - 1;
    }

    // 判断对列是否为空
    public Boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到对列
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列满,不能加入数据");
            return;
        }
        // rear 后移
        arr[++rear] = n;
    }

    // 数据出队列
    public int getQueue(){
        // 判断对垒是否空
        if(isEmpty()){
            throw new RuntimeException("队列为空不能取数据");
        }
        return arr[++front];
    }

    // 显示对列的所有数据
    public void showQueue(){
        // 判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }

    // 显示对列的头部的数据  不是取出数据
    public int headQueue(){
        // 判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空,没有头数据");
        }
        return arr[front + 1];
    }
}