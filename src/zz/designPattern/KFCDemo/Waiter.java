package zz.designPattern.KFCDemo;

public class Waiter extends Thread {
	KFC kfc;
	int size;

	// KFC要传入，保证每一个服务员和用户在同一个KFC对象内
	public Waiter(KFC kfc, String name, int size) {
		super(name);
		this.kfc = kfc;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			kfc.produce(size);
		}

	}
}
