package jianzhiOffer;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 正则表达式匹配
 */
public class ZhengZeBiaoDa {
	
	
	public static void main(String[] args) {
		char[] str = {'a', 'a', 'a'};
		char[] pat = {'a', '.', 'a'};
		System.out.println(match(str, pat));
	}
	
	
	
	
	/**
	 * 方法二：递归思想
	 * 
	 */
	public static boolean match(char[] str, char[] pattern){
		if(str == null || pattern == null){
			return false;
		}
		return match(str, 0, pattern, 0);
	}
	public static boolean match(char[] str, int startStr, char[] pattern, int startPat){
		//到尾, 匹配成功
		if(startStr == str.length && startPat == pattern.length){
			return true;
		}
		//模式先用尽
		if(startStr != str.length && startPat == pattern.length){
			return false;
		}
		//模式第二个字符是‘*’
		if(startPat + 1 < pattern.length && pattern[startPat + 1] == '*'){
			if(startStr != str.length && str[startStr] == pattern[startPat] 
					|| startStr != str.length && pattern[startPat] == '.'){
				//三种情况
				return match(str, startStr, pattern, startPat + 2) //模式向后移动两位 
						//字符串移动一位, 模式移动两位或者不变
						|| match(str, startStr + 1, pattern, startPat + 2)
						|| match(str, startStr + 1, pattern, startPat);
			}else{
				return match(str, startStr, pattern, startPat + 2);
			}
		}
		//模式第二个字符不是‘*’
		//第一个字符相等, 都向后移动一个字符
		if(startStr != str.length && str[startStr] == pattern[startPat]
				|| startStr != str.length && pattern[startPat] == '.'){	
			return match(str, startStr + 1, pattern, startPat + 1);
		}
		return false;
	}
	
	/**
	 * https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
	 * 方法一：利用两个工作栈, 字符串栈, 模式栈,从后往前匹配
	 * 	思路：
	 * 		1, 栈顶字符与栈顶模式字符---相等, 双双弹出。不等, 无法匹配。
	 * 		2, 如果模式栈顶是‘.’, 将‘.’出栈，并将字符栈顶压入模式栈顶。
	 * 		3, 模式栈顶为‘*’, 模式栈出栈, 再比较字符栈顶与模式栈顶。
	 * 		4, 	相等：将字符栈顶弹出，并入模式栈顶
	 * 		5,  不等, 模式栈顶弹出，并继续。
	 */
	public boolean match2(char[] str, char[] pattern){
        // .* 匹配一切
        if(pattern.length == 2
                && pattern[0] == '.'
                && pattern[1] == '*') return true;
 
        // 两个序列入栈
        Stack<Character> ori = new Stack<>();
        Stack<Character> pat = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            ori.push(str[i]);
        }
        for (int i = 0; i < pattern.length; i++) {
            pat.push(pattern[i]);
        }
 
        // 从尾匹配，解决*重复前一个字符的问题
        while (!ori.empty() && !pat.empty()){
            // 如果是两个不相同的字母，匹配失败
            if(Character.isLetter(pat.peek())
                    && !pat.peek().equals(ori.peek()))
                return false;
            // 两个相同的字母，匹配成功，两个栈顶各弹出已经匹配的字符
            if(Character.isLetter(pat.peek())
                    && pat.peek().equals(ori.peek())){
                ori.pop();
                pat.pop();
            }else if(pat.peek().equals('.')){ // 如果模式串是 ‘.’，直接把它替换为所需的字符入栈
                pat.pop();
                pat.push(ori.peek());
            }else{ // 模式串是 *
                pat.pop();
                if(pat.peek().equals(ori.peek())){ // *的下一个是目标字符，则重复它再重新压入*
                    pat.push(ori.peek());
                    pat.push('*');
                    ori.pop();
                }else{ // 否则从模式栈弹栈，直到找到匹配目标串的字符，或遇到.
                    while (!pat.empty()
                            && !pat.peek().equals(ori.peek())
                            && !pat.peek().equals('.')) pat.pop();
                    // 如果遇到了‘.’ 直接替换为目标字符，再重新压入*
                    if(!pat.empty() && pat.peek() == '.'){
                        pat.pop();
                        pat.push(ori.peek());
                        pat.push('*');
                    }
                }
            }
        }
        // 两栈空，则匹配成功
        if(ori.empty() && pat.empty()) return true;
        // 如果模式栈不空
        // 仅当模式栈中的*可以‘吃掉’多余的字符时匹配成功
        // 例如 aa* / aa*bb* ,而不可以是baa*
        if(ori.empty() && !pat.empty()
                && pat.peek().equals('*')){
            char c = pat.pop();
            while (!pat.empty()){
                if(c == '*'
                        || pat.peek() == '*'
                        || c == pat.peek())
                    c = pat.pop();
                else return false;
            }
            return true;
        }
        // 其他情况均不成功
        return false;
    }
	
	
}
