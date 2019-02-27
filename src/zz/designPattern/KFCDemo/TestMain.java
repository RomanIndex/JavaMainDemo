package zz.designPattern.KFCDemo;

public class TestMain {
    /**
     * 生产者消费者模式
     *
     * */
    public static void main(String[] args) {

        // 只实例化一个KFC对象，保证每一个服务员和用户在同一个KFC对象内
        KFC kfc = new KFC();

        //实例化4个客户对象
        Customers c1 = new Customers(kfc, "兔子", 3);
        Customers c2 = new Customers(kfc, "老鹰", 4);
        Customers c3 = new Customers(kfc, "蛇", 5);
        Customers c4 = new Customers(kfc, "老鼠", 2);

        //实例化3个服务员对象
        Waiter waiter1 = new Waiter(kfc, "小草", 2);
        Waiter waiter2 = new Waiter(kfc, "大树", 7);
        Waiter waiter3 = new Waiter(kfc, "丛林", 5);

        //让所有的对象的线程都开始工作
        waiter1.start();
        waiter2.start();
        waiter3.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}