package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 二进制数中的1的个数
 */
public class BitOperation {

	
	public static void main(String[] args) {
		System.out.println(operationVersionC(15));
	}
	
	/**
	 * 方法一 ：将输入数字与数字1按位与, 看是否等于0
	 * 缺点：当n位负数的时候, 陷入死循环
	 */
	public static int operationVersionA(int n){
		int count = 0;
		while(n != 0){
			if((n & 1) != 0){
				count++;
			}
			n = n >> 1;
		}
		return count;
	}
	
	
	/**
	 * 方法二 ： 输入数字不动, 将1左移
	 * 缺点: 几位二进制数, 就循环几次
	 * @param n
	 * @return
	 */
	public static int operationVersionB(int n){
		int count = 0;
		int flag = 1;
		while(flag != 0){
			if((n & flag) != 0){
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}
	
	/**
	 * 方法三 ： 输入数字不动, 将1左移
	 * @param n
	 * @return
	 */
	public static int operationVersionC(int n){
		int count = 0;
		while(n != 0){
			count++;
			n = n & (n - 1);
		}
		return count;
	}
	
	
}
