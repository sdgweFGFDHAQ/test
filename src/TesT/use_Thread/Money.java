package TesT.use_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Put_Money {
    private double mmoney;

    public void despoit(double money) {
        double new_money = mmoney + money;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mmoney = new_money;
    }

    public double getMnumber() {
        return mmoney;
    }


}


class MoneyThread implements Runnable {
    private Put_Money money;
    private Double m;

    public MoneyThread(Put_Money put_money, double i) {
        this.money = put_money;
        this.m = i;
    }

    public Put_Money getMoney() {
        return money;
    }

    public Double getM() {
        return m;
    }

    @Override
    public void run() {
        money.despoit(m);
    }
}

public class Money {
    public static void main(String[] args) {
        Put_Money put_money = new Put_Money();
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 1; i <= 100; i++) {
            service.execute(new MoneyThread(put_money, 1));
        }

        service.shutdown();

        while (!service.isTerminated()) {
            System.out.println("账户余额: " + put_money.getMnumber());
        }


    }

}