package TesT.Invoke;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class SneckEat {
    static String s1="HH:mm:ss";
    static SimpleDateFormat sdf=new SimpleDateFormat(s1);
    static int[][] ar=new int[5][5];

    public void Change() {
        int b=0;
        for(int i=0;i<5;i++) {
            if(ar[i][2]==1){
                b=i;
            }
        }
        if(b!=4) {
            ar[b + 1][2] = ar[b][2];
            ar[b][2] = 0;
        }
        else{
            ar[0][2]=ar[b][2];
            ar[b][2]=0;
        }
    }

    public void Draw() {
        for(int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(ar[i][j]+" ");
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        String s2 = sdf.format(System.currentTimeMillis());
        System.out.println(s2);
        SneckEat.ar[0][2]=1;
        timer.schedule(new MT(), 2000,1000);
    }

}
class MT extends TimerTask{

    @Override
    public void run() {
        String s3=SneckEat.sdf.format(System.currentTimeMillis());
        System.out.println(s3);
        SneckEat se=new SneckEat();
        se.Draw();
        se.Change();
    }
}

//import java.text.SimpleDateFormat;
//        import java.util.Timer;
//        import java.util.TimerTask;
///**
// * Java计时器
// */
//public class TimerTest {
//    static String str="HH:mm:ss";
//    static SimpleDateFormat dateFormat = new SimpleDateFormat(str);
//
//    public static void main(String[] args) {
//        Timer timer = new Timer();
//        String now1 = dateFormat.format(System.currentTimeMillis());
//        System.out.println(now1);
//        //延迟3秒后执行任务
//        timer.schedule(new MyTask(),3000);//单位是毫秒
//    }
//}
//class MyTask extends TimerTask{
//    @Override
//    public void run() {
//        System.out.println("该起床了");
//        String now2 = TimerTest.dateFormat.format(System.currentTimeMillis());
//        System.out.println(now2);
//    }
//}
