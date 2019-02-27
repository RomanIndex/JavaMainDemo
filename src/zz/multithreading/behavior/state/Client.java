package zz.multithreading.behavior.state;

public class Client {
	public static void main(String[] args) {
		Context con = new Context(new InvalidState());
		System.out.println(con.getState());
		con.doPass();
		//System.out.println(con.getState().showState());
	}

}
