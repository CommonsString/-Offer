package nuiKe;

import java.util.Arrays;

/**
 * 快速排序
 *
 */
public class QuickSort {
	
	
	public static void main(String[] args) {
		int[] arr = GenerUtils.getRandomArr(100, 10);
		quickSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	/**
	 * 递归版本
	 * @param arr
	 */
	public static void quickSort(int[] arr){
		if(arr.length < 2 || arr == null) return ;
		quickSort(arr, 0, arr.length - 1);
	}
	public static void quickSort(int[] arr, int L, int R){
		//边界
		if(L >= R) return ;
		//随机快排
		int randNum = L + (int)(Math.random() * (R - L + 1));
		GenerUtils.swapNum(arr, randNum, R);
		//获取等于的边界
		int[] index = binaryCheckSecond(arr, L, R);
		//小于等于index
		quickSort(arr, L, index[0] - 1);
		quickSort(arr, index[1] + 1, R);
	}
	
	
	public static int[] binaryCheckSecond(int[] arr, int L , int R){
		//定义前后指针
		int pxFirst = L - 1;
		//目标值, 定到R的位置
		int pxSecond = R;
		//当前指针
		int current = L;
		while(current < pxSecond){
			//三种情况
			if(arr[current] == arr[R]){
				current++;
			}else if(arr[current] < arr[R]){
				//小于, 交换
				GenerUtils.swapNum(arr, ++pxFirst, current++);
			}else if(arr[current] > arr[R]){
				//大于, 交换
				GenerUtils.swapNum(arr, --pxSecond, current);
			}
		}
		//归位
		GenerUtils.swapNum(arr, pxSecond, R);
		return new int[]{pxFirst + 1, pxSecond};
	}
	
	
}
