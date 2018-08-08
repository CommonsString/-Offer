package niukeHuawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Administrator
 *
 */
public class Two {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = "";
		String target = "";
		while(in.hasNext()){
			s = in.next();
			target = in.next();
			StringBuilder temp = new StringBuilder(s);
			ArrayList<Character> list = new ArrayList<>();
			//存储
			for(int i = 0, len = temp.length(); i < len; i++){
				list.add(temp.charAt(i));
			}
			int count = 0;
			for(int i = 0, len = list.size(); i < len; i++){
				char ch = list.get(i);
				if(String.valueOf(ch).equalsIgnoreCase(target)){
					count++;
				}
			}
			System.out.println(count);
		}
	}
	
}
