package zz.designPattern.learningDemo;

import com.commonEntity.Student;

public class extends_Thread extends Thread{
	
	private String name;

	public extends_Thread(String name) {
		//super();
		this.name = name;
	}
	
	public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

	public static void main(String[] args) throws InterruptedException {
		extends_Thread mTh1 = new extends_Thread("A");
		extends_Thread mTh2 = new extends_Thread("B");
		mTh1.start();
		mTh2.start();
		
		Student obj = new Student();
		obj.wait();
		obj.wait(1000);
		obj.wait(1000, 2);
		obj.notify();
		obj.notifyAll();
		
		/*如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。*/
		Thread thread = new Thread();
		//启动的
		thread.run();//run（）方法是多线程 程序的一个约定。所有的多线程代码都在run方法里面
		thread.start();//start()方法的调用后并不是立即执行多线程代码，而是使得 该线程 变为可运行态（Runnable），什么时候运行是由操作系统决定的
		//作为一个 对象，具有的
		thread.wait();//Object类中的wait()方法，导致当前的线程等待，直到其他线程调用此对象的 notify() 方法或 notifyAll() 唤醒方法。这个两个唤醒方法也是Object类中的方法，行为等价于调用 wait(0) 一样。
		/**
		 * Object类中的notify()方法，唤醒在此对象监视器上等待的单个线程。
		 * 如果所有线程都在此对象上等待，则会选择唤醒其中一个线程。选择是任意性的，并在对实现做出决定时发生。
		 * 线程通过调用其中一个 wait 方法，在对象的监视器上等待。 直到当前的线程放弃此对象上的锁定，才能继续执行被唤醒的线程。
		 * 被唤醒的线程将以常规方式与在该对象上主动同步的其他所有线程进行竞争；例如，唤醒的线程在作为锁定此对象的下一个线程方面没有可靠的特权或劣势。
		 * 
		 * 但有一点需要注意的是notify()调用后，并不是马上就释放对象锁的，而是在相应的synchronized(){}语句块执行结束，自动释放锁后，JVM会在wait()对象锁的线程中随机选取一线程，赋予其对象锁，唤醒线程，继续执行
		 * 类似的方法还有一个notifyAll()，唤醒在此对象监视器上等待的所有线程。
		 */
		thread.notify();
		thread.notifyAll();
		//----线程特有的
		thread.join();//在一个线程中调用other.join(),将等待other执行完后才继续本线程。在当前线程中调用另一个线程的join()方法，则当前线程转入阻塞状态，直到另一个进程运行结束，当前线程再由阻塞转为_就绪状态_
		thread.sleep(1000);//线程睡眠，暂停一段时间，sleep()方法调用目的是不让当前线程独自霸占该进程所获取的CPU资源，以留出一定时间给其他线程执行的机会，当睡眠结束后，就转为就绪（Runnable）状态
		/**
		 * yield()把执行机会让给相同或者更高优先级的线程。当前线程可转让cpu控制权，让别的就绪状态线程运行（切换）
		 * yield()从未导致线程转到等待/睡眠/阻塞状态。在大多数情况下，yield()将导致线程从运行状态转到可运行状态，但有可能没有效果
		 */
		thread.yield();
		thread.interrupt();//后两个函数皆可以被打断，中断某个线程，这种结束方式比较粗暴，如果t线程打开了某个资源还没来得及关闭，也就是run方法还没有执行完就强制结束线程，会导致资源无法关闭
		thread.stop();
		//获取 线程 基本信息
		thread.getPriority();
		thread.setPriority(10);
		thread.isAlive();
		thread.setName("enheng??");
		thread.getName();
		thread.getThreadGroup();
		thread.getId();
		
		/**
		 * 阻塞的情况分三种：
		 * （一）、等待阻塞：运行的线程执行wait()方法，JVM会把该线程放入等待池中。
		 * （二）、同步阻塞：运行的线程在获取对象的同步锁时，若该同步锁被别的线程占用，则JVM会把该线程放入锁池中。
		 * （三）、其他阻塞：运行的线程执行sleep()或join()方法，或者发出了I/O请求时，JVM会把该线程置为阻塞状态。
		 */
		
		/**
		 * Java线程有 优先级，优先级高的线程会获得较多的运行机会
		 * Thread类的setPriority()和getPriority()方法分别用来设置和获取线程的优先级。
		 * 每个线程都有默认的优先级。主线程的默认优先级为Thread.NORM_PRIORITY。
		 * 线程的优先级有继承关系，比如A线程中创建了B线程，那么B将和A具有相同的优先级。
		 */
		
		/**
		 * sleep()和yield()的区别：
		 * sleep()使当前线程进入停滞状态，所以执行sleep()的线程在指定的时间内肯定不会被执行；
		 * yield()只是使当前线程重新回到可执行状态，所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
		 * sleep 方法使当前运行中的线程睡眼一段时间，进入不可运行状态，这段时间的长短是由程序设定的，
		 * yield 方法使当前线程让出 CPU 占有权，但让出的时间是不可设定的。
		 * 实际上，yield()方法对应了如下操作：先检测当前是否有相同优先级的线程处于同可运行状态，如有，则把 CPU  的占有权交给此线程，否则，继续运行原来的线程。
		 * 所以yield()方法称为“退让”，它把运行机会让给了同等优先级的其他线程
		 * 另外，sleep 方法允许较低优先级的线程获得运行机会，但 yield()方法执行时，当前线程仍处在可运行状态，所以，不可能让出较低优先级的线程些时获得 CPU 占有权。
		 * 在一个运行系统中，如果较高优先级的线程没有调用 sleep 方法，又没有受到 I\O 阻塞，那么，较低优先级线程只能等待所有较高优先级的线程运行结束，才有机会运行
		 */
		
		/**
		 * 针对interrupt() 方法：
		 * 要想结束进程最好的办法就是用sleep()函数的例子程序里那样，在线程类里面用以个boolean型变量来控制run()方法什么时候结束，run()方法一结束，该线程也就结束了
		 */
		
		/**
		 * wait和sleep区别
		 * 共同点： 
		 * 1. 他们都是在多线程的环境下，都可以在程序的调用处阻塞指定的毫秒数，并返回。 
		 * 2. wait()和sleep()都可以通过interrupt()方法 打断线程的暂停状态 ，从而使线程立刻抛出InterruptedException。 
		 * 如果线程A希望立即结束线程B，则可以对线程B对应的Thread实例调用interrupt方法。
		 * 如果此刻线程B正在wait/sleep /join，则线程B会立刻抛出InterruptedException，在catch() {} 中直接return即可安全地结束线程。 
		 * 需要注意的是，InterruptedException是线程自己从内部抛出的，并不是interrupt()方法抛出的。
		 * 对某一线程调用 interrupt()时，如果该线程正在执行普通的代码，那么该线程根本就不会抛出InterruptedException。但是，一旦该线程进入到 wait()/sleep()/join()后，就会立刻抛出InterruptedException 。
		 *  
		 *  不同点： 
		 *  1. Thread类的方法：sleep(),yield()等 
		 *     Object的方法：wait()和notify()等
		 *  2. 每个对象都有一个锁来控制同步访问。Synchronized关键字可以和对象的锁交互，来实现线程的同步。 
		 *   sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法。 
		 *  3. wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用 
		 *  4. sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
		 *  
		 *  所以sleep()和wait()方法的最大区别是：
		 *  sleep()睡眠时，保持对象锁，仍然占有该锁；
		 *  而wait()睡眠时，释放对象锁。
		 *  但是wait()和sleep()都可以通过interrupt()方法打断线程的暂停状态，从而使线程立刻抛出InterruptedException（但不建议使用该方法）。
		 */
		
		/**
		 * join()的作用是：“等待该线程终止”，比如 子线程.join();，则主线程要等子线程运行结束后，才会继续执行
		 */
		
	}
	
}
