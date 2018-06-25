package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 相关题目：
 * 用两个队列实现栈
 */

class CStack{
	
	private int size = 0; //当前入栈数
	private int capatity; //总容量
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	
	public CStack(int capatity) {
		//初始化, 容量为10
		this.capatity = capatity;
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();		
	}

	public CStack() {
		//初始化, 容量为10
		this.capatity = 10;
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}
	
	//入栈
	public void push(int data){
		//栈满, 无法入栈
		if(isStackFull()){
			System.out.println("栈满, 无法入栈！");
			return ;
		}else{
			//q1为空, 数据入q1
			if(!queue1.isEmpty()){
				queue1.add(data);
				size++;
			}else{
				queue1.add(data);
				size++;
			}
		}
	}
	
	//出栈
	public int pop(){
		//结果
		int result = 0;
		//栈空, 无法出栈
		if(isEmpty()){
			System.out.println("栈空, 无法出栈！");
			return -1;
		}else{
			//q1为空, 默认q2不为空
			if(queue1.isEmpty() && !queue2.isEmpty()){
				for(int i = 1; i < size; i++){
					//q2加入q1内
					queue1.add(queue2.remove());
					size--;
				}
				result = queue2.remove();
				size--;
			}else{
				for(int i = 1; i < size; i++){
					//q1加入q2内
					queue2.add(queue1.remove());
					size--;
				}
				if(size <= 0){
					System.out.println("");
				}
				result = queue1.remove();
				size--;
			}
		}
		return result;
	}
	
	//判空
	public boolean isEmpty(){
		if(size <= capatity && size >= 0) return false;
		return true;
	}
	
	//判满栈
	public boolean isStackFull(){
		if(size <= capatity) return false;
		return true;
	}
	
}
public class TwoQueueImplStack {
	
	
	public static void main(String[] args) {
		CStack myStack = new CStack();
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
	}
	
	
	
	
	
}
