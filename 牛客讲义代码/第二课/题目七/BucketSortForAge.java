package jianzhiOffer;

import java.util.Arrays;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 实现一个算法, 时间复杂度为O(N), 对员工年龄进行排序。
 */
public class BucketSortForAge {

	
	public static void main(String[] args) {
		int[] arr = {4, 5, 1, 2, 5, 7, 2, 9};
		bucketSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 可以使用辅助数组
	 * 桶排序
	 * 时间复杂度：O(N)
	 */
	public static void bucketSort(int[] arr){
		//参数检查
		if(arr == null || arr.length < 2) return ;
		//年龄范围
		int len = arr.length;
		//年龄范围
		final int ageAtOld = 99;
		//N + 1的桶, 初值为0
		int[] tempArr = new int[ageAtOld + 1];
		//统计
		for(int i = 0; i < len; i++){
			int age = arr[i];
			if(age < 0 || age > ageAtOld){
				System.out.println("出错！");
				return ;
			}
			tempArr[age]++;
		}
		//返回原数组
		int index = 0;
		for(int i = 0; i <= ageAtOld; i++){
			for(int j = 0; j < tempArr[i]; j++){
				arr[index] = i;
				index++;
			}
		}
	}
	
	
}
