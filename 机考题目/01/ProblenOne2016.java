package zuoye;

import java.util.Arrays;

/**
 * commonsstring@gmail.com
 * 
 * 题目：输入一串用空格隔开的数字串,对于数字串的奇数位按升序排序,偶数位按降序排序.
		示例输入：
		4 6 2 3 6 7 8 1
		处理过程：
		奇数位：4 2 6 8 升序排序结果： 2 4 6 8
		偶数位：6 3 7 1 降序排序结果： 7 6 3 1
		结果输出：2 7 4 6 6 3 8 1
 */
public class ProblenOne2016 {

	
	public static void main(String[] args) {
		
		int[] arr = {4, 6, 2, 3 , 6, 7, 8, 1};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(getSortArr(arr)));
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 方法一：分别在奇数位和偶数位置, 实现冒泡排序
	 * @param arr
	 * @return
	 */
	public static int[] getSortArr(int arr[]){
		if(arr.length < 1 || arr == null) return null;
		//奇数, 升序排序
		for(int i = 0; i < arr.length - 1; i += 2){
			for(int j = i; j < arr.length - 1; j += 2){
				if(arr[i] < arr[j]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		//偶数, 升序排序
		for(int i = 1; i < arr.length - 1; i += 2){
			for(int j = i; j < arr.length - 1; j += 2){
				if(arr[i] > arr[j]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}	
		}
		return arr;
	}
	
}
