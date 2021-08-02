package TesT.test;

import java.util.ArrayList;
import java.util.concurrent.*;

public class One {
    public static void main(String[] args){
        //BlockingDeque是接口
        ArrayList list=null;//数组结构
        LinkedBlockingQueue lbqueue=null;//链表结构
        SynchronousQueue squeue=null;//不存储，单个元素的队列

        //--LinkedBlockingDeque:双端队列  (LinkedBlockingqueque)

        System.out.println("a");//"a".sout加回车

        BlockingQueue<String> bq=new ArrayBlockingQueue<String>(3);
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
    }

}
