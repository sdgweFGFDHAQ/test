package TesT.use_Thread;

import java.util.Stack;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author zzx
 * @Date 2022/2/17 15:32
 * @Description IntelliJ IDEA
 **/
public class Others {
    public static int a = 1;

    public void t() {
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);

        int a = s.peek();
        int b = s.pop();
        int c = s.pop();
        int d = s.peek();
        System.out.println(a + "0" + b + "0" + c + "0" + d);
    }

    void pool(){
        a += 1;
        System.out.println(a);
    }

    public static void main(String[] args) throws InterruptedException {
        Others o = new Others();
        o.t();
        Executor executor = Executors.newFixedThreadPool(5);
        while (true){
            CountDownLatch latch = new CountDownLatch(2);
            executor.execute(()->{
                o.pool();
                latch.countDown();});
            latch.await();
        }


    }
}

//
//    // 订单队列
//    Vector<P> pos;
//    // 派送单队列
//    Vector<D> dos;
//    // 执行回调的线程池
//    Executor executor =
//            Executors.newFixedThreadPool(1);
//    final CyclicBarrier barrier =
//            new CyclicBarrier(2, ()->{
//                executor.execute(()->check());
//            });
//
//    void check(){
//        P p = pos.remove(0);
//        D d = dos.remove(0);
//        // 执行对账操作
//        diff = check(p, d);
//        // 差异写入差异库
//        save(diff);
//    }
//
//    void checkAll(){
//        // 循环查询订单库
//        Thread T1 = new Thread(()->{
//            while(存在未对账订单){
//                // 查询订单库
//                pos.add(getPOrders());
//                // 等待
//                barrier.await();
//            }
//        });
//        T1.start();
//        // 循环查询运单库
//        Thread T2 = new Thread(()->{
//            while(存在未对账订单){
//                // 查询运单库
//                dos.add(getDOrders());
//                // 等待
//                barrier.await();
//            }
//        });
//        T2.start();
//    }