package com;

/**
 * 饿汉模式：
 * 1, 单例不是第一次使用时创建，而是在类装载的时候进行创建。
 * 2, 类装载创建, 即保证线程安全
 * 3, 不足: 构造方法存在过多的处理, 导致类加载速度变慢
 * @author Administrator
 */
public class SingleEHan {
	//构造私有化
	private SingleEHan() {
	}
	//单例对象
	public static SingleEHan instance = new SingleEHan();
	//通过静态方法返回单例
	public static SingleEHan getInsance() {
		return instance;
	}
}
