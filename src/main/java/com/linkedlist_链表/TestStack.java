package com.linkedlist_链表;

import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: TestStack
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/10/21   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class TestStack {
    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.add("12");
        strings.add("13");
        strings.add("14");
        while (strings.size()>0){
            System.out.println(strings.pop());
        }
    }
}
