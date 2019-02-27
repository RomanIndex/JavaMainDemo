package zz.multithreading.behavior.Visitor;

public class Bachelor extends Student{

	@Override
	public void accept(Visitor visitor) {
		visitor.visit( this );
	}

}
