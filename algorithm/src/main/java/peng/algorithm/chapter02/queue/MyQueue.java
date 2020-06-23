package peng.algorithm.chapter02.queue;

public class MyQueue {
    private int[] array;
    private int front;//队头
    private int rear;//队尾(永远是空)

    public MyQueue(int capacity) {
        array = new int[capacity];
    }

    /**
     * 入队
     * @param element
     * @throws Exception
     */
    public void enquene(int element) throws Exception{
        if ((rear + 1)% array.length == front){//队列满了
            throw new Exception("over queue size");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    /**
     * 出队
     * @return
     * @throws Exception
     */
    public int dequeue() throws Exception{
        if (rear == front){
            throw new Exception("queue is null");
        }
        int dequeue  = array[front];
        front = (front+1)%array.length;
        return dequeue;
    }

    public void outPrint(){
        for (int i = front;i != rear;i =(i + 1) % array.length){
            System.out.print(" "+array[i]);
        }
        System.out.println("===================");
    }
}
