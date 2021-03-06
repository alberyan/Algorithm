package com.yyh;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Implement the following operations of a queue using stacks.
push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
 */
public class MyQueue {
	Deque<Integer> cur;
    /** Initialize your data structure here. */
    public MyQueue() {
        cur = new ArrayDeque<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        cur.offerFirst(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (cur.size() == 1){
            return cur.pollFirst();
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        while (cur.size() > 1){
            tmp.offerFirst(cur.pollFirst());
        }
        int res = cur.pollFirst();
        while (!tmp.isEmpty()){
            cur.offerFirst(tmp.pollFirst());
        }
        return res;
    }
    
    /** Get the front element. */
    public int peek() {
        if (cur.size() == 1){
            return cur.peekFirst();
        }
        Deque<Integer> tmp = new ArrayDeque<>();
        while (cur.size() > 1){
            tmp.offerFirst(cur.pollFirst());
        }
        int res = cur.peekFirst();
        while (!tmp.isEmpty()){
            cur.offerFirst(tmp.pollFirst());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return cur.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */