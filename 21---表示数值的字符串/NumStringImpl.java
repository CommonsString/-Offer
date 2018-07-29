package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 
 * 题目 : 表示数组的字符串
 */
public class NumStringImpl {

	
	public static void main(String[] args) {
		char[] str = {'1', '2', '3'};
		System.out.println(isNumeric(str));
	}
	
	/**
	 * 方法一：标准答案
	 */
	 //全局
	 static int index = 0;
	 public static boolean isNumeric(char[] str){
		 //参数检查
		 if(str.length < 1 || str == null) return false;
		 //以+|-开头
		 boolean isPositive = scanInteger(str);
		 int len = str.length;
		 //小数部分
		 if(index < len && str[index] == '.'){
			 index++;
			 isPositive = scanUnsingedInteger(str) || isPositive;
		 }
		 //指数部分
		 if(index < len && (str[index] == 'e' || str[index] == 'E')){
			 index++;
			 isPositive = scanInteger(str) && isPositive;
		 }
		 return isPositive && index == str.length;
	 }
	 
	 /**
	  * 扫描以+|-开头的字符, +123.XX
	  * @param str
	  * @return
	  */
	 public static boolean scanInteger(char[] str){
		 int len = str.length;
		 if(index < len && (str[index] == '+' || str[index] == '-')){
			 index++;
		 }
		 return scanUnsingedInteger(str);
	 }
	 /**
	  * 扫描数字0~9之内的字符串
	  * @param str
	  * @return
	  */
	 public static boolean scanUnsingedInteger(char[] str){
		 int len = str.length;
		 int start = index;
		 while(index < len && str[index] >= '0' && str[index] <= '9'){
			 index++;
		 }
		 return index > start; //存在整数
	 }
	 
	 
	
	
}
