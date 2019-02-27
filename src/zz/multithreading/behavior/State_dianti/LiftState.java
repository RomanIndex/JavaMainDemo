package zz.multithreading.behavior.State_dianti;

/** 
* @author gumx 
* ****抽象类，更像是一组“不完美”的实体类，可以根据继承方向，决定它成为哪种 具体的 类
* ----接口，更像是一组 方法（将要用到、却等具体实现的） 的集合
* 定义一个电梯的接口 
*/  
public abstract class LiftState{
    
	/**
	 * 定义一个 环境角色，也就是封装状态的变换引起的功能变化 
	 * 把该 抽象类 分配 给某一个 “环境角色”，
	 * --->>>当 new环境角色 时（且已经在 环境角色 里面实现 该抽象类），所以可以在 环境角色 里调用该 抽象类
	 * ------------------------------->>其实就是，在环境角色 里 调用，具体 实现类 里面 的，下面 定义的 方法的具体实现
	 * 抽象类，就是 供一眼看到实现类有哪些方法的集合，（但extends是单一的，但implement可以是多个）
	 * ***重要作用：给 子类 提供一个修改 “环境角色” 的入口
	 */
	protected Context context;
    private static int count = 0;
    
    public void setContext(Context _context){
    	System.out.println("abstract LiftState setContext："+ this.count++);
        this.context = _context;
    }
	
    //首先电梯门开启动作  
    public abstract void open();
    //电梯门有开启，那当然也就有关闭了  
    public abstract void close();
    //电梯要能上能下，跑起来  
    public abstract void run();
    //电梯还要能停下来，停不下来那就扯淡了  
    public abstract void stop();
}