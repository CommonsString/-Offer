package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 数值的整数次方
 */
public class ImplPowMethod {
	
	public static void main(String[] args) {
		System.out.println(powC(-2, 3));
	}
	
	
	/** 
	 * 考虑所有情况 
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double powA(double base, int exponent){
		//地数位0
		if(base == 0) return 0;
		//指数为0
		if(exponent == 0) return 1;
		double mul = 1.0;
		long len = Math.abs(exponent);
		for(int i = 0; i < len; i++){
			//判断正负
			if(base > 0){
				//底数为正, 指数为正
				if(exponent > 0){
					mul = mul * base;
				}else{ //底数为正, 指数为负
					mul = mul * (1.0 / base);
				}
			}else{
				//底数为负, 指数为正
				if(exponent > 0){
					//指数分奇偶
					if(exponent % 2 == 0){
						//偶数, 为正
						mul = mul * base;
					}else{
						//奇数, 为负
						mul = mul * base;
					}
				}else{ //底数为负, 指数为负
					//指数分奇偶
					if(exponent % 2 == 0){
						//偶数, 为正
						mul = mul * (1.0 / base);
					}else{
						//奇数, 为负
						mul = mul * (1.0 / base);
					}					
				}
			}
		}
		return mul;
	}
	
	
	
	/**
	 * 方法二：
	 * 	设置异常处理
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static boolean gable_flag;
	public static double powB(double base, int exponent){
		//底数为0, 无意义
		if(base == 0 && exponent < 0){
			gable_flag = true;
			return 0;
		}
		gable_flag = false;
		double result = 1.0;
		int tempExponment = Math.abs(exponent);
		for(int i = 0; i < tempExponment; i++){
			result = result * base;
		}
		if(exponent < 0){
			result = 1.0 / result;
		}
		return result;
	}
	
	
	/**
	 * 方法三：利用公式减少循环次数
	 * 递归：32的次方, 可以求16次方的平方, 以此类推
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double powC(double base, int exponent){
		//递归结束
		if(exponent == 0) return 1;
		if(exponent == 1) return base;
		double result = powC(base, exponent >> 1);
		result *= result;
		if((exponent & 1) == 1){// 奇数
			result *= base;
		}
		return result;
	}
	
	
	
	
}
