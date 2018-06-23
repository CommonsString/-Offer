package nuiKe;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
        回栈中最小元素的操作。
 */

class myStack{
	//正常的栈
	private Stack<Integer> data;
	//存放最小值
	private Stack<Integer> min;

	
	
	public myStack() {
		this.data = new Stack<Integer>();
		this.min = new Stack<Integer>();
	}

	//入栈
	public void push(int value){
		if(data.isEmpty() && min.isEmpty()){
			data.push(value);
			min.push(value);
		}else{
			//当前值 < min的栈顶, 将当前值入min栈
			if(value <= min.peek()){
				min.push(value);
				data.push(value);
			}else{
				min.push(min.peek());
				data.push(value);
			}
		}
	}
	
	//获取最小值
	public int getMin(){
		return min.peek();
	}
	
	//出栈
	public int pop(){
		if(data.isEmpty()){
			throw new RuntimeException("栈空, 无法出栈！");
		}
		min.pop();
		return data.pop();
	}
}
public class especiallyStack {
	
	public static void main(String[] args) {
		myStack stack = new myStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.getMin());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
	
}
