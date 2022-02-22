package TesT.use_Thread;

/*
synchronized的使用
修饰实例方法，对当前实例对象加锁
修饰静态方法，对当前类的Class对象加锁
修饰代码块，对synchronized括号内的对象加锁
*/
public class ThreadRun {
    public static void main(String[] args) throws InterruptedException{
        ThreadRun thread =new ThreadRun();
        thread.test();
    }

    public void test() throws InterruptedException{
        new tthread().start();
        new tthread().start();
    }

    public void show(String username) throws Exception{
        synchronized (username){
            System.out.println("唤起"+username);
            java.lang.Thread.sleep(3000);
            System.out.println("结束"+username);
        }

        System.out.println("0唤起" + username);
        java.lang.Thread.sleep(3000);
        System.out.println("0结束" + username);

    }

    class tthread extends java.lang.Thread {
        public void run(){
            try{
                show("asd");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
