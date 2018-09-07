package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	//定义计数
	public final static int count = 200;
	
	public static void main(String[] args) throws Exception {
		ExecutorService pool = Executors.newCachedThreadPool();
		//运行20个线程访问, 并发数
		final Semaphore sem = new Semaphore(20);
		for(int i = 0; i < count; i++){
			final int num = i;
			pool.execute(() -> {
				if(sem.tryAcquire()) { //尝试获取一个许可
					test(num);
					sem.release();
				}
			});
		}
		//关闭线程池
		pool.shutdown();
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
