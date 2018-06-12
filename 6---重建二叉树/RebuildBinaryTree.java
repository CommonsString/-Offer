package jianzhiOffer;


/**
 * @author commonsstring@gmail.com
 * 
 * 题目 : 重建二叉树
 */
class BinaryTreeNode{
	int value;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	public BinaryTreeNode(int value) {
		this.value = value;
	}
}
public class RebuildBinaryTree {
	
	
	public static void main(String[] args) {
		int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
		BinaryTreeNode head = buildTreeFirst(pre, mid);
		System.out.println(head.value);
		System.out.println(head.leftChild.value);
		System.out.println(head.rightChild.value);
	}
	
	/**
	 * 方法一：递归构造
	 * 思路：
	 *  根据前序遍历找出根结点M, 然后在中序遍历中找出M位置X
	 *  所有, 在中序遍历中, 0~X为左子树范围, X + 1为右子树范围
	 *  根据范围递归实现
	 */
	public static BinaryTreeNode buildTreeFirst(int[] preOrder, int[] midOrder){
		//参数检查
		if(preOrder.length < 1 || midOrder.length < 1) return null;
		BinaryTreeNode root = buildTreeFirst(preOrder, 0, preOrder.length - 1, midOrder, 0, midOrder.length - 1);
		return root;
	}
	
	public static BinaryTreeNode buildTreeFirst(int[] preOrder, int startPre, int endPre,
			int[] midOrder, int startMid, int endMid){
		//参数范围检查
		if(startPre > endPre || startMid > endMid) return null;
		//获取根结点
		BinaryTreeNode root = new BinaryTreeNode(preOrder[startPre]);
		//递归建立左右子树
		for(int i = startMid; i <= endMid; i++){
			//中序序列中寻找根结点
			if(midOrder[i] == root.value){
				//中序左子树长度
				int midLeftLen = i - startMid;
				//前序左子树长度
				int preLeftLen = midLeftLen + startPre;
				//递归构造左子树
				root.leftChild = buildTreeFirst(preOrder, startPre + 1, preLeftLen, midOrder, startMid, i - 1);
				root.rightChild = buildTreeFirst(preOrder, preLeftLen + 1, endPre, midOrder, i + 1, endMid);
				//循环只是为了查找中序中的根结点
				break;
			}
		}
		return root;
	}
	
}
