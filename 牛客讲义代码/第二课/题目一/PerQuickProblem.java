package nuiKe;

import java.util.Arrays;



/**
 * commonsstring@gmail.com
 */
public class PerQuickProblem {
	
	
	public static void main(String[] args) {
		int[] arr = GenerUtils.getRandomArr(100, 10);
//		int[] arr = {5, 1, 2, 5, 7, 3, 4};
		System.out.println(Arrays.toString(binaryCheckSecond(arr, 5)));
	}
	
	/**
	 * 题目：荷兰国旗问题
	 *  给定一个数组arr，和一个数num，请把小于num的数放在数组的
		左边，等于num的数放在数组的中间，大于num的数放在数组的
		右边。
	 */
	public static int[] binaryCheckSecond(int[] arr, int target){
		//参数检查
		if(arr.length < 1 || arr == null) return null;
		return binaryCheckSecond(arr, target, 0, arr.length - 1);
	}
	
	public static int[] binaryCheckSecond(int[] arr, int target, int L , int R){
		//定义前后指针
		int pxFirst = L - 1;
		int pxSecond = R + 1;
		//当前指针
		int current = L;
		while(current < pxSecond){
			//三种情况
			if(arr[current] == target){
				current++;
			}else if(arr[current] < target){
				//小于, 交换
				GenerUtils.swapNum(arr, ++pxFirst, current++);
			}else if(arr[current] > target){
				//大于, 交换
				GenerUtils.swapNum(arr, --pxSecond, current);
			}
		}
		return arr;
	}
	
	/**
	 * 题目
	 * 给定一个数组arr，和一个数num，请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。
	 */
	public static int[] binaryCheck(int[] arr, int target){
		//参数检查
		if(arr.length < 1 || arr == null) return null;
		//最小集合
		int less = -1;
		int current = 0;
		while(current < arr.length- 1){
			//当前值小于目标值
			if(arr[current] > target){
				current++;
			}                                                                              
			if(arr[current] <= target){
				GenerUtils.swapNum(arr, ++less, current++);
			}
		}
		return arr;
	}
	
	
}
