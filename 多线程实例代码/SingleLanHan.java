package com;

	
/**
 * 懒汉模式：
 * 1, 单例在第一次使用的时候进行创建
 * 2, 单线程环境没有问题，但多线程环境在23-25出现多次调用私有构造函数创建对象，导致线程持有不同的对象。
 * 3, 加入Synchronized实现线程安全, 写法不推荐：带来性能的开发
 */
public class SingleLanHan {
	//构造私有化
	private SingleLanHan() {
		// TODO Auto-generated constructor stub
	}
	//单例对象
	public static SingleLanHan instance = null;
	//通过静态方法返回单例
	public synchronized static SingleLanHan getInsance() {
		if(instance == null) {
			instance = new SingleLanHan();
		}
		return instance;
	}
}
