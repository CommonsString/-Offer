package jianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 层序遍历
 * @author Administrator
 *
 */
public class _32_PrintBinaryThree {
	
	
	/**
	 * 层序遍历, 利用队列实现
	 * @param root
	 * @return
	 */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	//参数检查
    	if(root == null) return result;
    	Queue<TreeNode> que = new LinkedList<>();
    	//头结点入队
    	que.offer(root);
    	while(!que.isEmpty()){
    		TreeNode current = que.poll();
    		result.add(current.val);
    		if(current.left != null){
    			que.offer(current.left);
    		}
    		if(current.right != null){
    			que.offer(current.right);
    		}
    	}
    	return result;
    }
    
    
    /**
     * 分行打印二叉树
     * https://blog.csdn.net/nicolasyan/article/details/50629223
     */
    public static void PrintFromTopToBottom2(TreeNode root) {
    	if(root == null) return ;
    	Queue<TreeNode> que = new LinkedList<>();
    	//每层的结点数
    	int levelNum = 0;
    	que.offer(root);
    	while(!que.isEmpty()) {
    		//更新值
    		if(levelNum == 0) levelNum = que.size();
    		TreeNode current = que.poll();
    		System.out.print(current.val + " ");
    		//已经打印，减1
    		levelNum--;
    		//打印换行
    		if(levelNum == 0){
    			System.out.println();
    		}
    		//下一次结点
    		if(current.left != null){
    			que.offer(current.left);
    		}
    		if(current.right != null){
    			que.offer(current.right);
    		}
    	}
    }
    
    /**
     * 分行打印二叉树-实现二
     * https://blog.csdn.net/nicolasyan/article/details/50629223
     */
    
    public static void PrintFromTopToBottom3(TreeNode root) {
    	if(root == null) return ;
    	Queue<TreeNode> que = new LinkedList<>();
    	//下一层结点数目
    	int nextLevel = 0;
    	//当前还没打的数目
    	int toBePrint = 1;
    	que.offer(root);
    	while(!que.isEmpty()) {
    		TreeNode current = que.poll();
    		System.out.print(current.val + " ");
    		//下一层结点
    		if(current.left != null){
    			que.offer(current.left);
    			nextLevel++;
    		}
    		if(current.right != null){
    			que.offer(current.right);
    			nextLevel++;
    		}
    		toBePrint--;
    		if(toBePrint == 0){
    			System.out.println();
    			toBePrint = nextLevel;
    			nextLevel = 0;
    		}
    	}
    	
    }
    
    /**
     * 之子型打印二叉树实现：
     * 1,每层结点存入ArrayList, 偶数层的时候反转
     * 2,两个栈
     * @param args
     */
    @SuppressWarnings("unchecked")
	public static void Print(TreeNode pRoot) {
    	if(pRoot == null) return ;
    	Stack<TreeNode>[] stack = new Stack[2];
    	int cur = 0;
    	int next = 1;
    	stack[0] = new Stack<TreeNode>();
    	stack[1] = new Stack<TreeNode>();
    	stack[cur].push(pRoot);
    	while(!stack[0].isEmpty() || !stack[1].isEmpty()) {
    		TreeNode current = stack[cur].pop();
    		System.out.print(current.val + " ");
    		if(cur == 0) {
        		//下一层结点
        		if(current.left != null){
        			stack[next].push(current.left);
        		}
        		if(current.right != null){
        			stack[next].push(current.right);
        		}
    		}else{
        		if(current.right != null){
        			stack[next].push(current.right);
        		}
        		if(current.left != null){
        			stack[next].push(current.left);
        		}
    			
    		}
    		if(stack[cur].isEmpty()) {
    			System.out.println();
    			//交换栈
    			cur = 1 - cur;
    			next = 1 - next;
    		}
    	}
    }
    
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	TreeNode node2 = new TreeNode(2);
    	TreeNode node3 = new TreeNode(3);
    	TreeNode node4 = new TreeNode(4);
    	TreeNode node5 = new TreeNode(5);
    	TreeNode node6 = new TreeNode(6);
    	TreeNode node7 = new TreeNode(7);
    	
    	root.left = node2;
    	root.right = node3;
    	node2.left = node4;
    	node2.right = node5;
    	node3.left = node6;
    	node3.right = node7;
    	Print(root);
	}
    
    
}
