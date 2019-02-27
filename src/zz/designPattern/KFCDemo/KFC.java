package zz.designPattern.KFCDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KFC {

	// 食物的种类
	String[] names = { "薯条", "烧板", "鸡翅", "可乐" };

	// 生产的最大值，到达后可以休息
	static final int Max = 20;

	// 存放食物的集合
	List<Food> foods = new ArrayList<Food>();

	// 生产食物的方法
	/*public void produce(int index) {
		String threadName = Thread.currentThread().getName();
		synchronized (this) {
			// 如果食物数量大于20
			while (foods.size() + index > Max) {
				System.out.println("食材够了，"+ threadName +"  生产失败！数量："+ index);
				//this.notifyAll();// 这个唤醒是针对生产者和消费者，有all
				try {
					//Thread.sleep(2000);//仍然占有该对象锁
					this.wait();//释放对象锁， 这个唤醒是针对生产者，没有all
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 开始生产食物食物//有一点要注意的
			//System.out.println("开始生产食物");
			for (int i = 0; i < index; i++) {
				Food food = new Food(names[(int) (Math.random() * 4)]);// 随机产生四种食物中的一种666
				foods.add(food);
				//System.out.println(threadName +"生产了" + food.getName() + "，总食物已有：" + foods.size());
			}
			System.out.println(threadName +"生产了：" + index + "，总食物已有：" + foods.size());
			this.notifyAll();// 这个唤醒是针对生产者和消费者，有all
		}
	}

	*//**
	 * 在java中一个对象，会有两个池（锁池，等待池），
	 * 如果一个线程调用了wait方法，那么该线程进入该对象的等待池中（释放锁），
	 * 如果未来的某一刻，另外一个线程调用了这个对象的notify方法，或者notifyAll,那么在等待池中的线程就会起来进入该对象的锁池中，参与到获取锁的竞争当中，
	 * 如果获取锁成功，将沿着wait方法 之后 的代码执行（这就是为什么生产者消费者中，使用while来判断状态，而不是if）
	 *//*
	// 消费食物的方法
	public void consume(int index) {
		String threadName = Thread.currentThread().getName();
		synchronized (this) {
			while (foods.size() < index) {
				System.out.println("食材不够了，"+ threadName +"  消费失败！数量："+ index);
				//this.notifyAll();// 这个唤醒是针对生产者和消费者，有all
				try {
					//Thread.sleep(2000);
					this.wait();// 这个唤醒是针对消费者，没有all
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 足够消费
			//System.out.println("开始消费");
			for (int i = 0; i < index; i++) {
				Food food = foods.remove(foods.size() - 1);
				//System.out.println(threadName +"消费了一个" + food.getName() + "，总食物还剩：" + foods.size());
			}
			System.out.println(threadName +"消费了：" + index + "，总食物还剩：" + foods.size());
			this.notifyAll();
		}
	}*/
	
	/**
	 * 另一种
	 */
	private final int MAX_SIZE = 20;
	// 仓库存储的载体
	private LinkedList<Object> list = new LinkedList<>();

	// 生产产品
	public void produce(int num) {
		// 同步
		synchronized (list) {
			String threadName = Thread.currentThread().getName();
			// 仓库剩余的容量不足以存放即将要生产的数量，暂停生产
			while (list.size() + num > MAX_SIZE) {
				System.out.println(threadName +"【即将生产的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t生产失败!");
				try {
					// 条件不满足，生产阻塞
					//Thread.sleep(2000);
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < num; i++) {
				list.add(new Object());
			}
			System.out.println(threadName +"【成功生产产品数】:" + num + "\t【现仓储量为】:" + list.size());
			//在编程中，尽量在使用了notify/notifyAll() 后 立即 退出临界区，以唤醒其他线程
			list.notifyAll();
		}
	}

	// 消费产品
	public void consume(int num) {
		synchronized (list) {
			String threadName = Thread.currentThread().getName();
			// 不满足消费条件
			while (num > list.size()) {
				System.out.println(threadName +"【即将消费的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t消费失败!");
				try {
					//Thread.sleep(2000);
					list.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 消费条件满足，开始消费
			for (int i = 0; i < num; i++) {
				list.remove();
			}
			System.out.println(threadName+ "【成功消费产品数】:" + num + "\t【现仓储量为】:" + list.size());
			list.notifyAll();
		}
	}

}