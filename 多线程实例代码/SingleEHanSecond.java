package com;

public class SingleEHanSecond {
	// 构造私有化
	private SingleEHanSecond() {
		
	}
	public static SingleEHanSecond instance = null;
	static {
		instance = new SingleEHanSecond(); 
	}
	// 单例对象
	// 通过静态方法返回单例
	public static SingleEHanSecond getInsance() {
		return instance;
	}
}
