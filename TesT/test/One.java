package TesT.test;

import java.util.ArrayList;
import java.util.concurrent.*;

class User {
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

public class One {
    /*
    实际生产生活中呢？
     */
    static void useXC(int a) {
        a = 9;
    }

    //用final修饰形参
    static void useXC1(final int a) {
        //a = 9;
    }

    static void useXC2(User user) {
        user.setUserName("123");
        user = new User();
    }

    static void useXC3(final User user) {
        user.setUserName("123");
        //user = new User();
    }

    public static void main(String[] args) {
        //BlockingDeque是接口
        ArrayList list = null;//数组结构
        LinkedBlockingQueue lbqueue = null;//链表结构
        SynchronousQueue squeue = null;//不存储，单个元素的队列

        //--LinkedBlockingDeque:双端队列  (LinkedBlockingqueque)

        System.out.println("a");//"a".sout加回车

        BlockingQueue<String> bq = new ArrayBlockingQueue<String>(3);
        System.out.println(bq.offer("a"));
        System.out.println(bq.offer("b"));
        System.out.println(bq.offer("c"));
        System.out.println(bq.offer("x"));
        //add()抛出异常，offer()返回false，put()多线程阻塞

        System.out.println(bq.peek());

        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        System.out.println(bq.poll());
        //remove(),poll(),take()

        ttt();
    }

    public static void ttt() {
        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length + 1; i++) {
            System.out.println(i);
        }
    }
}
