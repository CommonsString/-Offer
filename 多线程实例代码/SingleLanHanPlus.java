package com;
/**
 * 懒汉模式：
 * 1, 单例在第一次使用的时候进行创建
 * 2, 单线程环境没有问题，但多线程环境在23-25出现多次调用私有构造函数创建对象，导致线程持有不同的对象。
 * 3, 加入Synchronized实现线程安全, 写法不推荐：带来性能的开发
 * 4, 加入双重检查机制 + synchronized = 双重同步锁单例模式
 */
public class SingleLanHanPlus {
	
	//构造私有化
	private SingleLanHanPlus() {
		// TODO Auto-generated constructor stub
	}
	
	
	/*
	 * 线程不安全原因：CPU层面
	 * 执行instance = new SingleLanHanPlus(), 为操作
	 * 1，分配内存空间
	 * 2, 初始化对象
	 * 3, 设置instance指向刚分配的内存
	 * 单线程环境, 指令重排对以上3步无影响
	 * 多线程环境：
	 * 	JVM和CPU优化, 发生指令重排变成 1， 3， 2
	 * 解决方案 ： 使用volatile修饰实例对象, 禁止指令重排序
	 */
	//单例对象
	public volatile  static SingleLanHanPlus instance = null;
	//通过静态方法返回单例
	public static SingleLanHanPlus getInsance() {
		if(instance == null) {
			synchronized(SingleLanHanPlus.class) {
				//线程发现instance不为null, 直接返回
				if(instance == null){
					instance = new SingleLanHanPlus();
				}
			}
		}
		return instance;
	}
	

}
