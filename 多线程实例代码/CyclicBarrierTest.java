package com;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
	
	
	//定义计数
	public final static int count = 10;
	
	//等待线程数
	public static CyclicBarrier ba = new CyclicBarrier(5, () -> {
		//线程达到屏障, 有限执行该代码
		System.out.println("优先执行！");
	});
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i = 0; i < count; i++){
			final int num = i; 
			Thread.sleep(1000);
			pool.execute(() -> {
				say(num);
			});
		}
	}
	
	private static void say(int val) {
		try {
			Thread.sleep(1000);
			System.out.println("准备--> " + val);
			//等待线程达到, 初始化数目继续执行 
//			ba.await();
			ba.await(5, TimeUnit.SECONDS);
			System.out.println("准备好了！");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
