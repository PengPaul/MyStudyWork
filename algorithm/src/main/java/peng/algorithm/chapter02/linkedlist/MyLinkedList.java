package peng.algorithm.chapter02.linkedlist;

public class MyLinkedList {
    private static class Node{
        int data;//数据域
        Node next;//下一个节点
    }

    private Node root;
    private int size;

    public MyLinkedList() {
        this.size = 0;
    }

    public MyLinkedList(int rootValue) {
        addNode(rootValue);
    }

    private boolean isEmpty(Node node){
        if (node == null){
            return true;
        }
        return false;
    }

    public void addNode(int value){

    }

    private void addNode(int index,int value){

    }

    public void findNode(int index){

    }

    public void updateNode(int index,int value){

    }
    public void deleteNode(int index){

    }
}
