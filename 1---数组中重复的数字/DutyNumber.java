package jianzhiOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * 三, 数组中的重复数字
 * 	方法一：蛮力发
 *  方法二：空间换时间
 *  方法三：标准答案
 */
public class DutyNumber {
	
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 1, 0, 2, 5, 3};
		System.out.println(findDutyNumberThreed(arr));
	}
	
	/**
	 * 方法一：蛮力发
	 * 时间复杂度：(N^2 + N*logN)
	 * 思路：
	 * 	排序数组
	 * 	逐一遍历
	 */
	public static int findDutyNumber(int[] arr){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		//题设的参数范围
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 0 || arr[i] > arr.length - 1){
				return -1;
			}
		}
		//数组排序
		Arrays.sort(arr);
		for(int i = 0, len = arr.length; i < len; i++){
			for(int j = 0; j < len; j++){
				if(arr[i] == arr[j] && i != j){
					return arr[i];
				}
			}
		}
		return -1;
	}
	
	
	/**
	 * 方法二：空间换时间
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
	 * 思路：
	 * 	哈希表查找数据的速度, 为O(1)
	 * 	利用哈希表存储数组
	 * 	遍历数组, 看每一项是否在哈希表中
	 * 	存在, 则有重复数字
	 * 	不存在, 存入哈希表
	 */
	@SuppressWarnings("unchecked")
	public static int findDutyNumberSecond(int[] arr){
		if(arr.length < 1 || arr == null) return -1;
		//题设的参数范围
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 0 || arr[i] > arr.length - 1){
				return -1;
			}
		}
		//创建哈希表
		@SuppressWarnings("rawtypes")
		HashMap table = new HashMap();
		int len = arr.length;
		//遍历
		for(int i = 0; i < len; i++){ 
			//containsKey : 存在一个或多个
			if(!table.containsValue(arr[i])){
				table.put(i, arr[i]);
			}else{
				return arr[i];
			}
		}
		return -1;
	}
	
	
	
	/**
	 * 方法三：标准答案
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)
	 * 思路：
	 * 	本人博客：https://blog.csdn.net/qq_37014990/article/details/79824279
	 */
	public static int findDutyNumberThreed(int[] arr){
		if(arr.length < 1 || arr == null) return -1;
		//题设的参数范围
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 0 || arr[i] > arr.length - 1){
				return -1;
			}
		}
		
		for(int i = 0, len = arr.length; i < len; i++){
			while(arr[i] != i){
				//相等, 找出重复数字
				if(arr[i] == arr[arr[i]]){
					return arr[i];
				}
				//不等, 交换两个数
				int temp = arr[i];
				arr[i] = arr[temp];
				arr[temp] = temp;
			}
		}
		return -1;
	}
	
	

}
