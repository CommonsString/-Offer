package jianzhiOffer;

import java.util.Arrays;
import java.util.Stack;

import nuiKe.GenerUtils;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 旋转数组最小数字
 */
public class ArrayRandom {

	
	public static void main(String[] args) {
		int[] arr = {45, 46, 47, 12, 13};
		int result = arrRandomFive(arr);
		System.out.println(result);
	}
	
	
	/**
	 * 两个辅助栈, 从小到大进入栈1
	 * 从大到小, 进入栈2
	 * @return
	 */
	public static int arrRandomFirst(int[] arr){
		if(arr.length < 2 || arr == null){
			throw new RuntimeException("参数异常");
		}
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] < arr[i + 1]){
				stack1.push(arr[i]);
			}else{
				stack1.push(arr[i]);
				stack2.push(arr[i + 1]);
			}
		}
		return stack2.peek();
	}
	
	/**
	 * 遍历数组, 遇到分界线向前替换
	 * @return
	 */
	public static int arrRandomSecond(int[] arr){
		if(arr.length < 2 || arr == null){
			throw new RuntimeException("参数异常");
		}
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] > arr[i + 1]){
				GenerUtils.swapNum(arr, i, i + 1);
				int temp = i;
				while(temp > 0){
					if(arr[temp - 1] > arr[temp]){
						GenerUtils.swapNum(arr, temp - 1, temp);
					}
					temp--;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr[0];
	}
	
	//遍历返回
	public static int arrRandomThree(int[] arr){
		if(arr.length < 2 || arr == null){
			throw new RuntimeException("参数异常");
		}
		int result = 0;
		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] > arr[i + 1]){
				result = arr[i + 1];
			}
		}
		return result;
	}
	
	
	/**
	 * 书上版本一
	 * 缺陷, 当px1 = px2 = minIndex时, 无法确定最小值属于哪个区间
	 * 解决方案, 顺序查找
	 */
	public static int arrRandomFour(int[] arr){
		if(arr.length < 2 || arr == null){
			throw new RuntimeException("参数异常");
		}
		int px1 = 0;
		int px2 = arr.length - 1;
		int midIndex = px1;
		while(arr[px1] >= arr[px2]){
			//指针相差1, 说明最小值是midIndex
			if(px2 - px1 == 1){
				midIndex = px2;
				break;
			}
			//中值
//			midIndex = ((px2 - px1) >> 2) + px1;
			midIndex = (px2 + px1) / 2;
			if(arr[midIndex] >= arr[px1]){
				px1 = midIndex;
			}
			if(arr[midIndex] <= arr[px2]){
				px2 = midIndex;
			}
		}
		return arr[midIndex];
	}
	
	
	/**
	 * 书上版本二(二分查找)
	 * 缺陷, 当px1 = px2 = minIndex时, 无法确定最小值属于哪个区间
	 * 解决方案, 顺序查找
	 */
	public static int arrRandomFive(int[] arr){
		if(arr.length < 2 || arr == null){
			throw new RuntimeException("异常");
		}
		int px1 = 0;
		int px2 = arr.length - 1;
		int midIndex = px1;
		while(arr[px1] >= arr[px2]){
			//相差一, 最小值是px2
			if(px2 - px1 == 1){
				midIndex = px2;
				break;
			}
			//px1 == px2 == midIndex相等, 使用顺序查找
			midIndex = (px2 + px1) / 2;
			if(arr[px1] == arr[px2] && arr[midIndex] == arr[px2]){
				return findSome(arr, px1, px2);
			}
			if(arr[midIndex] >= arr[px1]){
				px1 = midIndex;
			}else if(arr[midIndex] <= arr[px2]){
				px2 = midIndex;
			}
		}
		return arr[midIndex];
	}
	
	public static int findSome(int[] arr, int L, int R){
		int result = arr[L];
		for(int i = L + 1; i <= R; i++){
			if(result > arr[i]){
				result = arr[i];
			}
		}
		return result;
	}
	
	
	
}
