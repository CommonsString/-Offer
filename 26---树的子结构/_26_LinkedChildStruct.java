package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left = null;
	TreeNode right = null;
	public TreeNode(int val) {
		super();
		this.val = val;
	}
}	
public class _26_LinkedChildStruct {
	
	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(9);
		TreeNode node5 = new TreeNode(2);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(7);
		root1.left = node2;
		root1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node5.left = node6;
		node5.right = node7;
		
		TreeNode root2 = new TreeNode(8);
		root2.left = new TreeNode(9);
		root2.right = new TreeNode(2);
		System.out.println(HasSubtree(root1, root2));
		
//		TreeNode root1 = new TreeNode(8);
//		TreeNode node2 = new TreeNode(8);
//		TreeNode node3 = new TreeNode(9);
//		TreeNode node4 = new TreeNode(2);
//		TreeNode node5 = new TreeNode(5);
//		root1.left = node2;
//		node2.left = node3;
//		node3.left = node4;
//		node4.left= node5;
//		
//		
//		TreeNode root2 = new TreeNode(8);
//		root2.left = new TreeNode(9);
//		root2.left.left = new TreeNode(3);
//		System.out.println(HasSubtree(root1, root2));
		
//		finds(root1);
//		finds(root2);
	}
	
	
	public static void finds(TreeNode root){
		if(root == null) return ;
		System.out.println(root.val);
		finds(root.left);
		finds(root.right);
	}
	

	/**
	 * 遍历 
	 */
	public static boolean HasSubtree(TreeNode root1,TreeNode root2){
		boolean result = false;
		if(root1 == null || root2 == null) return false;
		//在root1中找到对应的root2根节点
		if(NodeIsEquals(root1.val, root2.val)) 
			//判断root中是否包含root2
			result = tree1HasTree2(root1, root2);
		if(!result){
			//找不到，从左结点开始
			result = HasSubtree(root1.left, root2);
		}
		if(!result){
			result = HasSubtree(root1.right, root2);
		}
		return result;
	}
	
	public static boolean tree1HasTree2(TreeNode root1,TreeNode root2){
		if(root2 == null) return true;
		if(root1 == null) return false;
		if(!NodeIsEquals(root1.val, root2.val)){
			return false;
		}
		//表明, 根节点相等，匹配左右子树
		return tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right);
	}
	
	public static boolean NodeIsEquals(int root1_value, int root2_value){
		if(root1_value == root2_value) return true;
		return false;
	}
	
	
	
	
	
	/**
	 * 方法二：找到子树的根节点, 并在父树中找到对应结点判断左右子树是否相等
	 * @param root1
	 * @param root2
	 * @return
	 */
    public static boolean HasSubtree2(TreeNode root1,TreeNode root2) {
//    	参数检查
    	if(root1 == null || root2 == null) return false;
//    	查找root1和root相同结点
    	List<TreeNode> target = find(root1, root2);
    	TreeNode current = null;
    	for(TreeNode node : target){
//    		存在右子树
    		if(node.left == null && node.right != null){
    			current = node;
    			while(current != null){
	          		if(current.right.val != root2.right.val){
	        			return false;
	        		}
	          		current = current.right;
    			}
    			return true;
    		}
    		if(node.left != null && node.right == null){
    			current = node;
    			while(current != null){
	          		if(current.left.val != root2.left.val){
	        			return false;
	        		}
	          		current = current.left;
    			}
    			return true;
    		}
    		if(node.left != null && node.right != null){
    			if(node.left.val == root2.left.val
    					&& node.right.val == root2.right.val){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
  
    public static List<TreeNode> find(TreeNode node1, TreeNode node2){
    	int value = node2.val;
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode currentNode = node1;
    	List<TreeNode> result = new ArrayList<>();
    	while(true){
    		while(currentNode != null){
    			if(value == currentNode.val){
    				result.add(currentNode);
    			}
    			stack.push(currentNode);
    			currentNode = currentNode.left; 
    		}
    		if(stack.isEmpty()) break;
    		TreeNode temp = stack.pop();
    		currentNode = temp.right;
    	}
    	return result;
    }
    
    
	
}
