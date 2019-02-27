package zz.multithreading.behavior.state;

public class Sample {
	private String id;
	
	private String name;
	
	//加入state对象，可以通过state控制该对象的状态（状态决定行为）
	private State state;

	public Sample(Object state) {
		System.out.println("Sample name:" + name);
		//System.out.println("对应的状态："this.state);
	}

	public void operate() {
		System.out.println(name + "的----operate");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
