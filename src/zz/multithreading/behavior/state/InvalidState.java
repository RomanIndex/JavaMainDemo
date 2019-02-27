package zz.multithreading.behavior.state;

public class InvalidState implements State {

	@Override
	public void pass(Context c) {
		System.out.println("发起报名申请！");
		c.setState(new RegisterState());
	}

	@Override
	public void refuse(Context c) {
		System.out.println("无效状态。。。");
	}

	@Override
	public void showState() {
		System.out.println("对象此时的状态为：0__无效状态");
	}

}
