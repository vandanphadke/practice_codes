package stacks;

import java.util.Stack;

public class MinStack {

    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack(){
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int element){
        this.mainStack.push(element);
        if (!minStack.isEmpty())
            this.minStack.push(Math.min(element, minStack.peek()));
        else
            this.minStack.push(element);
    }

    public int pop(){
        if (!mainStack.isEmpty()){
            this.minStack.pop();
            return this.mainStack.pop();
        }
        else
            return -1;

    }

    public int top(){
        if (mainStack.isEmpty())
            return -1;

        return this.mainStack.peek();
    }

    public int getMin(){
        if (mainStack.isEmpty())
            return -1;

        return this.minStack.peek();
    }

}
