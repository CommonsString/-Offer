package jianzhiOffer;



/**
 * @author commonsstring@gmail.com
 * 
 * 题目 ： 打印从1到最大的N位数
 */
public class PrintMaxNumber {

	public static void main(String[] args) {
		printC(2);
	}
	/**
	 * 方法一：蛮力法则
	 * 求出N的最大数, 在循环打印
	 */
	public static void printA(int n){
		//参数检查
		if(n == 0){ 
			System.out.println(0);
			return ;
		}
		if(n > 0){
			int[] tempArr = new int[n];
			//初始化
			String max = "";
			for(int i = 0; i < n; i++){ 
				tempArr[i] = 9;
				max += tempArr[i];
			}
			int maxNum = Integer.valueOf(max.trim());
			for(int i = 1; i <= maxNum; i++){
				System.out.print(i + " ");
			}
		}
	}
	
	
	/**
	 * 方法二：蛮力法, 不考虑大数问题.
	 * 不用求, 99XX...直接小于1000XX就可以。
	 * 比如, n = 3, 直接小于1000就可以
	 * 求出N的最大数, 在循环打印
	 */
	public static void printB(int n){
		//参数检查
		if(n < 0) return;
		if(n == 0){
			System.out.print(0);
			return ;
		}
		int maxNum = 1;
		int i = 0;
		while(i++ < n){
			maxNum *= 10; 
		}
		for(int j = 1; j < maxNum; j++){
			System.out.print(j + " ");
		}
	}
	
	
	/**
	 *  方法二：解决大数问题
	 *  思路：在字符串上模拟数字的加法
	 */
	public static void printC(int n){	
		//参数检查
		if(n <= 0) return;
		char[] number = new char[n];
		//初始化number为0
		int i = 0;
		while(i < n){
			number[i] = '0';
			i++;
		}
		while(!increament(number)){
			showNumber(number);
		}
	}
	
	/**
	 * 在number表示的数字上增加一, 
	 * 停止打印条件：
	 * 		在最大的N位数, 99加1后, 最高位产生进位
	 * @param number
	 * @return
	 */
	public static boolean increament(char[] number){
		//参数检查
		int carry = 0; //进位
		boolean isOver = false;
		int len = number.length - 1;
		for(int i = len; i >= 0; i--){
			int nSum = number[i] - '0' + carry;
			if(i == len) nSum++;
			if(nSum >= 10){
				//在最高位进位, 说明已经打印完毕
				if(i == 0){ 
					//设置溢出
					isOver = true;
				}else{ //不是最高位进位
					//取最低位
					nSum -= 10; 
					//进位1
					carry = 1; //高位加一
					number[i] = (char)('0' + nSum);
				}
			}else{
				number[i] = (char)('0' + nSum);
				break;
			}
		}	
		return isOver;
	}
	
	public static void showNumber(char[] number){
		//参数检查
		if(number.length < 1 || number == null) return;
		//标记第一个0
		boolean isFlag = true;
		for(int i = 0, len = number.length; i < len; i++){
			//遇到第一个非空字符的时候, 才打印
			if(isFlag && number[i] != '0'){
				isFlag = false;
			}
			if(!isFlag){
				System.out.print(number[i]);
			}
		}
		System.out.print("");
	}
	
	
}
