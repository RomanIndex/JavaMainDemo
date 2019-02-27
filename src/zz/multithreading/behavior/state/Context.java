package zz.multithreading.behavior.state;

/**
 * 申请流程：无效状态--报名--审核--通过
 */
public class Context{
	//环境类中维护了一个State对象，它是定义了当前的状态。
	private State state;
	
	public Context(State state) {
        super();
        this.state = state;
    }
	
	//setState是用来改变state的状态 使用setState实现状态的切换
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public void doPass() {
		//状态的切换的细节部分,在本例中是颜色的变化,已经封装在子类的pass中实现,这里无需关心
		state.pass(this);
		/*//假设sample要使用state中的一个切换结果,使用getColor()
		Sample sample = new Sample(state.getState());
		sample.operate();*/
	}
	
	public void doRefuse(){
		state.refuse(this);
		/*//假设sample要使用state中的一个切换结果,使用getColor()
		Sample sample = new Sample(state.getState());
		sample.operate();*/
	}
}
