package zuoye;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * 题目：
	按要求分解字符串，输入两个数M，N；M代表输入的M串字符串，N代表输出的每串字符串的位数，不够补0。
	例如：输入2,8， “abc” ，“123456789”.
	则输出为“abc00000”,“12345678“,”90000000”
 *
 */
public class ProblemThree2016 {
	
	/**
	 * 自己的方法, 未完成
	 * https://www.cnblogs.com/wangjiangwu/p/5830018.html
	 */
	@SuppressWarnings("resource")
	static void testOne(){
			int M, N;
			Scanner in = new Scanner(System.in);
			//串数
			M = in.nextInt();
			//输出位数
			N = in.nextInt();
			//参数检查
			if(M < 0 || N < 0) return ;
			ArrayList<StringBuffer> strArr = new ArrayList<>();
			for(int i = 0; i < M; i++){
				if(in.hasNext()){
					String inStr = in.next();
					strArr.add(new StringBuffer(inStr));
				}
			}
			//处理
			ArrayList<StringBuffer> result = new ArrayList<>();
			for(StringBuffer item : strArr){
				int len = item.length();
				//长度 < 输出范围
				if(len < N){
					int newLen = N;
					//扩充长度
					item.setLength(newLen);
					//填充0
					for(int i = len; i <= newLen - 1; i++){
						item.setCharAt(i, '0');
					}
					result.add(item);
				}else if(len == N){
					result.add(item);
				}else{
					//字符串分解
					int couple = len / N; 
					int last = len % N;
					for(int i = 0; i < couple; i++){
						StringBuffer tempBuffer = new StringBuffer(item.subSequence(N * i, N * (i + 1)));
						result.add(tempBuffer);
					}
					//处理尾数
					if(last != 0){
						int start = len - last;
						StringBuffer temp = new StringBuffer();
						temp = new StringBuffer(item.substring(start, len));
						//扩容
						temp.setLength(N);
						//填充0
						for(int i = last; i < N; i++){
							temp.setCharAt(i, '0');
						}
						result.add(temp);
					}
				}
			}	
			//打印字符串
			for(StringBuffer show : result){
				System.out.print(show.toString() + " ");
			}
	}
	
	
	public static void main(String[] args) {
		testOne();
	}

}
