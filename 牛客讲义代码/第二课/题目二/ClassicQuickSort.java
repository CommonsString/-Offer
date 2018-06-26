package nuiKe;

import java.util.Arrays;

/**
 * 
 * 经典快速排序
 * patition的第二种写法：https://blog.csdn.net/morewindows/article/details/6684558
 */
public class ClassicQuickSort {
	
	
	public static void main(String[] args) {
		int[] arr = GenerUtils.getRandomArr(10, 5);
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr, int L, int R){
		if(L >= R) return ;
		int index = potition(arr, L, R);
		quickSort(arr, L, index - 1);
		quickSort(arr, index + 1, R);
	}
	
	/**
	 * 每次用第一个数, 作为基准 
	 * 小于等于放左边, 大于放右边
	 */
	public static int potition(int[] arr, int L, int R){
		//参数检查
		if(arr == null || L < 0 || R >= arr.length){
			throw new RuntimeException("参数异常");
		}
		int less = L;
		int current = L + 1;
		while(current <= R){
			if(arr[current] <= arr[L]){
				GenerUtils.swapNum(arr, current++, ++less);
			}else{
				current++;
			}
		}
		//将less和L交换
		GenerUtils.swapNum(arr, L, less);
		return less;
	}
	
	/**
	 * 挖坑填数
	 */
	public static int potitionSecond(int[] arr, int L, int R){
		//参数检查
		if(arr == null || L < 0 || R >= arr.length){
			throw new RuntimeException("参数异常");
		}		
		//记录第一个数, 初始化i, j的值
		int x = arr[L];
		int i = L, j = R;
		while(i < j){
			//从右向左, 查找小于X的数
			while(i < j && arr[j] >= x) j--;
			//填坑, s[j]形成一个新的坑
			if(i < j) arr[i++] = arr[j]; 
			//从左到右, 查找大于等于X的数
			while(i < j && arr[i] < x) i++;
			//填坑, s[i]形成新的坑
			if(i < j) arr[j--] = arr[i]; 
		}
		//默认 i=j, 最后一个坑i
		arr[i] = x;
		return i;
	}
	
	
	
}
