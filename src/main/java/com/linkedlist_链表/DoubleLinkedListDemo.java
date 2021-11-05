package com.linkedlist_链表;

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
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的一个测试");
        // 先创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 heroNode2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "林冲", "豹子头");

        //创建一个双向链表对象
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);

        doubleLinkedList.list();

        // 修改测试
        System.out.println();
        System.out.println("修改测试");
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "如云龙");
        doubleLinkedList.update(newHeroNode);
        doubleLinkedList.list();

        // 测试删除
        System.out.println("删除测试");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();

        // 有序添加测试
        System.out.println();
        System.out.println("有序添加测试");
        HeroNode2 newHeroNode2 = new HeroNode2(0, "小工", "公公");
        doubleLinkedList.addOrder(newHeroNode2);
        doubleLinkedList.list();
    }
}

// 创建一个双向链表的类
class DoubleLinkedList {
    // 初始化一下头结点  头结点不要动 不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, null, null);

    public HeroNode2 getHead() {
        return head;
    }

    public void setHead(HeroNode2 head) {
        this.head = head;
    }

    // 遍历双向链表的方法和单链表的方法一样
    // 显示链表 遍历
    public void list() {
        // 判断链表为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头结点不能动我们需要一个复制节点 temp
        HeroNode2 temp = head.next;
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

    // 这个方法默认添加到双向链表的尾部
    public void add(HeroNode2 heroNode) {
        // 因为 head节点不能动 我们需要一个辅助节点 temp
        HeroNode2 temp = head;
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
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 按顺序添加双链表
    void addOrder(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        boolean flag = false; // 标识是否可以插入
        if (head.next == null) {
            heroNode.pre = head;
            head.next = heroNode;
        } else {
            while (true) {
                if (temp.no == heroNode.no) {
                    System.out.println("该编号已经存在 无法添加");
                    flag = true;
                    break;
                } else if (temp.no > heroNode.no) {
                    break;
                }
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            if (!flag) {
                heroNode.next = temp;
                heroNode.pre = temp.pre;
                temp.pre.next = heroNode;
                temp.pre = heroNode;
            }
        }

    }

    // 修改一个双向链表的接单的内容  和单向链表一样 只是节点的类型发生了改变
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点 很具no查询
        HeroNode2 temp = head.next;
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

    // 从双向链表中删除一个节点
    // 对于双向链表可以直接找到要删除的节点 不用像单链表要找到要删除节点的前一个节点
    // 找到后 自我删除即可
    public void delete(int no) {
        HeroNode2 temp = head.next;
        // 判断当前链表是否为空
        if (temp == null) {
            System.out.println("当前链表为空 无法删除");
        }
        boolean flag = false; // 标志是否找到待删除节点的
        while (true) {
            if (temp.no == no) {
                // 找到了待删除节点的前一个节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 可以删除
            // temp.next = temp.next.next; [单链表]
            temp.pre.next = temp.next;
            if (temp.next != null) {
                //  如果删除的不是最后一个节点
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("没有找到该no=[" + no + "]节点,无法删除");
        }
    }

}


// 定义一个HeroNode , 每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next; // 指向下一个节点 ,默认为null
    public HeroNode2 pre; // 指向上一个节点 ,默认为null

    // 构造器
    public HeroNode2(int hNo, String hName, String hNickName) {
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
}