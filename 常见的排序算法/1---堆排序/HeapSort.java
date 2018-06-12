package nuiKe;

import java.util.Arrays;

/**
 * 堆排序
 * 完全二叉树：
 * 左孩子： 2 * i + 1
 * 右孩子：2 * i + 2
 * 父： (i - 1) / 2
 * 堆： 分为大根堆, 和小根堆
 * 大根堆： 最大是父节点
 */
public class HeapSort {
	
	public static void main(String[] args) {
		int[] arr = GenerUtils.getRandomArr(100, 10);
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	
	public static void heapSort(int[] arr){
		if(arr.length < 2 || arr == null) return;
		//组成大根堆
		for(int i = 0, len = arr.length; i < len; i++){
			//逐一变成大根堆
			heapInsert(arr, i);
		}
		//记录数组长度
		int size = arr.length;
		//堆头和堆尾交换
		GenerUtils.swapNum(arr, 0, --size);
		//fly下沉过程：每次取出大根堆根节点(最大)和最后一个叶子结点交换, 叶子结点下沉  
		while(size > 0){
			//每次排除最后一个数
			heapFly(arr, 0, size);
			GenerUtils.swapNum(arr, 0, --size);
		}
	}
	
	/**
	 * @param arr
	 * @param index
	 * 变成一个大根堆
	 * 大根堆交换最大数
	 */
	public static void heapInsert(int[] arr, int index){
		//index : 当前结点
		//(index - 1) / 2  ： 当前结点的父结点
		while(arr[index] > arr[(index - 1) / 2]){
			//交换两个数
			GenerUtils.swapNum(arr, index, (index - 1) / 2);
			//向上寻找
			index = (index - 1) / 2;
		}
	}
	
	/**
	 * @param arr
	 * @param size
	 */
	public static void heapFly(int[] arr, int index, int size){
		//获取当前数的左孩子
		int leftChild = 2 * index + 1;
		//边界
		while(leftChild < size){
			//左右孩子先PK一下, 找出最大值
			//记录左右孩子最大值的位置
			int maxIndex = leftChild + 1 < size && 
					arr[leftChild] > arr[leftChild + 1] ? leftChild : leftChild + 1;
			//PK完后, 与当前父节点PK
			//左右孩子中的最大值, 与当前值相比, 求最大
			maxIndex = arr[maxIndex] > arr[index] ? maxIndex : index;
			//判断只有一个数, 即本身, 中断循环
			if(maxIndex == index) break;
			//这一步, 默认maxIndex != index, 交换值
			GenerUtils.swapNum(arr, maxIndex, index);
			//坐标赋值
			index = maxIndex;
			//坐标下沉, 继续比较
			leftChild = 2 * index + 1;
		}
	}
	
	
}
