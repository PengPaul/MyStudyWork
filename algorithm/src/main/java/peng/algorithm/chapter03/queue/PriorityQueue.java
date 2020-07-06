package peng.algorithm.chapter03.queue;

import java.util.Arrays;

/**
 * 优先队列
 *  最大优先队列
 *      无论顺序如何，都是当前最大的元素优先出队
 *  最小优先队列
 *      无论顺序如何，都是当前最小的元素优先出队
 *
 *  （二叉堆最大或最小的在堆顶）
 *
 */
public class PriorityQueue {
    private int[] array;
    private  int size;
    public PriorityQueue(){
        array = new int[32];
    }

    public void enQueue(int key){
        if (size >= array.length){
            resize();//扩容
        }
        array[size++] = key;
        upAdjust();
    }

    public int deQueue() throws Exception{
        if (size <= 0){
            throw  new Exception("queue is null");
        }
        int head = array[0];
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    private void resize(){
        int newSize = this.size*2;
        this.array = Arrays.copyOf(this.array,newSize);
    }

    /**
     * 上浮
     */
    private void upAdjust(){
        int childIndex = size - 1;
        int parentIndex = (childIndex-1)/2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]){
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex =  childIndex/2;
        }
        array[childIndex] = temp;
    }

    private void downAdjust(){
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size){
            if (childIndex + 1 < size && array[childIndex+1]>array[childIndex]){
                childIndex ++;
            }
            if (temp >= array[childIndex]){
                break;
            }
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2+1;
        }
        array[parentIndex] = temp;
    }
}
