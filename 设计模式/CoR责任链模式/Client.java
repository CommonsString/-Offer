package basic.design;


/**
 * 客户端-请求者
 *
 */
public class Client {
	
	public static void main(String[] args) {
		requestCoR request1 = new requestCoR(1, "借款100元！");
		requestCoR request2 = new requestCoR(2, "借款200元！");
		
		TechnicalManager minChao = new TechnicalManager(1);
		Boss liMin = new Boss(2);
		//设置下一级
		minChao.setNextHandler(liMin);
		System.out.println("================");
		minChao.handleMessage(request1);
		minChao.handleMessage(request2);
	}
}
