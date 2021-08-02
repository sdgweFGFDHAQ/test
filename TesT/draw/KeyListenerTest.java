package TesT.draw;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


@SuppressWarnings("serial")
public class KeyListenerTest extends JFrame {

    public KeyListenerTest() throws NoSuchMethodException{
        MyWindow mywindow = new MyWindow();
        this.add(mywindow);
        this.addKeyListener(mywindow);// 注册监听器
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public static void main(String[] args) throws NoSuchMethodException{
        new KeyListenerTest();

    }
}

@SuppressWarnings("serial")
class MyWindow extends JPanel implements KeyListener {
    private String dir="ActionUp";

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    // 按键监听器
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode()+"键被敲击");
        String dir = this.getDir();
        System.out.println(dir);
    }

    // 释放监听器
    @Override
    public void keyReleased(KeyEvent e) {}
}

