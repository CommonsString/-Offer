package jianzhiOffer;

/**
 * @author commonsstring@gmail.com
 * 
 * 
 * 题目 : 斐波那契额数列, 求第N向的值
 */
public class Fibonacci {

	
	//递归实现
	public static int fibonacci(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	//非递归实现
	public static int fibonacci2(int n){
		int s1 = 1, s2 = 1;
		for(int i = 2; i < n; i++){
			s2 = s1 + s2;
			s1 = s2 - s1;
		}
		return s2;
	}
	
	//时间复杂度为O(logN)
	public static int fibonacci3(int n){
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci2(5));
	}
	
	
}
