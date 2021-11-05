package com.stack_栈;

import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: Calculator
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
public class Calculator {
    public static void main(String[] args) {
        // 根据前面的思路  完成 表达式的运算
        String expression = "72*2*2-5+1-5+3-4";
        // 创建两个栈, 数栈, 一个符号转
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0; // 用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; // 将每次扫描的char 保存到ch
        String keepNum = ""; // 用于拼接多位数的
        // 开始用 while循环的扫描语句 扫描 Expression
        while (true) {
            // 依次得到Expression 的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断是否是数字和符号 做相应的处理
            if (operStack.isOper(ch)) { // 如果是运算符
                // 判断当前的符号栈 是否为空
                if (!operStack.isEmpty()) {
                    // 如果符号栈有操作符 就进行比较 如果当前的操作符的优先级小于等于栈中的操作符,就需要从数栈中pop出两个数
                    // 再从符号栈中pop出一个符号 ,进行运算,将得到的结果,入数栈 然后将 当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peak())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 把运算的结果 入数栈
                        numStack.push(res);
                        // 把当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        // 如果当前的操作符的优先级大于栈中的操作符, 就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    operStack.push(ch);
                }
            }else { // 如果是数字 则直接入数栈 注意这是字符  不是真正的数字
                // numStack.push(ch - 48);  这样子有问题 13 + 1 => '1' '3' '+' '1'
                // 在处理多位数时, 不能发现是一个数就立即入栈 因为他可能是多位数
                // 在处理数,需要向expression的表达式的index 后再看一位 , 如果是数 就进行扫描, 如果是符号才入栈
                // 因此我们需要定义一个变量 keepNum字符串 ,用于拼接多位数

                //处理多为数
                keepNum += ch;

                // 如果ch是expression的最后一位 直接入栈
                if (index == expression.length()-1){
                    numStack.push(ch - 48);
                }else {
                    // 判断下一个字符 是不是数组 ,就继续扫描 ,如果是运算符 则入栈
                    // 只看后一位 不是index++
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果后一位是运算符 则数字入栈
                        numStack.push(Integer.parseInt(keepNum));
                        // 重要的!!!!!! 清空keepNum
                        keepNum = "";
                    }
                }
            }
            // index +1 并判断是否扫描到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        // 当表达式扫描完毕, 就顺序的从 数栈和符号栈中pop出相应的数和符号,并运行
        while (true) {
            // 如果符号栈为空,则计算到最后的结果 数字栈 只有一个结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(expression+" = "+res);
    }
}

// 先创建一个栈 ,直接使用前面创建好的  需要扩展功能
// 定义一个 ArrayStack 表示栈
class ArrayStack2 {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组, 数组模拟栈 将栈的数据放入数组
    private int top = -1; //表示栈顶 初始化为-1

    // 构造器
    public ArrayStack2 (int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满判断
    public boolean isFull() {
        return top == (maxSize-1);
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈的操作
    public void push (int value) {
        // 判断是否满
        if (isFull()){
            System.out.println("栈已经满了,无法入栈");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈 将栈顶的数据返回
    public int pop () {
        // 先判断栈是否空
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        return  stack[top--];
    }

    // 显示栈信息(遍历栈) 遍历时 需要从栈顶开始显示
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空,没有数据");
            return;
        }
        int i = top;
        while (i >= 0){
            System.out.println(stack[i--]);
        }
    }

    // 查看栈顶的值  不出栈
    public int peak() {
        if (top == -1) {
            System.out.println("为空栈");
            return -1;
        }
        return stack[top];
    }

    // 返回运算符的有限及 , 假定 返回值的数字越大 优先级越高
    public int priority(int oper){
        if (oper == '*' || oper == '/') { // java可以数字和字符比
            return 1;
        }else if(oper == '+' || oper == '-') {
            return 0;
        }else {
            return -1; // 嘉定目前计算式子中 只有加减乘除
        }
    }

    // 判断是不是一个操作符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public int cal(int num1, int num2, int oper ){
        int res = 0;
        switch (oper){
            case '+' :
                res = num1 + num2;
                break;
            case '-' :
                res = num2 - num1; // 注意顺序
                break;
            case '*' :
                res = num2 * num1;
                break;
            case '/' :
                res = num2 / num1; // 注意顺序
                break;
            default:break;
        }
        return res;
    }
}