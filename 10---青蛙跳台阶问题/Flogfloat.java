package jianzhiOffer;
/**
 * @author commonsstring@gmail.com
 * 
 * 
 * 题目 : 青蛙跳台阶
 */
public class Flogfloat {

	/**
	 * 题目 一：一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。求总共有多少总跳法，
	 */
	public int flogFly(int n){
		if(n <= 1) return 1;
		if(n == 2) return 2;
		return flogFly(n - 1) + flogFly(n - 2);
	}

	/**
	 * 题目 二：一个台阶总共有n级，如果一次可以跳1级，也可以跳2级, ....也可以跳n级。求总共有多少总跳法，
	 */
	public int flogFlySecond(int n){
		if(n <= 1) return 1;
		if(n == 2) return 2;
		return (int) Math.pow(2, n - 1);
	}
	
	
	public static void main(String[] args) {
		
		
	}
	
	
}
