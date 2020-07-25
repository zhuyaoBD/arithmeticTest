package com.yao.leetcode;

import java.util.HashMap;

/**
 * @author Daniel:)
 * 复制随机指针的链表
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 null 。
 *
 */
public class Main138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node currentNode = head;
        while (currentNode != null) {
            map.put(currentNode, new Node(currentNode.val));
            currentNode = currentNode.next;
        }
        currentNode = head;
        while (currentNode != null) {
            map.get(currentNode).next = map.get(currentNode.next);
            map.get(currentNode).random = map.get(currentNode.random);
            currentNode = currentNode.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
