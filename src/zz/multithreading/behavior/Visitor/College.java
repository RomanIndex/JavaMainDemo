package zz.multithreading.behavior.Visitor;

public class College extends Student{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
