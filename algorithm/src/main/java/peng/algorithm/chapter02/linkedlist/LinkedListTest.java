package peng.algorithm.chapter02.linkedlist;

public class LinkedListTest {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addNode(0,1);
        myLinkedList.outprintln();
        myLinkedList.addNode(2);
        myLinkedList.outprintln();
        myLinkedList.addNode(3);
        myLinkedList.outprintln();
        myLinkedList.addNode(1,4);
        myLinkedList.outprintln();
        myLinkedList.addNode(1,5);
        myLinkedList.outprintln();
        myLinkedList.addNode(1,6);
        myLinkedList.outprintln();
        myLinkedList.addNode(0,7);
        myLinkedList.outprintln();
        myLinkedList.addNode(7,8);
        myLinkedList.outprintln();
        myLinkedList.deleteNode(2);
        myLinkedList.outprintln();
        myLinkedList.deleteNode(0);
        myLinkedList.outprintln();
        myLinkedList.deleteNode(5);
        myLinkedList.outprintln();
    }
}
