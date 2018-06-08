package jianzhiOffer;



/**
 * @author commonsstring@gmail.com
 * 
 * 
 * 题目 : 二维数组中的查找
 */
public class FindNumberForArr {
	
	public static void main(String[] args) {
		int[][] arr = {
				{2, 3, 4}, 
				{5, 6, 7}, 
				{8, 9, 10}
				};
		System.out.println(findNumberSecond(arr, 10));
	}
	
	
	/**
	 * 方法一：蛮力法
	 * 时间复杂度：O(N ^ 2)
	 * 空间复杂度：O(N)
	 * 思路：
	 *  强势遍历二维数组, 找到则返回。
	 */
	public static int findNumberFirst(int[][] arr, int target){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		//遍历二维数组
		for(int i = 0, row = arr.length; i < row; i++){
			for(int j = 0, column = arr[0].length; j < column; j++){
				if(arr[i][j] == target){
					return arr[i][j];
				}
			}
		}
		return -1;
	}
	
	/**
	 * 方法一：右边角查找
	 * 思路：
	 *  每次找到二维数组的最右角的数M。
	 *  如果 M > targer
	 *    行++
	 *  如果 M < target
	 *    列--
	 *  如果相等 返回。
	 */
	
	public static int findNumberSecond(int[][] arr, int target){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		//记录初始最右边角数字, 二维数组的地址为 ： 行 = 0; 列 = 列的长度  - 1
		int row = 0;
		int column = arr[0].length - 1;
		//处理边界
		while(column >= 0 && row < arr.length){
			if(target > arr[row][column]){
				row++;
			}else if(target < arr[row][column]){
				column--;
			}else{
				return arr[row][column];
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
