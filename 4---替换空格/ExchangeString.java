package jianzhiOffer;

import java.util.Scanner;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 替换空格
 * 方法一：蛮力法
 * 方法二：从后往前替换法
 */
public class ExchangeString {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println("输入前：" + str);
		System.out.println("正确：" + exchangeStrFirst(new StringBuffer(str)));
		System.out.println("测试：" + exchangeStrSecond(new StringBuffer(str)));
	}
	
	/**
	 * 方法一: 蛮力法
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
	 * 思路：
	 *  声明一个可变字符串。
	 *  输入一个字符串, 逐一遍历每个字符
	 *  如果遇到空格, 填充%20
	 *  否则继续遍历。
	 */
	public static String exchangeStrFirst(StringBuffer param){
		//参数检查
		if(param == null|| param.length() < 1) return null;
		//临时字符串
		StringBuffer tempStr = new StringBuffer();
		for(int i = 0; i < param.length(); i++){
			//遇到空格加入特殊字符%20
			if(param.charAt(i) == ' '){
				tempStr.append("%20");
			}else{
				tempStr.append(param.charAt(i));
			}
		}
		return tempStr.toString();
	}

	/**
	 * 方法二: 从后往前
	 * 思路：
	 *  统计空格的出现的次数, 计算填充字符的长度, 扩大原来数组
	 *  声明两个头尾指针。
	 *  头指针向前移动
	 *  如果没有遇到空格：
	 *  	将头指针的值复制到尾指针的位置(交换两个数)
	 *      头指针--(自减操作)
	 *      尾指针--
	 *  否则, 即遇到空格：
	 *      尾指针向前依次填充字符%20
	 *      头指针--(自减操作)
	 *      尾指针--
	 *  当头指针 == 尾指针：
	 *      返回数组
	 */
	public static String exchangeStrSecond(StringBuffer param){
		//参数检查
		if(param == null|| param.length() < 1) return null;
		//空格的数目
		int spaceCount = 0;
		for(int i = 0; i < param.length(); i++){
			if(param.charAt(i) == ' '){
				spaceCount++;
			}
		}
		//数组原长度
		int oldLen = param.length();
		//数组新长度 , spaceCount * 2 : 填充字符的长度
		int newLen = oldLen + spaceCount * 2;
		//将数组声明为统计空格后的长度
		param.setLength(newLen);
		//头指针：指向旧数组的末尾
		int pxFirst = oldLen - 1;
		//尾指针：指向新数组的末尾
		int pxSecond = newLen - 1;
		while(pxSecond >= pxFirst && pxFirst >=0 && pxSecond >= 0){
			if(pxSecond == pxFirst) return param.toString();
			//头指针 == 空格
			if(param.charAt(pxFirst) == ' '){
				//填充字符的长度
				param.setCharAt(pxSecond, '0');
				param.setCharAt(--pxSecond, '2');
				param.setCharAt(--pxSecond, '%');
				pxFirst--;
				pxSecond--;
			}else{
				//将头指针的值复制到尾指针的位置上
				char temp = param.charAt(pxFirst);
				param.setCharAt(pxFirst, param.charAt(pxSecond));
				param.setCharAt(pxSecond, temp);
				pxFirst--;
				pxSecond--;
			}
		}
		return param.toString();
	}
	
	
	
	
	
	
	
}
