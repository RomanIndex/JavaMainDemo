package zz.multithreading.behavior.state;

public class SuccessState implements State {

	@Override
	public void pass(Context c) {
		System.out.println("成功状态，获取会员特权！");
	}

	@Override
	public void refuse(Context c) {
		System.out.println("成功状态下的refuse！");
	}

	@Override
	public void showState() {
		System.out.println("对象此时的状态为：2__成功状态");
	}

}
