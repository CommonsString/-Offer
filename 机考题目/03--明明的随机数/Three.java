package niukeHuawei;

import java.util.Arrays;
import java.util.Scanner;

public class Three {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int N = in.nextInt();
			//创建数组
			int[] arr = new int[N];
			for(int i = 0; i < N; i++){
				arr[i] = in.nextInt();
			}
			//排序
			Arrays.sort(arr);
			//去除重复
			System.out.println(arr[0]);
			for(int i = 1; i < N; i++){
				if(arr[i] != arr[i - 1]){
					System.out.println(arr[i]);
				}
			}
		}
	}
	
}
