package peng.algorithm.chapter02.queue;

public class TestQueue {
    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(10);
        myQueue.enquene(1);
        myQueue.outPrint();
        myQueue.enquene(2);
        myQueue.outPrint();
        myQueue.enquene(3);
        myQueue.outPrint();
        myQueue.enquene(4);
        myQueue.outPrint();
        myQueue.enquene(5);
        myQueue.outPrint();
        myQueue.enquene(6);
        myQueue.outPrint();
        myQueue.dequeue();
        myQueue.outPrint();
        myQueue.dequeue();
        myQueue.outPrint();
        myQueue.enquene(7);
        myQueue.outPrint();
        myQueue.enquene(8);
        myQueue.outPrint();
        myQueue.dequeue();
        myQueue.outPrint();
        myQueue.dequeue();
        myQueue.outPrint();
    }
}
