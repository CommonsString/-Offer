package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 
 * 题目 : 不修改数组找出重复数字
 */
public class NoChangeArr {
	
	
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 4, 3, 2, 6, 7};
		System.out.println(findNumberSecond(arr));
	}
	
	/**
	 * 方法一：空间换时间
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(N)
	 * 思路：
	 * 	注意题设, 不修改原数组, 是不是意味着需要重新开辟一个辅助数组？
	 *  所以, 开辟一个辅助叔祖。
	 *  遍历原数组, 将每一项放在辅助数组对应的下标的位置, 比如: 值为2, 放在数组下标2的位置
	 *  如果存在重复, 返回该数。
	 *  不存在, 放入正确位置
	 */
	public static int findNumberFirst(int[] arr){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		//题设参数范围检查
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 1 || arr[i] > arr.length){
				return -1;
			}
		}
		int len = arr.length;
		Integer[] temp = new Integer[len + 1];
		//下标从1开始
		for(int i = 0; i < len; i++) {
			int index = arr[i];
			if(temp[index] != null){
				return temp[index];
			}else{
				temp[index] = arr[i];
			}
		}
		return -1;
	}
	
	
	/**
	 * 方法二：标准答案
	 * 时间复杂度：
	 * 思路：
	 *  强烈建议, 看看思想就算了。
	 *  因为, 该算法是, 时间换空间, 没错, 是时间换空间！
	 *  利用二分查找的方式, 统计数字出现的次数。
	 */
	public static int findNumberSecond(int[] arr){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		//题设参数范围检查
		for(int i = 0; i < arr.length; i++){
			if(arr[i] < 1 || arr[i] > arr.length){
				return -1;
			}
		}		
		int L = 1;
		int R = arr.length - 1;
		while(R >= L){
			//计算中点
			int middle = ((R - L) >> 1) + L;
			int count = countNum(arr, L, middle);
			//最后一个数
			if(L == R){
				//且存在重复, 返回L
				if(count > 1){
					return L;
				}else{
					break;
				}
			}
			//左部存在重复数字
			if(count > (middle - L + 1)){
				R = middle;
			}else{ //右边存在重复数字
				L = middle + 1;
			}
		}
		return -1;
	}
	//统计
	public static int countNum(int[] arr, int L, int R){
		//参数检查
		if(arr.length < 1 || arr == null) return -1;
		int count = 0;
		//统计范围在[L, R]中的数字在整个数组出现的次数
		for(int i = 0; i < arr.length; i++){
			if(arr[i] >= L && arr[i] <= R){
				count++;
			}
		}
		return count; 
	}
	
	
	
}
