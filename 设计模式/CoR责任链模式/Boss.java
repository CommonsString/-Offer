package basic.design;

/**
 * 处理者具体实现---技术经理
 */
public class Boss extends CoRHandler {

	public Boss(int level) {
		super(2);
	}
	@Override
	public void handler(requestCoR coR) {
		if(coR == null) return;
		System.out.println("老板-" + coR.msg + this.getClass().getSimpleName() + " 小钱, 借！");
	}
}
