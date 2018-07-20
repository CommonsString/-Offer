package zuoye;

import java.util.Scanner;

/**
 * commonsstring@gmail.com
 * 
 * 题目：精灵王子洞穴逃亡
	注：M,S,T均是大于等于0的整数。由输入保证取值合法性，考生不用检查。
	提醒：
	如果输入的S为0，则说明本身已经在出口，输出应为：Yes 0
	如果输入的T为0（且S不为0），则说明已经没有时间了，输出应为：No 0
	输入格式：
	M
	S
	T
	输出格式：
	Yes 逃出洞穴所用时间
	或
	No 在洞穴塌陷前能逃跑的最远距离  10
	
	解法：贪心算法
 */
public class ProblemTwo16 {
	
	
	//最小时间, 最大距离
	public static int minTime = Integer.MAX_VALUE, largestDis = Integer.MIN_VALUE;
	public static int M, S, T;
	
	
	public static void main(String[] args) {
		startB();
	}
	

	/**
	 * 方法一：贪心算法
	 * @param dis 跑动距离
	 * @param m
	 * @param time 时间
	 * https://blog.csdn.net/xiaozhuaixifu/article/details/25302069
	 */
	@SuppressWarnings({"resource" })
	public static void start(){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			M = in.nextInt();
			S = in.nextInt();
			T = in.nextInt();
			//S为0, 输出格式
			if(S == 0){
				System.out.println("Yes 0");
				continue;
			}else if(T == 0 && S != 0){
				System.out.println("No 0");
				continue;
			}
			//从0开始计算, 距离为0, 时间为0
			findDfs(0, M, 0);
			if(minTime <= T){
				//格式, Yes 逃出洞穴所用时间
				System.out.println("Yes " + minTime);
			}else{
				System.out.println("Yes " + largestDis);
			}
		}		
	}
	public static void findDfs(int dis, int m, int time){
		//在时间范围内, 求最大距离
		if(time <= T){
			largestDis = dis > largestDis ? dis : largestDis; 
		}
		//距离大于S, 求最短时间
		if(dis >= S){
			minTime = minTime > time ? time : minTime;
			return ;
		}
		//贪心选择
		//能量充足
		if(M >= 10){
			findDfs(dis + 60, m - 10, time + 1);	
		}else{
			//能量不充足, 跑步 + 恢复能量
			findDfs(dis + 17, m, time + 1);
			//休息恢复能量
			findDfs(dis, m + 4, time + 1);
		}
	}
	
	
	/**
	 * 方法二：枚举法
	 * https://blog.csdn.net/Jet_yingjia/article/details/25291331
	 */
	@SuppressWarnings("resource")
	public static void startB(){
		int M, S, T;
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			M = in.nextInt();
			S = in.nextInt();
			T = in.nextInt();
			//最大距离
			int distace = 0;
			//使用魔法值，优先距离
			int flashDistance = 0;
			int time;
			//参数判断
			if(S == 0){
				System.out.println("Yes 0");
				continue;
			}else if(T == 0 && S != 0){
				System.out.println("NO 0");
				continue;
			}else{
				//枚举所有时间经过的最短路径
				for(time = 1; time <= T; time++){
					//跑步
					distace += 17;
					//判断是否可以用魔法
					if(M >= 10){
						flashDistance += 60;
						M -= 10;
					}else{
						//魔法值恢复
						M += 4;
					}
					distace = distace > flashDistance ? distace : flashDistance;
					//成功逃生
					if(distace >= S) break;
				}	
				if(time <= T){
					System.out.println("Yes " + time);
				}else{
					System.out.println("No " + distace);
				}
			}
		}
	}
	
	
}
