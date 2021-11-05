package com.stack_栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: PolandNotation
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
public class PolandNotation {

    public static void main(String[] args) {

        // 完成将中缀表达式转成后缀代达式的功能
        // 1.  1+((2+3)*4)-5   =>     1 2 3 + 4 * + 5 -
        // 2.  因为直接对Str 进行操作不方便  因此 先将 1+((2+3)*4)-5 转成中缀表达式对应的List
        //     即  ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        // 3.  将得到的中缀表达式的list => 后缀表达式的List
        // 4.  ArrayList [1,+,(,(,2,+,3,),*,4,),-,5] =>  ArrayList [1,2,3,+,4,*,+,5]
        String expression = "1+((2+3)*4)-5";
        System.out.println("中缀表达式:" + toInfixExpression(expression));
        List<String> parseSuffixExpressList = parseSuffixExpressionList(toInfixExpression(expression));
        System.out.println("逆波兰表达式:" + parseSuffixExpressList);
        //结果
        System.out.println("expression:" + expression + "=" + calculator(parseSuffixExpressList));


        // 先定义一个 逆波兰表达式
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //(30+4)*5-6 => 30 4 + 5 * 6 -
        //4*5-8+60+8/2 =>  4 5 * 8 - 60 + 8 2 / +
        // 为了方便 中间用空格隔开
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        // 1 现将suffixExpression 放到一个ArrayList中
        // 2 将ArrayList 传递一个方法 遍历ArrayList 配合栈 完成计算
        List<String> rpnList = getListString(suffixExpression);
        System.out.println("rpnList:" + rpnList);
        System.out.println("结果为: " + calculator(rpnList));

    }

    // 将 中缀表达式转成对应的List
    public static List<String> toInfixExpression(String s) {
        // 定义一个ArrayList 存放中缀表达式的内容
        List<String> arrayList = new ArrayList<String>();
        int i = 0;
        String str; // 做对多位数的拼接
        char c; // 每遍历到一个字符放入c中
        do {
            // 如果c是一个非数字 直接加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) < 57) {
                arrayList.add(c + "");
                i++;
            } else { // 如果是一个数 需要考虑多位数的问题
                str = ""; // str 置空
                while (i < s.length() && (s.charAt(i) >= 48 && s.charAt(i) <= 57)) {
                    str += c;
                    i++;
                }
                arrayList.add(str);
            }
        } while (i < s.length());
        return arrayList;
    }

    // 将得到的中缀表达式的list => 后缀表达式的List ls=ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        // 定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        // 第二个栈 在整个转换过程中 没有pop操作, 而且后面我们号需要逆序输出 还要逆序输出 我们同 List<String> s2 代替
        // Stack<String> s2 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        // 遍历ls
        for (String item : ls) {
            // 如果是一个数 加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop(); // 弹出 (
            } else {
                // 当item的优先级 小于 s1栈顶的运算符的优先级 将 s1 栈顶的运算符弹出并加入到 s2 中，再次转到(4.1)与 s1 中新的栈顶运算符相比较
                while (s1.size() != 0 && (Operation.getValue(item) <= Operation.getValue(s1.peek()))) {
                    s2.add(s1.pop());
                }
                // 还需要将Item入栈
                s1.push(item);
            }
        }
        // 将s1的剩余的运算符加入s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2; // 因为是存在list中  不用逆序 正常输出就是逆波兰表达式
    }

    // 将一个逆波兰表达式 一次将数据和运算符放入一个 ArrayList中
    public static List<String> getListString(String suffixExpression) {
        // 将suffixExpression 按空格分隔
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>(Arrays.asList(split));
        return list;
    }

    // 完成对逆波兰表达式的运算
    // 1．从左至右扫描，将 3 和 4 压入堆栈；
    // 2．遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
    // 3．将 5 入栈；
    // 4．接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
    // 5．将 6 入栈；
    // 6．最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
    public static int calculator(List<String> ls) {
        // 创建一个栈 只需要一个
        Stack<String> stack = new Stack<>();
        // 遍历 ls
        for (String item : ls) {
            // 使用一个正则表达式取出数
            if (item.matches("\\d+")) { // 匹配的是多位数
                // 入栈
                stack.push(item);
            } else { // 如果是运算符
                // pop出两个数并运算
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = a + b;
                        break;
                    case "-":
                        res = a - b;
                        break;
                    case "*":
                        res = a * b;
                        break;
                    case "/":
                        res = a / b;
                        break;
                    default:
                        throw new RuntimeException("符号有问题");
                }
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

// 编写一个类 Operation 返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    // 写一个方法 返回一个优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }

}