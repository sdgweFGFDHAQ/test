package TesT.draw;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class jpanel extends JPanel implements KeyListener {
    static String direction = "right";

    public static void setDirection(String direction) {
        jpanel.direction = direction;
    }

    public String getDirection() {
        return direction;
    }



    //画布
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jpanel.setDirection("up");
            System.out.println("key-"+this.getDirection());
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jpanel.setDirection("down");
            System.out.println("key-"+this.getDirection());
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jpanel.setDirection("left");
            System.out.println("key-"+this.getDirection());
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jpanel.setDirection("right");
            System.out.println("key-"+this.getDirection());
        } else {
            System.out.println(e.getKeyCode() + "键被敲击");
        try {
            Method declaredMethod = this.getClass().getDeclaredMethod(this.getDirection());
            declaredMethod.invoke(this);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void up() {
        System.out.println("调用了up函数");
    }

    public void down() {
        System.out.println("调用了down函数");
    }

    public void left() {
        System.out.println("调用了left函数");
    }

    public void right() {
        System.out.println("调用了right函数");
    }


    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        JFrame frame = new JFrame("SKey");
        jpanel jp = new jpanel();

        frame.add(jp);
        frame.addKeyListener(jp);

        frame.setSize(400, 400);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Thread thread = new Thread();
//        thread.start();
//        try {
//            Method declaredMethod = jp.getClass().getDeclaredMethod(jp.getDirection());
//            declaredMethod.invoke(jp);
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException illegalAccessException) {
//            illegalAccessException.printStackTrace();
//        }
//        Thread.sleep(1000);

    }


}
