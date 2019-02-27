package zz.multithreading.behavior.state;

public class RegisterState implements State{

	@Override
	public void pass(Context c) {
		System.out.println("报名成功！进入审核");
		c.setState(new ExamineState());
	}

	@Override
	public void refuse(Context c) {
		System.out.println("报名失败！撤回资格");
		c.setState(new InvalidState());
	}

	@Override
	public void showState() {
		System.out.println("对象此时的状态为：1__报名状态");
	}

}
