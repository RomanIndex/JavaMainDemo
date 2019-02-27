package zz.multithreading.behavior.State_dianti;

/** 
* @author gumx 
* I'm glad to share my knowledge with you all. 
* 在停止状态下能做什么事情 
*/  
public class StoppingState extends LiftState {  
    //停止状态关门？电梯门本来就是关着的！  
    @Override  
    public void close() {  
        //do nothing;  
    }  
    //停止状态，开门，那是要的！  
    @Override  
    public void open() {
        super.context.setLiftState(Context.openningState);//通过父类的protected Context context; 改变了”环境角色“的状态（体会父类Content的作用何在？）
        super.context.getLiftState().open();//super.context.getLiftState()：另一个具体的状态类了，即调用另一个状态类的open()方法
    }  
    //停止状态再跑起来，正常的很  
    @Override  
    public void run() {  
        super.context.setLiftState(Context.runningState);  
        super.context.getLiftState().run();  
    }  
    //停止状态是怎么发生的呢？当然是停止方法执行了  
    @Override  
    public void stop() {  
        System.out.println("电梯停止了...");  
    }
}
