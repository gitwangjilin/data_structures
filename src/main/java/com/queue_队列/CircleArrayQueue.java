package com.queue_队列;

import java.util.Scanner;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: CircleArrayQueue
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/10/19   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class CircleArrayQueue {
    public static void main(String[] args) {
        // 测试
        // 创建一个环形队列
        CircleArray arrayQueue = new CircleArray(4); // 设置为4 但是数组的有效空间是3
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
class CircleArray  {
    private int maxSize; // 表示数组的最大容量
    // front 的变量的含义 做调整 就指向队列的第一个元素 也就是 arr[front] 是第一个头元素
    // front初始值变为0
    private int front; // 队列头部
    // rear 变量的含义做一个调整 rear指向队列的最后元素的后一个位置 因为希望空出一个空间做约定  rear的初始值为0
    private int rear; // 队列尾部
    private int[] arr; // 存放数据  模拟队列

    // 创建队列的构造器
    public CircleArray(int maxSize){
        this.maxSize = maxSize;
        arr= new int[maxSize];
        //front = rear = 0 ; // 队列头部和尾部 front指向队列头部的头一个位置  rear指向队列尾部的具体位置
    }

    // 判断队列是否满
    public boolean isFull(){
        return (rear + 1)% maxSize == front;
    }

    // 判断对列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    // 添加数据到对列
    public void addQueue(int n){
        // 判断队列是否满
        if(isFull()){
            System.out.println("队列满,不能加入数据");
            return;
        }
        // rear指向对位的后一个位置 直接将数据加入  在后移rear指针
        arr[rear] = n;
        // 要考虑取模 如果rear已经在 数组的最后位置  需要进行取模到数组的开始部分
        rear = (rear + 1) % maxSize;
    }

    // 数据出队列
    public int getQueue(){
        // 判断对垒是否空
        if(isEmpty()){
            throw new RuntimeException("队列为空不能取数据");
        }
        // 这里需要分析出front是 指向队列的第一个元素
        // 1 先把 front对应的值 保存到临时变量
        // 2 将front 后移
        // 3 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 显示对列的所有数据
    public void showQueue(){
        // 判断队列是否为空
        if(isEmpty()){
            System.out.println("队列为空");
            return;
        }
        // 思路: 从front开始遍历, 遍历多少个元素
        //
        for (int i = front; i < front + size(); i++){
            System.out.println("arr["+ i % maxSize +"]="+arr[i % maxSize]);
        }
    }

    // 显示对列的头部的数据  不是取出数据
    public int headQueue(){
        // 判断是否为空
        if(isEmpty()){
            throw new RuntimeException("队列为空,没有头数据");
        }
        return arr[front];
    }

    // 求出当前队列的有效数据的个数
    public int size() {
        return  (rear + maxSize - front) % maxSize;
    }
}