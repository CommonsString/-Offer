package jianzhiOffer;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 两个栈实现队列
 * 第二种方法
 */
class MQueue{
	//入栈, 进mypush
	private Stack<Integer> myPush;
	//出栈, 从mypop中出
	private Stack<Integer> myPop;
	
	
	public MQueue() {
		this.myPush = new Stack<Integer>();
		this.myPop = new Stack<Integer>();
	}

	//入队
	public void push(int data){
		myPush.push(data);
	}
	
	//出队
	public int poll(){
		if(myPush.isEmpty() && myPop.isEmpty()){
			throw new RuntimeException("队空, 无法出队！");
		}else if(myPop.isEmpty()){
			//myPop为空, 将myPush中的数据全部倒入myPop
			while(!myPush.isEmpty()){
				myPop.push(myPush.pop());
			}
		}
		return myPop.pop();
	}
	
	//弹出队头
	public int peek(){
		if(myPush.isEmpty() && myPop.isEmpty()){
			throw new RuntimeException("队空, 无法出队！");
		}else if(myPop.isEmpty()){
			while(!myPush.isEmpty()){
				myPop.push(myPush.pop());
			}
		}
		return myPop.peek();
	}
	
}


public class TwoStackImplQueueSecond {
	public static void main(String[] args) {
		MQueue queue = new MQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
