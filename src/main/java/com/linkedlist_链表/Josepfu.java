package com.linkedlist_链表;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Josepfu
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/10/29   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(10);
        circleSingleLinkedList.list();
        circleSingleLinkedList.solveJoseph(1, 2, 25);
    }
}

// 创建一个环形的单项链表
class CircleSingleLinkedList {
    // 创建一个first节点, 当前没有编号 等等在设置编号
    private Boy first = new Boy(-1);

    // 添加小孩的节点 构建成一个环形链表
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1 ) {
            System.out.println("nums的值不正确");
            return;
        }
        Boy currentBoy = null; // 辅助指针  帮助构建环形链表
        // 使用一个for循环创建环形链表
        for (int i =1; i <= nums; i++) {
            // 根据编号 创建小孩节点
            Boy newBoy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1){
                first = newBoy;
                first.setNext(first); // 构成一个环
                currentBoy = first; // 让currentBoy指向第一个小孩  first节点不能动
            }else {
                currentBoy.setNext(newBoy);
                newBoy.setNext(first);
                currentBoy = newBoy;
            }
        }
    }

    // 遍历当前环形链表
    public void list(){
        Boy currentBoy = first;
        if (currentBoy.getNo() == -1){
            System.out.println("当前环形链表为空,无法遍历");
            return;
        }
        while (true) {
            System.out.println("小孩编号"+currentBoy.getNo());
            currentBoy = currentBoy.getNext();
            if (currentBoy == first){
                break;
            }
        }
    }

    // 根据用户的输入 计算小孩出圈的顺序

    /**
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param num 表示最初有多少个小孩
     * @return
     */
    public void solveJoseph(int startNo, int countNum, int num){
        // 先对数据进行校验
        if (first.getNo() == -1 || startNo < 1 || startNo > num){
            System.out.println("参数输入有误,请重新输入");
            return;
        }
        // 创建辅助指针 helper  帮助完成小孩出圈
        Boy helper = first;
        // 先让helper 指向环形队列的最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }
        //当小孩报数之前 先让first 和helper 移动 startNo-1次
        for (int j = 0; j < startNo-1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 当小孩报数时, 让first和helper 指针同时的移动 countNum - 1 次, 然后出圈
        // 这里是一个循环操作 , 直到圈里只有一个节点
        while (true) {
            if (helper == first) { // 当前圈中只有一个人
                System.out.print("最后出圈: "+first.getNo()+"");
                break;
            }
            for (int i = 0; i < countNum -1; i++ ) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这是后first指向的小孩 出圈
            System.out.print(first.getNo()+" ");
            first = first.getNext();
            helper.setNext(first);

        }


    }

}


// 创建一个Boy类 标识一个节点
class Boy {
    private int no; // 编号
    private Boy next; // 指向下一个节点,默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}