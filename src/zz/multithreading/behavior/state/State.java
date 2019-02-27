package zz.multithreading.behavior.state;

public interface State {
	public void pass(Context c);
	
	public void refuse(Context c);
	
	public void showState();

}
