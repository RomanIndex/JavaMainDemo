package zz.multithreading.behavior.state;

public class ExamineState implements State {

	@Override
	public void pass(Context c) {
		System.out.println("审核成功，通过状态！");
		c.setState(new SuccessState());
	}

	@Override
	public void refuse(Context c) {
		System.out.println("审核失败，保存报名状态！");
		c.setState(new RegisterState());
	}

	@Override
	public void showState() {
		// TODO Auto-generated method stub

	}

}
