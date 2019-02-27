package zz.multithreading.behavior.Visitor;

public class ShowVisitor implements Visitor{

	@Override
	public void visit(Bachelor bachelor) {
		System.out.println("A bachelor\n");
		//TODO 可能会有一些特异的操作，定义在函数里面（我们为了简单就省略了）
		this.printMessage( bachelor );
	}

	@Override
	public void visit(College college) {
		System.out.println(" a college student!\n");
        //TODO 同上
        this.printMessage( college );
	}
	
	//共同的操作，可以定义在外面
	public void printMessage ( Student student ){
        System.out.println( "Name : " + student.getName()+"\n"
                + "University : " + student.getUniversity()+"\n"
                + "Rating : " + student.getRating() + "\n"
        );
    }

}
