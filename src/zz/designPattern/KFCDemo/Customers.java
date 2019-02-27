package zz.designPattern.KFCDemo;

public class Customers extends Thread {
	KFC kfc;
	int size;

	//KFC要传入，保证每一个服务员和用户在同一个KFC对象内
	public Customers(KFC kfc, String name, int size) {
		super(name);//为当前线程设定 特定名称（就这么用的，还有别的方式？）
		this.kfc = kfc;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			kfc.consume(size);
		}
	}

}
