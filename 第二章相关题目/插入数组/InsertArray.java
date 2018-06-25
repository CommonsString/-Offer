package jianzhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 替换空格之后的相关题目
 * 有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。请实现一个函数，把A2中的所有数字插入到A1中并且所有数字是排序的。
 */
public class InsertArray {
	
	
	public static void main(String[] args) {
		int[] arr1 = {3, 6, 9, 10};
		int[] arr2 = {1, 2, 4, 6};
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println("方法一 ：" + Arrays.toString(methodFirst(arr1, arr2)));
		
		int[] a = new int[10];
		a[0] = 1;
		a[1] = 3;
		a[2] = 6;
		int[] b = {2, 5, 8, 9, 10};
		System.out.println("方法二：" + Arrays.toString(methodSecond(a, b, 3, b.length)));
	}
	
	/**
	 * 方法一：外排数组
	 * 思路：
	 * 	声明指针, pxOne指向第一个数组的头部, pxTwo指向第二个数组的头部。
	 *  如果pxOne > pxTwo
	 *    将pxTwo插入到辅助数组
	 *  否则将pxOne插入到辅助数组
	 *  即, 每次比较, 把较小的数放入辅助数组
	 */
	public static int[] methodFirst(int[] arrOne, int[] arrTwo){
		//参数检查
		if(arrOne.length < 1 || arrOne == null &&
				arrTwo.length < 1 || arrTwo == null) return null;
		//声明一个辅助数组
		int[] tempArr = new int[arrOne.length + arrTwo.length];
		//定义指针
		int pxOne = 0;
		int pxTwo = 0;
		int i = 0;
		while(pxOne < arrOne.length && pxTwo < arrTwo.length){
			tempArr[i++] = arrOne[pxOne] > arrTwo[pxTwo] ? arrTwo[pxTwo++] : arrOne[pxOne++];
		}
		//默认pxTwo已经越界
		while(pxOne <= arrOne.length - 1){
			tempArr[i++] = arrOne[pxOne++];
		}
		//默认pxOne已经越界
		while(pxTwo <= arrTwo.length - 1){
			tempArr[i++] = arrTwo[pxTwo++];
		}
		
/*		int len = arrOne.length + arrTwo.length;
		for(int j = 0; j < len; j++){
			//将数组复制到A1
		}
*/
		return tempArr;
	}

	/**
	 * 方法一：题设的解法
	 * 思路：
	 * 	声明指针, pxOne指向第一个数组的头部, pxTwo指向第二个数组的头部。
	 *  如果pxOne > pxTwo
	 *    将pxTwo插入到辅助数组
	 *  否则将pxOne插入到辅助数组
	 *  即, 每次比较, 把较小的数放入辅助数组
	 */
	public static int[] methodSecond(int[] A1, int[] A2, int a1_size, int a2_size){
		//参数检查
		if(A1.length < 1 || A1 == null &&
				A2.length < 1 || A2 == null) return null;
		//A1的空间足够大
		int p1 = a1_size - 1;
		int p2 = a2_size - 1;
		int i = a1_size + A2.length - 1;
		while(p1 >= 0 && p2 >= 0){
			A1[i--] = A1[p1] >= A2[p2] ? A1[p1--] : A2[p2--];
		}
		while(p1 >= 0){
			A1[i--] = A1[p1--];
		}
		while(p2 >= 0){
			A1[i--] = A2[p2--];
		}
		return A1;
	}
	
	
}
