package zz.multithreading.behavior.Visitor;

public class SumVisitor implements Visitor{
	
	private int totalBachelor;
	
	public int getTotalBachelor() {
		return totalBachelor;
	}

	/*public void setTotalBachelor(int totalBachelor) {
		this.totalBachelor = totalBachelor;
	}*/

	SumVisitor(){
        super();
        totalBachelor = 0;
    }

	@Override
	public void visit(Bachelor bachelor) {
		// TODO Auto-generated method stub
		totalBachelor++;//需求：只用统计Bachelor。。。
	}

	@Override
	public void visit(College college) {
		// TODO Auto-generated method stub
		
	}

}
