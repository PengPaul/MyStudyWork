package peng.algorithm.chapter05;

import java.util.Stack;

/**
 * 最小栈的实现
 */
public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int element){
        mainStack.push(element);
        if (minStack.empty() ||element<=minStack.peek()){
            minStack.push(element);
        }
    }

    public Integer pop(){
        if (mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception{
        if (minStack.empty()){
            throw new Exception("stack is null");
        }
        return minStack.peek();
    }


}
