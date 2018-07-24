package basic.design;


/**
 * @author commonsstring@gmail.com
 * 责任链模式
 * 抽象处理者
 */
class requestCoR{
	//请求等级
	int level;
	//需求
	String msg;
	public requestCoR(int level, String msg) {
		this.level = level;
		this.msg = msg;
	}
}
public abstract class CoRHandler {
	//定义下一个处理者
	private CoRHandler nextHandler;
	//处理者等级
	private int level;
	public CoRHandler(int level) {
		this.level = level;
	}
	
	//处理下一个处理着
	public void setNextHandler(CoRHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	//处理函数
	public abstract void handler(requestCoR coR);

	//处理请求--或传递, final不可重写
	public final void handleMessage(requestCoR coR){
		//判断等级, this指运行时对象, 当前处理者
		if(this.level == coR.level){
			//级别相同, 直接调用处理函数
			this.handler(coR);
		}else{
			//判断是否有高级处理者
			if(this.nextHandler != null){
				System.out.println("请求传递");
				this.nextHandler.handleMessage(coR);
			}else{
				System.out.println("已是最高级别!");
			}
		}
	}
	
}
