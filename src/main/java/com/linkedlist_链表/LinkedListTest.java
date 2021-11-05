package com.linkedlist_链表;

/*************************************************************************
 ******
 * - Copyright (c) 2021 shangzhao.com
 * - File Name: LinkedListTest
 * - @Author: WangJiLIn
 * - Description:
 * 接⼝描述
 * - Functions:
 *
 * - History:
 * Date        Author          Modification
 * 2021/10/25   WangJiLin     Create the current class
 *************************************************************************
 ******/
public class LinkedListTest {
    public static int a = 0;

    public static void main(String[] args) {

        // 先创建节点
        HeroNode3 heroNode1 = new HeroNode3(1, "宋江", "及时雨");
        HeroNode3 heroNode2 = new HeroNode3(23, "卢俊义", "玉麒麟");
        HeroNode3 heroNode3 = new HeroNode3(13, "吴用", "智多星");
        HeroNode3 heroNode4 = new HeroNode3(1, "林冲", "豹子头");
        HeroNode3 heroNode5 = new HeroNode3(13, "林冲", "豹子头");
        HeroNode3 heroNode6 = new HeroNode3(14, "林冲", "豹子头");
        LinkedListTestUtil.addSortHeroNode(heroNode1);
        LinkedListTestUtil.addSortHeroNode(heroNode2);
        LinkedListTestUtil.addSortHeroNode(heroNode3);
        LinkedListTestUtil.updateHeroNode(heroNode4);
        LinkedListTestUtil.deleteHeroNode(heroNode5);
        LinkedListTestUtil.deleteHeroNode(heroNode6);
        LinkedListTestUtil.list();
        LinkedListTestUtil.getLength();
        LinkedListTestUtil.findNodeStartLast(LinkedListTestUtil.getLength(),2);
    }
}

class LinkedListTestUtil {
    private static HeroNode3 node = new HeroNode3(0, null, null);

    public static void addHeroNode(HeroNode3 heroNode) {
        HeroNode3 temp = node;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    // 单链表的反转
    public HeroNode reverseNode(HeroNode head){
        if (head.next == null){
            return head;
        }
        HeroNode reverseHeroNode = new HeroNode(0, null, null);
        while (head.next != null){
            if (reverseHeroNode.next == null){
                reverseHeroNode.next = head.next;
                head.next = head.next.next;
                reverseHeroNode.next.next = null;
            }else {
                HeroNode temp = reverseHeroNode.next;
                reverseHeroNode.next = head.next;
                head.next = head.next.next;
                reverseHeroNode.next.next = temp;
            }
        }
        head.next = reverseHeroNode.next;
        return head;
    }
    public static void addSortHeroNode(HeroNode3 heroNode) {
        HeroNode3 temp = node;
        boolean flag = false;
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
        if (flag) {
            System.out.println("以重复");
        } else {
            // 插入链表中 temp 中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public static void list() {
        HeroNode3 temp = node.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static int getLength() {
        HeroNode3 temp = node;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("长度：" + count);
        return count;
    }

    public static void updateHeroNode(HeroNode3 heroNode) {
        HeroNode3 temp = node.next;
        while (true) {
            if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickName = heroNode.nickName;
                break;
            }
            temp = temp.next;
        }
    }

    public static void deleteHeroNode(HeroNode3 heroNode) {
        boolean flag = false;
        HeroNode3 temp = node;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 可以删除
            HeroNode3 t = temp.next;
            temp.next = t.next;
            t.next = null;
        } else {
            System.out.println("没有找到节点");
        }
    }
    public static void findNodeStartLast(int length, int key) {
        HeroNode3 temp = node;
        int count = 0;
        while (temp.next != null) {
            if (count== length- key){
                System.out.println(temp.next);
            }
            count++;
            temp = temp.next;
        }
        System.out.println("长度：" + count);
    }
}

class HeroNode3 {

    public int no;
    public String name;
    public String nickName;
    public HeroNode3 next; // 指向下一个节点

    @Override
    public String toString() {
        return "HeroNode3{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public HeroNode3(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }
}