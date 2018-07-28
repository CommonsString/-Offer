package zuoye;

import java.util.ArrayList;
import java.util.Scanner;

/**
 
 	去除重复字符并排序
	运行时间限制：无限制
	内容限制：      无限制
	输入：            字符串
	输出：            去除重复字符并排序的字符串
	样例输入：      aabcdefff
	样例输出：      abcdef
	#include<stdio.h

 *
 */
public class ProblemSix {
	
	public static void methodSave(){
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		StringBuilder str = null;
		while(true){
			if(in.hasNext()){
				str = new StringBuilder(in.next());
			}
			int current = 0;
			int next = current + 1;
			//结果集
			ArrayList<Character> result = new ArrayList<>();
			while(current < str.length() && next < str.length()){
				//前后两个相等, 存在重复
				if(str.charAt(current) == str.charAt(next)){
					Character val = str.charAt(current);
					result.add(val);
					while(current < str.length() && val == str.charAt(current)){
						current++;
					}
					//解决aab, b没有的情况
					if(current == str.length() - 1){
						result.add(str.charAt(current));
					}
				}else{
					result.add(str.charAt(current++));
					
				}
				next = current + 1;
			}
			for(char value : result){
				System.out.print(value);
			}
		}
	}
	
	public static void main(String[] args) {
		methodSave();
	}

}
