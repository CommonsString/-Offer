package basic.design;


/**
 * 处理者具体实现---技术经理
 */
public class TechnicalManager extends CoRHandler{

	public TechnicalManager(int level) {
		//等级1
		super(1);
	}

	@Override
	public void handler(requestCoR coR) {
		if(coR == null) return;
		System.out.println("技术经理-" + coR.msg + this.getClass().getSimpleName() + " hold不住, 借不了！");
	}
	
}
