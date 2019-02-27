package zz.multithreading.behavior.Visitor;

import java.util.ArrayList;

public class VisitorMain {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
        Bachelor bachelor = new Bachelor();
        bachelor.setName("llin");
        bachelor.setRating("100");
        bachelor.setUniversity("Tianjin University");

        College college = new College();
        college.setUniversity("Tianjin college");
        college.setRating("1");
        college.setName("dalinge");

        list.add ( bachelor );
        list.add ( college );

      /**
       * visitor一直是个空对象，传递（承载作用、货车（具体的student 实现类 就是货物））
       * 在 student 实现类 里面起  选择作用（根据构造函数入参）
       */
        Visitor showVisitor = new ShowVisitor();//而且，不同的功能，可以new 不同的visitor实例
        
        Visitor sumVisitor = new SumVisitor();
        
        for ( Student student : list ){
            //student.accept(showVisitor);
            //student.accept(sumVisitor);
        }
        
        //双分派:双分派意味着得到执行的操作决定于 请求的种类 和 接收者的类型 。正对应于访问者模式。
        bachelor.accept(showVisitor);
        bachelor.accept(sumVisitor);//bachelor（人） 先选择 车，车 再根据 人 的类型，决定 把人 送去 哪里
        System.out.println( "The total sum of bachelors : "+ ((SumVisitor)sumVisitor).getTotalBachelor());

	}

}
