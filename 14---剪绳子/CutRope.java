package jianzhiOffer;

import java.util.Arrays;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 剪绳子
 * 动态规划特点：
 * 	1, 求一个问题的最优解
 *  2, 整体问题的最优解是依赖各个子问题的最优解
 *  3, 大问题分成若干的小问题, 小问题之间有互相的重叠
 *  4, 从上往下分析问题, 从下往上解决问题
 * 
 */
public class CutRope {
	
	public static void main(String[] args) {
		System.out.println(getMaxMutlVersionTwo(8));
	}

	/**
	 * @param len 绳子的长度
	 * 动态规划
	 * 剪第一刀, 有 n - 1种选择
	 * 剪第二刀, 有 n - 2种选择.....
	 * 递归公式, f(n) = max(f(i) * f(n - i))
	 * 自下往上分析, 即计算出几个基本子问题的解, 然后根据递归式子向上求解较大问题
	 */
	public static int getMaxMutl(int len){
		//长度为小于2, 无法剪
		if(len < 2) return 0;
		//等于2, 即 1 * 1
		if(len == 2) return 1;
		//等于3, 1 * 2, 1 * 1 * 1, 取其最大
		if(len == 3) return 2;
		//利用数组存储, 每段长度的最优解
		int[] result = new int[len + 1];
		//基本子问题的解
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		int max = 0;
		for(int i = 4; i <= len; i++){
			//(i / 2) 去掉重复和0值
			// i的含义：表示把长度为i的绳子剪成若干段之后, 各段长度乘积的最大值
			for(int j = 1; j <= i / 2; j++){
				int temp = result[j] * result[i - j];
				if(max < temp){
					max = temp;
				}
				result[i] = max;
			}
		}
		System.out.println(Arrays.toString(result));
		max = result[len];
		return max;
	}
	
	
	/**
	 * 贪心策略
	 * @param len
	 * @return
	 * 思路：
	 * 	根据数学证明, 当n>=5的时候, 2(n-2)>n, 3(n-2)>n, 即将绳子剪成2和n-2或者n-3时, 乘积最大.
	 * 	所以, 需要把绳子剪成2或3
	 *  
	 */
	public static int getMaxMutlVersionTwo(int len){
		//参数检查
		if(len < 2) return 0;
		if(len == 2) return 1;
		if(len == 3) return 2;
		
		//3的个数, 尽可能多地剪长度为3的绳子。所以, 剩余长度是1或者2。
		int up3 = len / 3;
		//如果余下的数是1, 把最后一个3和1合并成4, 这种情况下, 将3的个数剪1
		if(len - up3 * 3 == 1){
			up3 -= 1;
		}
		//如果余下的数是2, 无需做出修改
		//求出, 2的个数
		int up2 = (len - 3 * up3) / 2;
		return (int)(Math.pow(3, up3) * Math.pow(2, up2));
	}
	
	
	
}
