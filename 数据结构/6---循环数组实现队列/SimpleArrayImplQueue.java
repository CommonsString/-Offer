package strcut;

/**
 * 
 * @author commonsstring@gmail.com
 * 
 * https://blog.csdn.net/cnd2449294059/article/details/77159466
 * 简单循环数组实现队列
 *  判断队满  : 头指针在队尾指针的下一个位置, 即 start == (end + 1) % capatity
 *          (end + 1) % capatity 意思是： end++
 *  判断队空 ： 即头指针和尾指针在同一位置, 即start == end
 */
class CQueue{
	private int start;
	private int end;
	private int[] data;
	private int capatity;
	
	public CQueue() {
		this.capatity = 10;
		this.start = 0;
		this.end = 0;
		this.data = new int[this.capatity];
	}

	public CQueue(int capatity) {
		this.capatity = capatity;
		this.start = 0;
		this.end = 0;
		this.data = new int[capatity];
	}
	
	//创建队列
	public static CQueue createCQueue(int size){
		return new CQueue(size);
	}
	
	//判空操作
	public boolean isEmpty(){
		return start == end ? true : false;
	}
	
	//返回长度
	public int getLength(){
		return (end - start + capatity) % capatity;
	}
	
	//判满
	public boolean isFull(){
		return start == (end + 1) % capatity ? true : false;
	}
	
	//入队
	public void enQueue(int value){
		//队满, 无法入栈
		if(isFull()){
			throw new RuntimeException("队溢出");
		}else{
			data[end] = value;
			end = (end + 1) % capatity;
		}
	}
	
	//出队
	public int deQueue(){
		//队空, 无法出栈
		if(isEmpty()){
			throw new RuntimeException("队溢出");
		}else{
			int result = data[start];
			start = (start + 1) % capatity; //加一
			return result;
		}
	}
}


public class SimpleArrayImplQueue {
	public static void main(String[] args) {
		CQueue queue = CQueue.createCQueue(5);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.getLength());
	}
}
