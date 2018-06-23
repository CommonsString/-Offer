package strcut;

/**
 * @author commonsstring@gmail.com
 * 
 * 固定数组实现栈
 * 
 */
class myStack{
	private int[] date;   //栈元素
	private int top;      //栈顶指针
	private int capacity; //容量
	public myStack() {
		this.capacity = 1;
		this.date = new int[this.capacity];
		this.top = -1;
	}
	public myStack(int capacity) {
		this.capacity = capacity;
		this.date = new int[capacity];
		this.top = -1;		
	}

	//入栈
	public void push(int value){
		//满栈, 不能做入栈操作
		if(isStackFull()){
			System.out.println("容量不足, 无法入栈！");
			return ;
		}else{
			this.date[++this.top] = value;
		}
	}
	
	//返回, 并删除栈顶元素
	public int pop(){
		//空栈, 无法出栈
		if(isEmpty()){
			System.out.println("栈内无元素, 无法弹出！");
			return -1;
		}else{
			return this.date[this.top--];
		}
	}
	
	//返回, 最后入栈元素, 但不删除
	public int top(){
		//空栈, 无法出栈
		if(isEmpty()){
			System.out.println("栈内无元素, 无法弹出！");
			return -1;
		}else{
			return this.date[this.top - 1];
		}		
	}
	
	//空栈判断
	public boolean isEmpty(){
		return this.top == -1 ? true : false;
	}
	
	//返回大小
	public int size(){
		return this.top == -1 ? 0 : this.top + 1;
	}
	
	//判断栈存满
	public boolean isStackFull(){
		return this.capacity == this.top + 1 ? true : false;
	}
	
	//删除栈
	public void clear(){
		this.top = -1;
	}
	
}
public class SimpleArrayImplStack {
	public static void main(String[] args) {
		myStack stack = new myStack(10);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
