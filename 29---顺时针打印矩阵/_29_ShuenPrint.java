package jianzhiOffer;

import java.util.ArrayList;

public class _29_ShuenPrint {
	
	
	public static void main(String[] args) {
		
		int[][] matrix = {
//				{1, 2, 3, 5},
//				{5, 6, 7, 8},
//				{9, 10, 11, 12},
//				{13, 14, 15, 16}
				{1, 2},
				{3, 4}
		};
//		ArrayList<Integer> result = printMatrix(matrix);
//		for(int val : result){
//			System.out.print(val + " ");
//		}
	}
	
	ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
    	//参数检查
    	if(matrix == null) return null;
    	int A_x = 0, A_y = 0;
    	int B_x = matrix.length - 1, B_y = matrix[0].length - 1;
    	while(A_x <= B_x && A_y <= B_y){
    		printMatrix(matrix, A_x++, A_y++, B_x--, B_y--);
    	}
    	return result;
    }
    
    public void printMatrix(int [][] matrix,  int A_x, int A_y, int B_x, int B_y){
    	//只有一行
    	if(A_x == B_x){
    		for(int i = A_y; i <= B_y; i++){
    			result.add(matrix[A_x][i]);
    		}
    	}else if(A_y == B_y){
    		for(int i = 0; i <= B_x; i++){
    			result.add(matrix[i][B_y]);
    		}
    	}else{
    		int curA_x = A_x;
    		int curA_y = A_y;
    		//左到右
    		while(curA_y != B_y){
    			result.add(matrix[A_x][curA_y]);
    			curA_y++;
    		}
    		//上到下
    		while(curA_x != B_x){
    			result.add(matrix[curA_x][B_y]);
    			curA_x++;
    		}
    		//右到左
    		while(curA_y != A_y){
    			result.add(matrix[B_x][curA_y]);
    			curA_y--;
    		}
    		//下到上
    		while(curA_x != A_x){
    			result.add(matrix[curA_x][A_y]);
    			curA_x--;
    		}
    	}
    }
    
    
    
    

}
