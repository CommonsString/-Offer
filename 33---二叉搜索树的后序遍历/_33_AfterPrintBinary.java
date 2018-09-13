package jianzhiOffer;

import org.junit.Test;

/**
 * 二叉搜索树的后序遍历
 * @author Administrator
 *
 */
public class _33_AfterPrintBinary {

	
	
	/**
	 * 思路：
	 * 1, 找到根节点
	 * 2，遍历序列，找到第一个大于或等于根节点的元素i, i的左边是左子树，右边是右子树。
	 * 3， 我们已经知道i左侧所有元素均小于根结点，那么再依次遍历右侧，
	 * 注意：递归结束条件, if(start >= end) return true, 到了这一步说明所有情况已经递归完毕且符合后序遍历序列。
	 *       如果不符合, 在判断右子树的时候，就已经返回false了。
	 * 
	 * @param sequence
	 * @return
	 */
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length < 1 || sequence == null) return false;
		return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }
	
	public boolean VerifySquenceOfBST(int [] sequence, int start, int end) {
		//返回true, 递归结束条件, 即所有的数组都满足左子树小于根节点，右子树大于根节点
		if(start >= end) return true;
		//获取根节点
		int root = sequence[end];
		//在二叉树中左子树节点的值小于根节点的值
		int i = start;
		for(; i < end; i++) {
			if(sequence[i] > root) {
				break;
			}
		}
		//i的值变成左子树最后一个元素的下标
		int j = i;
		//判断二叉树中右子树节点大于根节点的值
		for(; j < end; j++) {
			if(sequence[j] < root) {
				//右子树存在小与根节点的值, 直接返回false
				return false;
			}
		}
		//j的值变成右子树最后一个元素的下标
		//递归
		boolean left = true;
		if(i > 0) {
			left = VerifySquenceOfBST(sequence, start, i - 1);
		}
		boolean right = true;
		if(i < end){
			right = VerifySquenceOfBST(sequence, i, end - 1);
		}
		return left && right;
    }
	
	
	@Test
	public void test(){
		int[] arr = {5, 7, 6, 9, 11, 10, 8};
		int[] arr2 = {7, 4, 6, 5};
		System.out.println(VerifySquenceOfBST(arr2));
	}
	
}
