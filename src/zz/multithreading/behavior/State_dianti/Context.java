package zz.multithreading.behavior.State_dianti;

/** 
* @author gumx 
* I'm glad to share my knowledge with you all. 
*/  
public class Context {  
    //定义出所有的电梯状态  
    public final static OpenningState openningState = new OpenningState();  
    public final static ClosingState closeingState = new ClosingState();  
    public final static RunningState runningState = new RunningState();  
    public final static StoppingState stoppingState = new StoppingState();  
    /**
     * 定一个当前电梯状态
     * （凡是把 抽象类 定义成 成员变量 的类，都是等待传入一个 继承该抽象类 的实体类 来实现）  《可以理解成，把 形参 定义成 成员变量》
     * 要new this.class 的时候，都要 实现 给 抽象类（实现==必定要有对应的set方法）
     */
    private LiftState liftState;
    
    public LiftState getLiftState() {
        return liftState;
    }
    
    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        //把当前的环境通知到各个实现类中//一键配置完成两个类的初始化
        this.liftState.setContext(this);//这句 赋值 语句，其实提取出来，更容易理解（也是实现状态模式的关键地方）
        System.out.println(liftState);
    }
    
    public void context_open(){
        this.liftState.open();
    }  
    public void context_close(){
        this.liftState.close();  
    }  
    public void context_run(){
        this.liftState.run();  
    }  
    public void context_stop(){
        this.liftState.stop();  
    }  
}