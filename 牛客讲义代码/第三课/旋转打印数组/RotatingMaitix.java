package nuiKe;


/**
 * 给定一个整型矩阵matrix，请按照转圈的方式打印它。
 */
public class RotatingMaitix {
	
	public static void main(String[] args) {
		
		int[][] arr = {
				{1, 2, 3, 5},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};
		rotatingPrint(arr);
	}
	
	
	public static void rotatingPrint(int[][] matrix){
		//初始化左上角和右下角坐标
		int a = 0;
		int b = 0;
		int c = matrix.length - 1;
		int d = matrix[0].length - 1;
		//边界
		while(a <= c && b <= d){
			printMartic(matrix, a++, b++, c--, d--);
		}
	}
	
	/**
	 * 左上角的点  ---- L(a, b) 
	 * 右下角的点 ---- R(c, d)
	 */
	public static void printMartic(int[][] maitix, int a, int b, int c, int d){
		//边界 , 一行的情况顺序打印
		if(a == c){
			for(int i = b; i <= d; i++){
				System.out.print(maitix[a][i] + " ");
			}
		}
		//只有一列
		if(b == d){
			for(int i = a; i <= c; i++){
				System.out.println(maitix[i][b] + " ");
			}
		}else{ //多行多列
			int curA = a;
			int curB = b;
			//从左到右
			while(curB != d){
				System.out.print(maitix[a][curB] + " ");
				curB++;
			}
			//从上到下
			while(curA != c){
				System.out.print(maitix[curA][d] + " ");
				curA++;
			}
			//从右到左
			while(curB != b){
				System.out.print(maitix[c][curB] + " ");
				curB--;
			}
			while(curA != a){
				System.out.print(maitix[curA][b] + " ");
				curA--;
			}
		}
	}
	
}
