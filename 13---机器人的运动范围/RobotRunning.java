package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 机器人的运动范围
 */
public class RobotRunning {
	
	public static void main(String[] args) {
		System.out.println(movingCount(3, 3, 4));
	}
	
	/**
	 * @param threshold 阈值K
	 * @param rows 矩阵行
	 * @param cols 矩阵列
	 * @return
	 * 思路：
	 *   从(0, 0)开始, 判断下一步坐标位数和是否小于threshold
	 *   是, 进入继续判断。
	 */
	public static int movingCount(int threshold, int rows, int cols){
		//参数检查
		if(threshold < 0 || rows < 0 || cols < 0) return 0;
		//机器人矩阵
		boolean[] isFlag = new boolean[rows * cols]; 
		//结果
		int count = findPath(threshold, rows, cols, 0, 0, isFlag);
		return count;
	}
	
	/**
	 * @param threshold 
	 * @param rows
	 * @param cols
	 * @param row
	 * @param col
	 * @param isFlag 轨迹矩阵, 即选择格子之后, 标记已经选择。
	 * @return
	 */
	public static int findPath(int threshold, int rows, int cols, int row, int col, boolean[] isFlag){
		//参数检查
		if(isFlag == null || isFlag.length < 0) return 0;
		int count = 0;
		//数位和
		int sum = getSum(row) + getSum(col);
		//坐标
		int index = row * cols + col;
		if(row >= 0 && row < rows
				&& col >= 0 && col < cols 
				&& sum <= threshold
				&& !isFlag[index]){
			isFlag[index] = true;
			//1 + 相当于, 自增之后再相加
			count = 1 + findPath(threshold, rows, cols, row - 1, col, isFlag) 
				   + findPath(threshold, rows, cols, row + 1, col, isFlag)
				   + findPath(threshold, rows, cols, row, col - 1, isFlag)
				   + findPath(threshold, rows, cols, row, col + 1, isFlag);
		}
		return count;
	}
	
	/**
	 * 获取坐标, 数位之和
	 */
	public static int getSum(int num){
		int sum = 0;
		do{
			sum += num % 10;
		}while((num = num / 10) > 0);
		return sum;
	}
	
	
}
