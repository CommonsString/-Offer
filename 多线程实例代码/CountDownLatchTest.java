package com;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  
 * CountDownLatch
 * 计数器：
 * 在所有线程完成工作后，在执行跑起来代码
 */
public class CountDownLatchTest {

	
	//定义计数
	public final static int count = 200;
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService pool = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(count);
		for(int i = 0; i < count; i++){
			final int num = i;
			pool.execute(() -> {
				test(num);
				//计数减1
				latch.countDown();
			});
		}
		//等待所有线程
		latch.await();
		System.out.println("跑起来！");
	}
	
	public static void test(int val){
		try {
			Thread.sleep(100);
			System.out.println(val);
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
