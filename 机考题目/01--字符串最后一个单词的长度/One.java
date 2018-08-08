package niukeHuawei;

import java.util.Scanner;

/**
题目描述
计算字符串最后一个单词的长度，单词以空格隔开。 
输入描述:
一行字符串，非空，长度小于5000。
输出描述:
整数N，最后一个单词的长度。
 *
 */
public class One {
	
	/**
	 * 先读取字符串，然后计算字符串长度，，最后用字符串长度减一再减空格的位置即可得到。
	 * @param args
	 */
	@SuppressWarnings("resource")
	public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			String s = "";
			while(in.hasNextLine()){
				s = in.nextLine();
				//参数检查
				if(s == null || s.length() > 5000) break ;
				//减去最后一个空格
				//再找出倒数第一个空格的位置(剩余的就是最后字符串的长度)
				System.out.println(s.length() - 1 - s.lastIndexOf(" "));
			}
	}
}
