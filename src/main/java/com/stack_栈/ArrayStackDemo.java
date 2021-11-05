package com.stack_栈;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: ArrayStackDemo
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/2   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("遍历栈");
        stack.list();
    }

}

// 定义一个 ArrayStack 表示栈
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组, 数组模拟栈 将栈的数据放入数组
    private int top = -1; //表示栈顶 初始化为-1

    // 构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满判断
    public boolean isFull() {
        return top == (maxSize - 1);
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈的操作
    public void push(int value) {
        // 判断是否满
        if (isFull()) {
            System.out.println("栈已经满了,无法入栈");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 将栈顶的数据返回
    public int pop() {
        // 先判断栈是否空
        if (isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        return stack[top--];
    }

    // 显示栈信息(遍历栈) 遍历时 需要从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空,没有数据");
            return;
        }
        int i = top;
        while (i >= 0) {
            System.out.println(stack[i--]);
        }
    }


}
