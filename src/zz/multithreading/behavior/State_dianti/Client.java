package zz.multithreading.behavior.State_dianti;

/** 
* @author gumx 
* I'm glad to share my knowledge with you all. 
* 模拟电梯的动作 
*/  
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        LiftState eachState = new ClosingState();
        context.setLiftState(eachState);
        //context.setLiftState(new OpenningState());
        context.context_open();
        context.context_close();
        context.context_run();
        context.context_stop();
        context.context_open();
        context.context_close();
        context.context_run();
        context.context_stop();
    }
}
