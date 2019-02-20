package com.swardoffer;

import java.util.Stack;

public class Question09 {
    /**
     * 用两个栈实现一个队列
     */
    Stack<Integer> stack1 = new Stack<Integer>(); // 用于压入值
    Stack<Integer> stack2 = new Stack<Integer>(); // 用于弹出值

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int val = stack1.pop();
                stack2.push(val);
            }
        }
        return stack2.pop();

    }

}
