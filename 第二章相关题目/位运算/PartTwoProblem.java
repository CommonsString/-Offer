package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 第二章相关题目, 位运算部分
 * 
 */
public class PartTwoProblem {
	
	public static void main(String[] args) {
		System.out.println(getResult(8, 3));
	}
	
	/**
	 * 用一条语句, 判断一个整数是不是2的整数次方
	 * @return
	 */
	public static boolean judeVersionA(int n){
		if(n <= 0) return false;
		boolean flag = false;
		if(n % 2 == 0) flag = true;
		return flag;
	}
	
	/**
	 * 用一条语句, 判断一个整数是不是2的整数次方
	 * 位运算：
	 * 	如果是2的整数倍, 即二进制表示中一定有且只有一个1
	 * @return
	 */
	public static boolean judeVersionB(int n){
		if(n <= 0) return false;
		int count = 0;
		while(n != 0){
			count++;
			n = n & (n - 1);
		}
		//有且只有一个1
		if(count == 1) return true;
		return false;
	}
	
	
	/**
	 * 问题二：
	 * 输入两个整数m, n, 输出整数m需要调整几位才能变成m
	 * 先异或, 在统计异或中的1的个数
	 */
	public static int getResult(int m, int n){
		int count = 0;
		int result = m ^ n;
		while(result != 0){
			count++;
			result = result & (result - 1);
		}
		return count;
	}
	
	
	
}
