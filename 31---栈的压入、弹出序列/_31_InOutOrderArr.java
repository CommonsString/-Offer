package jianzhiOffer;

import java.util.Stack;

public class _31_InOutOrderArr {
	
	
	
	public boolean IsPopOrder(int[] pushA, int[] popA){
		//参数检查
		if(pushA.length < 1 || popA.length < 1) return false;
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		for(int i = 0; i < pushA.length; i++){
			stack.push(pushA[i]);
			while(!stack.isEmpty() && popA[popIndex] == stack.peek()){
				//出栈
				stack.pop();
				//弹出序列向后移动一位
				popIndex++;
			}
		}
		return stack.isEmpty();
	}

}
