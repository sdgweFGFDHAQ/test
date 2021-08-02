package TesT.use_Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadLocked{
    public static int a=0;

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        ThreadLocked.a = a;
    }

    public static class T1 extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("线程1被使用");
        }
    }
    public void t1() {
        T1 t1= new T1();
        t1.start();
    }

    public static class T2 implements Runnable {
        @Override
        public void run() {
            System.out.println("线程2被使用");
        }

    }
    public void t2() {
        Thread thread1=new Thread(new T2());
        thread1.start();
    }

    public static class T3 implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("有返回值的Callable");
            Thread.sleep(1000);
            return "程序启动";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ThreadLocked threadLocked=new ThreadLocked();
//        threadLocked.t1();
//        threadLocked.t2();

//        new Thread(() -> System.out.println("匿名内部类1")).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名内部类2");
//            }
//        }).start();

        FutureTask f3=new FutureTask(new T3());
        Thread thread3=new Thread(f3);
        thread3.start();
        System.out.println(f3.get());
        

    }

}
