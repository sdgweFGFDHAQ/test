package 玄武科技;

import java.util.concurrent.Semaphore;

/**
 * @Author 1
 * @Date 2021/9/17
 * @Description IntelliJ IDEA
 **/
public class Main {

    static Semaphore a = new Semaphore(1);
    static Semaphore b = new Semaphore(0);
    static int n = 0;

    public void test() {

    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    a.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n);
                n++;
                b.release();
            }).start();

            new Thread(() -> {
                try {
                    b.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(n);
                n++;
                a.release();
            }).start();
        }
    }

}
