package haikanweish;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 1
 * @Date 2021/9/16
 * @Description IntelliJ IDEA
 **/
public class Main {
    private volatile static int count = 0;
    private volatile static boolean flag = true;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            while (count < 100){
                if(flag){
                    System.out.println("偶数:" + count++);
                    flag = false;
                }
            }
        });
        executorService.execute(()->{
            while (count < 100){
                if(!flag){
                    System.out.println("奇数:" + count++);
                    flag = true;
                }
            }
        });
        executorService.shutdown();
    }
}
