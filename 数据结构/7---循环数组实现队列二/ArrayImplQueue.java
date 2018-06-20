package strcut;


/**
 * 
 * @author commonsstring@gmail.com
 * 
 * 固定数组实现队列
 * end : 表示, 如果新加了一个数, 我应该放在哪个位置上
 * start : 表示, 我要拿取一个数, 我应该冲那个位置上拿过来
 * size : 数组大小
 * 初始： start = end = size = 0
 */

class MQueue{
	private int start;
	private int end;
	private int size;
	private int[] data;
	
	public MQueue(int size) {
		if(size < 0){
			throw new RuntimeException("违法参数！");
		}
		this.size = 0;
		this.end = 0;
		this.size = size;
		this.data = new int[size];
	}
	
	public MQueue() {
		this.size = 0;
		this.end = 0;
		this.size = 0;
		//默认大小为10
		this.data = new int[10];
	}
	
	//入队
	public void enQueue(int value){
		//当end == 数组长度的时候, 无法入队
		int len = data.length;
		if(size == len){
			throw new RuntimeException("队满, 无法入队！");
		}
		size++;
		data[end] = value;
		//判断end, 是否到达下标最大值
		end = end == len - 1 ? 0 : end + 1;
	}
	
	//出队
	public int deQueue(){
		if(size == 0){
			throw new RuntimeException("队空, 无法出栈!");
		}
		size--;
		int temp = start;
		//判断end, 是否到达数组下标最大值
		start = start == data.length - 1 ? 0 : start + 1;
		return data[temp];
	}
}
public class ArrayImplQueue {
	public static void main(String[] args) {
		MQueue queue = new MQueue();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}
