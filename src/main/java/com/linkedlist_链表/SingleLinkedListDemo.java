package com.linkedlist_链表;

import java.util.Stack;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: SingleLinkedList
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
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 先创建节点
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(23, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(13, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(8, "林冲", "豹子头");
        HeroNode heroNode5 = new HeroNode(6, "林冲", "豹子头");
        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
//		singleLinkedList.add(heroNode1);
//		singleLinkedList.add(heroNode2);
//		singleLinkedList.add(heroNode3);
//		singleLinkedList.add(heroNode4);
        // 加入按照编号的顺序
        singleLinkedList.addByOrder(heroNode1);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode5);
        singleLinkedList.list();
        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
        System.out.println(singleLinkedList.findNodeStartLast(singleLinkedList.getHead(), 5));
    }
}

// 定义一个单向链表 管理我们的英雄
class SingleLinkedList {
    // 初始化一下头结点  头结点不要动 不存放具体的数据
    private HeroNode head = new HeroNode(0, null, null);

    public HeroNode getHead() {
        return head;
    }

    // 添加方法到单向链表
    // 思路 当不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后的这个节点的next 指向 新节点
    public void add(HeroNode heroNode) {
        // 因为 head节点不能动 我们需要一个辅助节点 temp
        HeroNode temp = head;
        // 遍历链表找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到 就将temp后移
            temp = temp.next;
        }
        // 当退出white循环时, temp 就指向了链表的最后
        temp.next = heroNode;
    }

    // 第二种添加英雄的方式, 根据排名将英雄插入到指定位置
    // 如果有这个排名, 则添加失败 并给出提示
    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动 因此我们任然通过一个辅助指针(变量) 来帮助找到添加的位置
        // 因为是单列表 temp是要找到添加节点的前一个节点, 否则插入不了
        HeroNode temp = head;
        boolean flag = false; // 标志添加的编号是否存在 默认为false
        while (true) {
            if (temp.next == null) { // 说明已经到了链表的最后了
                break;
            }
            if (temp.next.no > heroNode.no) { // 位置找到了 在temp和temp.next之间插入该节点
                break;
            } else if (temp.next.no == heroNode.no) { // 说明希望添加的heroNode的编号已经存在 不能添加
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next;
        }
        // 判断 flag的值
        if (flag) { // 不能添加 说明编号存在
            System.out.println("准备插入的英雄的编号[" + heroNode.no + "]已存在,不能加入!");
        } else {
            // 插入链表中 temp 中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 显示链表 遍历
    public void list() {
        // 判断链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头结点不能动我们需要一个复制节点 temp
        HeroNode temp = head.next;
        while (true) {
            // 输出这个节点的信息
            System.out.println(temp);
            if (temp.next == null) {
                break;
            }
            // 将temp 后移 不然是一个死循环
            temp = temp.next;
        }

    }

    // 修改节点的信息 根据编号来修改 编号不能修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点 很具no查询
        HeroNode temp = head.next;
        boolean flag = false; // 表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; // 表示链表已经遍历结束了 (不是最后一个节点 已经出到外面去了)
            }
            if (temp.no == newHeroNode.no) {
                // 找到要修改的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if (!flag) {
            System.out.println("没有找到编号为[" + newHeroNode.no + "]的节点");
        } else {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }

    }

    // 删除节点
    //思路 1.head节点不能动 因此我们需要一个temp辅助节点找到删除节点的前一个节点
    //    2. 我们需要以temp节点的后一个节点的标号进行比较
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) { // temp已经到链表的最后
                break;
            }
            if (temp.next.no == no) {
                // 找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 可以删除
            HeroNode t = temp.next;
            temp.next = t.next;
            t.next = null;
        } else {
            System.out.println("没有找到该no=[" + no + "]节点,无法删除");
        }


    }

    /**
     * @param head 链表的头节点
     * @return 返回的是有效节点个数
     */
    public Integer getLength(HeroNode head) {
        if (head.next == null) {
            // 空链表
            return 0;
        }
        int length = 0;
        // 定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    // 求单链表的倒数第K个节点
    // 思路 1 编写一个方法接收head节点 接收index(倒数第index节点)
    //     2 先把链表变历 求出长度 length  去找到length-index的节点
    public HeroNode findNodeStartLast(HeroNode head, int index) {
        // 如果链表为空 返回null
        if (head.next == null) {
            return null;
        }
        // 变历得到链表的长度
        int length = this.getLength(head);
        // 再一次遍历  返回 第length - index
        // 先做一个index的校验
        if (index <= 0 || index > length) {
            return null;
        }
        // 定义一个辅助节点
        HeroNode temp = head.next;
        for (int i = 0; i < length - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // 单链表的反转
    public HeroNode reverseNode(HeroNode head) {
        if (head.next == null) {
            return head;
        }
        HeroNode reverseHeroNode = new HeroNode(0, null, null);
        while (head.next != null) {
            if (reverseHeroNode.next == null) {
                reverseHeroNode.next = head.next;
                head.next = head.next.next;
                reverseHeroNode.next.next = null;
            } else {
                HeroNode temp = reverseHeroNode.next;
                reverseHeroNode.next = head.next;
                head.next = head.next.next;
                reverseHeroNode.next.next = temp;
            }
        }
        head.next = reverseHeroNode.next;
        return head;
    }
    // 使用栈的方式 实现逆序打印单链表
    public static void reversePrint(HeroNode head){
        if(head.next == null) {
            System.out.println("队列为空,无法逆序打印单链表");
            return;
        }
        HeroNode temp = head;
        Stack<HeroNode> heroNodeStack = new Stack<>();
        while (temp.next != null){
            heroNodeStack.add(temp.next);
            temp = temp.next;
        }
        while (heroNodeStack.size() > 0){
            System.out.println(heroNodeStack.pop());
        }
    }

}

// 定义一个HeroNode , 每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next; // 指向下一个节点

    // 构造器
    public HeroNode(int hNo, String hName, String hNickName) {
        this.no = hNo;
        this.name = hName;
        this.nickName = hNickName;
    }

    // 为了显示方便 重写toString方法
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public HeroNode getNext() {
        return next;
    }
}