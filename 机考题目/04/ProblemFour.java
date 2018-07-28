package zuoye;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
第一题：拼音转数字
输入是一个只包含拼音的字符串，请输出对应的数字序列。转换关系如下：
描述: 拼音 yi  er  san  si  wu  liu  qi  ba  jiu
       阿拉伯数字 1  2  3  4  5  6  7  8  9
输入字符只包含小写字母，所有字符都可以正好匹配
运行时间限制：无限制
内存限制：      无限制
输入：             一行字符串，长度小于1000
输出：             一行字符（数字）串
样例输入：       yiersansi
样例输出：       1234
 *
 */
public class ProblemFour {
	
	
	@SuppressWarnings("resource")
	public static void changeNumber(){
		Scanner in = new Scanner(System.in);
		StringBuilder str = null;
		while(true){
			if(in.hasNext()){
				str = new StringBuilder(in.next());
			}
			if(str.length() > 1000) return ;
			//创建HashMap
			HashMap<String, Integer> map = menset();
			ArrayList<Integer> result = new ArrayList<>();
			String work = "";
			for(int i = 0; i < str.length(); i++){
				work += str.charAt(i);
				//存在
				if(map.containsKey(work)){
//				System.out.println(work);
					result.add(map.get(work));
					work = "";
				}
			}
			for(Integer value : result){
				System.out.print(value);
			}
			System.out.println();
		}
	}
	
	public static HashMap<String, Integer> menset(){
		HashMap<String, Integer> map = new HashMap<>();
		map.put("yi", 1); map.put("liu", 6);
		map.put("er", 2); map.put("qi", 7);
		map.put("san", 3); map.put("ba", 8);
		map.put("si", 4); map.put("jiu", 9);
		map.put("wu", 5); 
		return map;
	}
	
	public static void main(String[] args) {
		changeNumber();
	}
}
