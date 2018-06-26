package jianzhiOffer;
/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 矩阵中的路径
 * 思路：
 * 	采用回溯思想, 对每一个字符进行上下左右的遍历, 合适就继续, 不合回溯到上一个节点, 继续上下左右的遍历
 */
public class MarixPathProblem {
	
	public static void main(String[] args) {
		char[] matrix = {
				'a', 'b', 't', 'g', 
				'c', 'f', 'c', 's',
				'j', 'd', 'e', 'h'};
		Character[] target = {'a', 'b', 'f', 'g'};
		System.out.println(isExistPath(matrix, 3, 4, target));
	}
	
	/**
	 * 
	 * @param matrix 路径矩阵
	 * @param row 路径矩阵的行数
	 * @param col 路径矩阵中的列数
	 * @param target 目标字符
	 * @return
	 */
	public static boolean isExistPath(char[] matrix, int row, int col, Character[] target){
		//参数检查
		if(matrix == null || row < 1 || col < 1 || target == null) return false;
		//目标字符匹配的长度
		int pathLen = 0;
		//辅助数组, 标志路径矩阵中每一个位置，是否已经遍历, 即遍历true, 未遍历false
		boolean[] isFlag = new boolean[row * col];
		//遍历矩阵
		for(int i = 0; i < row; i++){
			for(int j = 0; j < col; j++){
				//寻找路径
				if(findPath(matrix, row, col, i, j, pathLen, isFlag, target)){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * 回溯方法, 一般使用递归
	 * @param matrix
	 * @param row
	 * @param col
	 * @param curRow 
	 * @param curCol
	 * @param pathLen 目标字符长度, 即匹配到了那个位置
	 * @param isFlag 辅助数组, 标志路径矩阵中每一个位置
	 * @param target
	 * @return 路径矩阵中是否存在目标字符路径
	 */
	public static boolean findPath(char[] matrix, int row, int col, int curRow, int curCol,
			int pathLen, boolean[] isFlag, Character[] target){
		//下标计算
		int index = curRow * col + curCol;
		//递归结束条件
		if(pathLen == target.length) return true;
		//返回标志, 回溯关键
		boolean isFind = false;	
		if(curRow >= 0 && curRow < row 
				&& curCol >= 0 && curCol < col 
				&& matrix[index] == target[pathLen]
				&& !isFlag[index]){
			++pathLen;
			isFlag[index] = true;
			//递归上下左右, 寻找合适字符
			isFind = findPath(matrix, row, col, curRow + 1, curCol, pathLen, isFlag, target)
					|| findPath(matrix, row, col, curRow - 1, curCol, pathLen, isFlag, target)
					|| findPath(matrix, row, col, curRow, curCol - 1, pathLen, isFlag, target)
					|| findPath(matrix, row, col, curRow, curCol + 1, pathLen, isFlag, target);
			//回溯, 如果当前值, 上下左右都无法找到匹配的值, 即回溯到上一个节点
			if(!isFind){
				--pathLen;
				isFlag[index] = false;
			}
		}
		return isFind;
	}
	
}
