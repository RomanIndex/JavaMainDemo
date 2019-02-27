package zz.designPattern.learningDemo;

public class implements_Runnable implements Runnable{
	private String name;

	public implements_Runnable(String name) {
		this.name=name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
            	Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void main(String[] args) {
		new Thread(new implements_Runnable("C")).start();
		new Thread(new implements_Runnable("D")).start();
	}

}
