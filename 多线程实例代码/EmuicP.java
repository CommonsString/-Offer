package com;


/**
 * 枚举模式：最安全的。
 * 使用枚举实现获取单例对象
 * 推荐写法
 * @author Administrator
 *
 */
public class EmuicP {
	private EmuicP() {
	}
	public static EmuicP getInstance(){
		return Singleton.INSTANCE.getInstance();
	}
	private enum Singleton{
		// 值可以调用方法
		INSTANCE;
		private EmuicP instance;
		// JVM保证只调用一次
		Singleton() {
			instance = new EmuicP();
		}
		public EmuicP getInstance(){
			return instance;
		}
	}
	
}
