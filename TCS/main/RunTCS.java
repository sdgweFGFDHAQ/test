package TCS.main;

import javax.swing.*;
import java.awt.*;

/**
 * 绘制图像
 */
public class RunTCS extends JFrame{


    @Override
    public void paint(Graphics g) {
        super.paint(g);


    }

    public RunTCS(){
        MyWindow mywindow = new MyWindow();

        this.setLocation(200,80);

        this.add(mywindow);
        this.setSize(1060, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public static void main(String[] args) throws NoSuchMethodException{
        new RunTCS();

    }

}
