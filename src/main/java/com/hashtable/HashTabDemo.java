package com.hashtable;

import java.util.Scanner;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: HashTabDemo
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/11/24   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class HashTabDemo {
    public static void main(String[] args) {
        // 创建一个哈希表
        HashTab hashTab = new HashTab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
// 定义hash表
class HashTab{
    public EmployLinkedList[] employLinkedListArray;
    private int size; //有多少条链表

    public HashTab(int size) {
        // 初始化链表
        this.size = size;
        this.employLinkedListArray = new EmployLinkedList[size];
        // 不要忘了 分别初始化每个链表
        for (int i = 0; i < size; i++){
            employLinkedListArray[i] = new EmployLinkedList();
        }
    }

    // 添加顾员
    public void add (Emp emp){
        // 通过员工的Id 得到该员工应该添加到哪一个链表
        int empLinkedListNo = hashFun(emp.id);
        // 将emp 添加到链表自己中
        employLinkedListArray[empLinkedListNo].add(emp);
    }

    //遍历所有的链表
    public void list(){
        int index = 0;
        for (EmployLinkedList e :employLinkedListArray){
            e.list(index);
            index++;
        }
    }

    // 添加顾员
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        System.out.println(employLinkedListArray[empLinkedListNo].findEmpById(id)==null?"没有该节点哦":
                employLinkedListArray[empLinkedListNo].findEmpById(id));
    }

    // 编写一个散列函数 使用简单的取模法
    public int hashFun(int id){
        return id % size;
    }

}

// 表示顾员
class Emp{
    public int id;
    public String name;
    public Emp next = null;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// 创建一个EmployLinkedList
class EmployLinkedList{
    // 头指针 指向第一个Emp ,这个头指针是直接指向第一个Emp
    private Emp head = null;

    // 添加顾员到链表
    // 假定添加顾员的时候 id自增  将该雇员插入链表的最后一个
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }
        Emp temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        // 当前的temp为最后一个
        temp.next = emp;
    }

    // 遍历连表的顾员信息
    public void list(int i){
        if (head == null){
            System.out.println("第"+i+"条链表为空");
            System.out.println();
            return;
        }
        Emp temp = head;
        System.out.print("第"+i+"条链表内的数据为: ");
        while (temp != null){
            System.out.print(temp+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    // 根据Id查找顾员
    // 如过找不到返回空
    public Emp findEmpById(int id) {
        if (head == null){
            return null;
        }
        Emp temp = head;
        while (temp != null){
            if (temp.id == id){
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }
}