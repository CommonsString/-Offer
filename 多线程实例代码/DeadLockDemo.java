package com;

/**
 * 死锁的例子
 * @author Administrator
 *
 */
public class DeadLockDemo implements Runnable{
	
	
	public static void main(String[] args) {
		DeadLockDemo t1 = new DeadLockDemo();
		DeadLockDemo t2 = new DeadLockDemo();
		t1.flag = 1;
		t2.flag = 0;
		new Thread(t1).start();
		new Thread(t2).start();
	}

	public int flag = 1;
	// 共享资源
	private static Object o1 = new Object(); 
	private static Object o2 = new Object();
	
	@Override
	public void run() {
		System.out.println("flag: " + flag);
		if(flag == 1) {
			//先获取o1, 在获取o2
			synchronized(o1) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o2) {
					System.out.println("获取o2");
				}
			}
		}
		if(flag == 0) {
			//先获取o2, 在获取o1
			synchronized(o2) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized(o1) {
					System.out.println("获取o1");
				}
			}
		}
	}
}
