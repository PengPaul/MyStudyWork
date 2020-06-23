package peng.algorithm.chapter02.linkedlist;

/**
 * 单链表
 */
public class MyLinkedList {
    private static class Node {
        int data;//数据域
        Node next;//下一个节点
        Node(int data){
            this.data = data;
        }
    }
   //头节点
    private Node head;
    //尾节点
    private Node last;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public MyLinkedList(int rootValue) {
        addNode(rootValue);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < this.size;
    }

    /**
     * 检查index是否超出大小
     *
     * @param index
     */
    private void checkElementIndex(int index) {
        if (!this.isElementIndex(index)) {
            throw new IndexOutOfBoundsException("over index");
        }
    }

    /**
     * 插入节点 三种情况
     * 尾部插入/头部插入/中间插入
     *
     * @param value
     */
    public void addNode(int value) {
        Node node = new Node(value);
        node.next = null;
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addNode(int index, int value) {
        if (index < 0||index>size){
            throw new IndexOutOfBoundsException("over index");
        }
        Node node = new Node(value);
        if (size == 0){
            head = node;
            last = node;
        }else if (index == 0) {//头部插入
            node.next = head;
            head = node;
        } else if (index >= size) {//尾部插入
            last.next = node;
            last = node;
        } else {//中间插入
            Node preNode = findNode(index - 1);
            node.next = preNode.next;
            preNode.next = node;
        }
        size++;
    }

    public int findNodeData(int index) {
        checkElementIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    private Node findNode(int index) {
        checkElementIndex(index);
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void updateNode(int index, int value) {
        Node node = findNode(index);
        node.data = value;
    }

    /**
     * 删除节点 三种情况
     * 删除头/删除尾/删除中间
     *
     * @param index
     */
    public Node deleteNode(int index) {
        checkElementIndex(index);
        Node deleteNode = null;
        if (index == 0) {//删除头
            if (head == last) {
                last = null;
            }
            deleteNode = head;
            head = head.next;
        } else if (index == (size - 1)) {//删除尾
            Node node = findNode(index - 1);
            deleteNode = node.next;
            node.next = null;
            last = node;
        } else {
            Node preNode = findNode(index - 1);
            deleteNode = preNode.next;
            preNode.next = preNode.next.next;
        }
        size--;
        return deleteNode;
    }

    public void outprintln(){
        Node temp = head;
        while (temp != null){
            System.out.print(" "+temp.data);
            temp  = temp.next;
        }
        System.out.println("===============size:"+size);
    }
}
