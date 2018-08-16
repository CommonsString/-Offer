package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 对称二叉树
 */
public class _28_EqualBinaryThree {
	
	/**
	 * 方法一：即二叉树与其镜像相等, 则对称
	 * 前序遍历和对称前序遍历, 比较遍历的值相等, 则对称
	 * 对称前序遍历：根右左
	 * @param root
	 * @return
	 */
	public boolean isSymmetrical(TreeNode root){
		//前序和对称前序
		return isSymmetrical(root, root);
	}

	/**
	 * 相当于同时进行前序和对称前序
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isSymmetrical(TreeNode root1, TreeNode root2){
		if(root1 == null && root2 == null) return true;
		if(root2 == null || root1 == null) return false;
		//前序和非前序值不等, 直接返回false
		if(root1.val != root2.val) return false;
		//前序: 根左右
		//对称前序：根右左
		return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
	}
	
	
	/**
	 * 出栈成对出栈
	 * 一个为空, 返回false
	 * 不为空, 比较当前的值
	 * @param root1
	 * @return
	 */
	public boolean isSymmetrical2(TreeNode root1){
		//参数检查
		if(root1 == null) return true;
		Queue<TreeNode> queue = new LinkedList<>();
		//成对插入
		queue.offer(root1.left);
		queue.offer(root1.right);
		while(!queue.isEmpty()){
			//成对出队
			TreeNode right = queue.poll();
			TreeNode left = queue.poll();
			//都为空, 继续
			if(right == null && left == null) continue;
			//一边为空, 不对称
			if(left == null || right == null) return false;
			if(right.val != left.val) return false;
			//成对插入
			queue.offer(left.left);
			queue.offer(right.right);
			queue.offer(left.right);
			queue.offer(right.left);
		}
		return true;
	}
	
	
	
}
