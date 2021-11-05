package com.linkedlist_链表;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: JosepfuTest
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/1   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class JosepfuTest {
    public static void main(String[] args) {
        CircleSingleLinkedListTest circleSingleLinkedListTest = new CircleSingleLinkedListTest();
        circleSingleLinkedListTest.addJosepfu(2);
        circleSingleLinkedListTest.findJosepfu();
    }
}

class CircleSingleLinkedListTest {
    private BoyTest first = new BoyTest(-1);

    public void addJosepfu(int nums) {
        BoyTest newBoy = null;
        for (int i = 1; i <= nums; i++) {
            BoyTest boy = new BoyTest(i);
            if (i == 1) {
                first = boy;
                first.setBoyTest(boy);
                newBoy = first;
            }else{
                newBoy.setBoyTest(boy);
                boy.setBoyTest(first);
                newBoy = first;
            }
        }
    }

    public void findJosepfu() {
        BoyTest currentBoy =first;
        while (true) {
            System.out.println(currentBoy);
            currentBoy = currentBoy.getBoyTest();
            if (first == currentBoy) {
                break;
            }
        }
    }
}

class BoyTest {
    private int no;
    private BoyTest BoyTest;

    public BoyTest(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "BoyTest{" +
                "no=" + no +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public com.linkedlist_链表.BoyTest getBoyTest() {
        return BoyTest;
    }

    public void setBoyTest(com.linkedlist_链表.BoyTest boyTest) {
        BoyTest = boyTest;
    }
}
