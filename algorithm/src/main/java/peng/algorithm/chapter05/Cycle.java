package peng.algorithm.chapter05;

/**
 * 判断一个链表是否有环
 */
public class Cycle {
    private static class Node {
        int data;//数据域
        Node next;//下一个节点

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isCycle(Node head) {
        Node p1 = head;
        Node p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                return true;
            }
        }
        return false;
    }



}
