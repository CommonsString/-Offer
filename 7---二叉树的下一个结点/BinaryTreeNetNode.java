package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 二叉树的下一个节点
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class BinaryTreeNetNode {
	
	
	
	public static void main(String[] args) {
		
		TreeLinkNode head = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		TreeLinkNode node8 = new TreeLinkNode(8);
		TreeLinkNode node9 = new TreeLinkNode(9);
		head.left = node2;
		head.right = node3;
		head.next = null;
		node2.left = node4;
		node2.right = node5;
		node2.next = head;
		node4.left = null;
		node4.right = null;
		node4.next = node2;
		node5.left = node8;
		node5.right = node9;
		node5.next = node2;
		node3.left = node6;
		node3.right = node7;
		node3.next = head;
		node8.left = null;
		node8.right = null;
		node8.next = node5;
		node9.right = null;
		node9.left = null;
		node9.next = node5;
		node6.left = null;
		node6.right = null;
		node6.next = node3;
		node7.left = null;
		node7.right = null;
		node7.next = node3;		
		
		TreeLinkNode result = GetNextFirst(node7);
		System.out.println( result == null ? "不存在下一个结点" :result.val);	
	}
	
	
	/**
	 * 方法一 ：简洁代码
	 * 思路：
	 *  总之, M结点要寻找下一个结点, 那么M的有无右子树很关键 
	 */
	public static TreeLinkNode GetNextFirst(TreeLinkNode pNode){
		if(pNode == null) return null;
		//结果
		TreeLinkNode result = null;
		//右子树非空
		if(pNode.right != null){
			TreeLinkNode currentNode = pNode.right;
			//寻找左子树
			while(currentNode.left != null){
				currentNode = currentNode.left;
			}
			result = currentNode;
		}else if(pNode.next != null){ //默认右子树为空, 且存在父节点 
			//当前结点
			TreeLinkNode currentNode = pNode;
			//当前结点的父节点
			TreeLinkNode parent = pNode.next;
			//当前结点是父节点的右结点且父节点不为空
			while(parent.right == currentNode && parent != null){
				currentNode = parent;
				parent = parent.next;
			}
			result = parent;
		} 
		return result;
	}
	
	
	
	/**
	 * 方法二 ：方法一的另一种实现方式
	 * 思路：
	 *  总之, M结点要寻找下一个结点, 那么M的有无右子树很关键 
	 */
    public static TreeLinkNode GetNextSecond(TreeLinkNode pNode){
    	TreeLinkNode target = pNode;
		//参数检查
		if(target == null) return target;
		//获取右子树
		TreeLinkNode currentRight = target.right;
		//存在右子树
		if(currentRight != null){
			//遍历右节点的左子树
			TreeLinkNode currentNode = currentRight.left;
			//右子树的左子树为空, 返回当前右子树
			if(currentNode == null) return currentRight;
			while(currentNode != null){
				if(currentNode.left != null){
					currentNode = currentNode.left;
				}
				break;
			}
			
			return currentNode;
		}
		//右子树为空
		if(currentRight == null){
			//获取父节点
			TreeLinkNode currentParent = target.next;
			//当前结点是它父节点的左孩子
			if(currentParent.left == target){
				return currentParent;
			}
			//当前结点是它父节点的右孩子
			if(currentParent.right == target){
				TreeLinkNode currentNode = target;
				while(currentNode != null){
					//获取父节点
					TreeLinkNode tempParent = currentNode.next;
					//父节点为空, 返回
					if(tempParent == null) return null;
					//如果是根节点, 说明该节点没有下一个结点
					if(tempParent.next == null) return null;
					if(tempParent.next.left == tempParent) return tempParent.next; 
					//向上寻找父节点
					currentNode = tempParent;
				}
			}
		}
		return target;        
    }
	
}
