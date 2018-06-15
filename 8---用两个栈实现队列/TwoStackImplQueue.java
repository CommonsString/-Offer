package jianzhiOffer;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 两个栈实现队列
 */
class Solution{
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void appendTail(int node) {
    	stack1.push(node);
    }
    
    public int deleteHead() {
    	//stack2不为空, 弹出栈顶元素
    	if(!stack2.isEmpty()){
    		return stack2.pop();
    	}else{ //stack2为空, 把stack1中的元素添加到stack2中
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }	
}
public class TwoStackImplQueue {
	
	public static void main(String[] args) {
		Solution queue = new Solution();
		queue.appendTail(1);
		queue.appendTail(2);
		queue.appendTail(3);
		queue.appendTail(4);
		queue.appendTail(5);
		System.out.println(queue.deleteHead());
		System.out.println(queue.deleteHead());
	}
	
}
