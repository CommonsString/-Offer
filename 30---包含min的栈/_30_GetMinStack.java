package jianzhiOffer;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 包含min函数的栈
 */
public class _30_GetMinStack {
	
	//正常栈
	private Stack<Integer> order = new Stack<>();
	//最小栈
	private Stack<Integer> min = new Stack<>();
	
	public void push(int node){
		if(!min.isEmpty() && !order.isEmpty()){
			if(node > min.peek()){
				min.push(min.peek());
				order.push(node);
			}else{
				min.push(node);
				order.push(node);
			}
		}else{
			order.push(node);
			min.push(node);
		}
	}
	
	public void pop(){
		if(!order.isEmpty() && !min.isEmpty()){
			order.pop();
			min.pop();
		}
	}
	
	public int min(){
		int temp = 0;
		if(!order.isEmpty() && !min.isEmpty()){
			temp = min.peek();
		}
		return temp;
	}
	
	public static void main(String[] args) {
		_30_GetMinStack base = new _30_GetMinStack();
		base.push(3);
		System.out.println(base.min());
		base.push(4);
		System.out.println(base.min());
		base.push(2);
		System.out.println(base.min());
		base.push(3);
		System.out.println(base.min());
		base.pop();
		System.out.println(base.min());
		base.pop();
		System.out.println(base.min());
		base.pop();
		base.push(0);
		System.out.println(base.min());
	}
	
}
