package jianzhiOffer;

import java.util.Stack;

/**
 * @author commonsstring@gmail.com
 * 
 * 题目：二叉树镜像
 */
public class _27_JXBinaryThree {
	
	
	public static void main(String[] args) {
		
	}
	
	/**
	 * 方法一：遍历, 如果结点存在子结点, 则交换两子结点的值
	 */
    public static void Mirror(TreeNode root) {
    	if(root == null) return ;
    	if(root.left == null && root.right == null) return ;
//    	TreeNode temp = root.left;
//    	root.left = root.right;
//    	root.right = temp;
    	swap(root.left, root.right);
    	if(root.left != null){
    		Mirror(root.left);
    	}
    	if(root.right != null){
    		Mirror(root.right);
    	}
    }
    
    public static void swap(TreeNode x, TreeNode y){
    	TreeNode temp = x;
    	x = y;
    	y = temp;
    }
    
    /**
     * 方法二：非递归实现
     * @param x
     * @param y
     */
    public static void MirrorNot(TreeNode root){
    	if(root == null) return;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode current = root;
    	while(true){
    		while(current != null){
    			if(current.left != null || current.right != null){
    				TreeNode temp = current.left;
    				current.left = current.right;
    				current.right = temp;
    			}
    			stack.push(current);
    			current = current.left;
    		}
    		if(stack.isEmpty()) break;
    		TreeNode temp = stack.pop();
    		current = temp.right;
    	}
    }
}
