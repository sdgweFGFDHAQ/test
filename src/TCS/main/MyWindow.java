package TCS.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * 添加画布和键盘监听
 */
public class MyWindow extends JPanel implements KeyListener, ActionListener {
    //创建对象、调用必要的资源
    int[] codex;
    int[] codey;
    int[] snakex;
    int[] snakey;
    int length;
    int foodx;
    int foody;
    int scores = 0;
    boolean game_run = false;
    boolean isVictory = false;
    boolean isFail = false;

    ChangeDir changeDir = new ChangeDir();
    Random random = new Random();
    ImageIcon image_head = new ImageIcon();
    ImageIcon image_body = new ImageIcon();
    ImageIcon image_food = new ImageIcon();
    Timer timer = new Timer(600, this);

    public MyWindow() {
        init();
        this.setFocusable(true);
        this.addKeyListener(this);// 注册监听器
        timer.start();
    }

    public void init() {
        length = Constant.LENGTH;
        scores = 0;
        codex = new int[100];
        codey = new int[100];
        codex[0] = Constant.START_X;
        codey[0] = Constant.START_Y;
        codex[1] = codex[0] - Constant.PICTURE_SIZE;
        codey[1] = codey[0];
        codex[2] = codex[0] - 2 * Constant.PICTURE_SIZE;
        codey[2] = codey[0];
        //第二条蛇
        snakex = new int[100];
        snakey = new int[100];
        snakex[0] = Constant.WINDOWX - codex[0] - Constant.PICTURE_SIZE;
        snakey[0] = Constant.WINDOWY - codey[0] - Constant.PICTURE_SIZE;
        snakex[1] = snakex[0] + Constant.PICTURE_SIZE;
        snakey[1] = snakey[0];
        snakex[2] = snakex[0] + 2 * Constant.PICTURE_SIZE;
        snakey[2] = snakey[0];

        create_food();
        System.out.println("初始化完成!");
    }

    public void create_food() {
        foodx = 20 + Constant.PICTURE_SIZE * random.nextInt(Constant.X_MOVE);
        foody = 60 + Constant.PICTURE_SIZE * random.nextInt(Constant.Y_MOVE);
        // 让生成的食物不会和蛇重合
        for (int i = 0; i < length; i++) {
            //第一条蛇、第二条蛇
            while ((foodx == codex[i] && foody == codey[i]) || (foodx == snakex[i] && foody == snakey[i])) {
                foodx = 20 + Constant.PICTURE_SIZE * random.nextInt(Constant.X_MOVE + 1);
                foody = 60 + Constant.PICTURE_SIZE * random.nextInt(Constant.Y_MOVE + 1);
                i = 0;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(Constant.FILLRECT_X, Constant.FILLRECT_Y, Constant.FILLRECT_WEIGTH, Constant.FILLRECT_HEIGHT);
        g.setColor(Color.GRAY);
        switch (changeDir.getHead_dir()) {
            case "ActionUp" -> image_head = Pictures.getHup();
            case "ActionDown" -> image_head = Pictures.getHdown();
            case "ActionLeft" -> image_head = Pictures.getHleft();
            case "ActionRight" -> image_head = Pictures.getHright();
        }
        image_head.paintIcon(this, g, codex[0], codey[0]);
        image_body = Pictures.getBody();
        for (int i = 1; i < length; i++) {
            image_body.paintIcon(this, g, codex[i], codey[i]);
        }
        image_food = Pictures.getFood();
        image_food.paintIcon(this, g, foodx, foody);
        //第二条蛇
        switch (changeDir.getHead_dir()) {
            case "ActionUp" -> image_head = Pictures.getHdown();
            case "ActionDown" -> image_head = Pictures.getHup();
            case "ActionLeft" -> image_head = Pictures.getHright();
            case "ActionRight" -> image_head = Pictures.getHleft();
        }
        image_head.paintIcon(this, g, snakex[0], snakey[0]);
        for (int i = 1; i < length; i++) {
            image_body.paintIcon(this, g, snakex[i], snakey[i]);
        }


        g.setFont(new Font("楷体", Font.BOLD, 20));
        g.drawString(Constant.Game_Name, 20, 20);
        g.drawString(Constant.Scores, 20, 50);
        g.drawString(String.valueOf(scores), 80, 50);

        // 绘制游戏暂停时的 提示信息
        if (!game_run) {
            g.setColor(Color.white);
            g.setFont(new Font("楷体", Font.BOLD, 40));
            g.drawString("按下空格开始游戏！", 400, 300);
        }
        // 绘制游戏失败时的 提示信息
        if (isFail) {
            g.setColor(Color.red);
            g.setFont(new Font("楷体", Font.BOLD, 40));
            g.drawString("失败，按下空格重新开始", 200, 300);
        }
        // 绘制游戏胜利时的 提示信息
        if (isVictory) {
            g.setColor(Color.red);
            g.setFont(new Font("宋体", Font.BOLD, 35));
            g.drawString("胜利，你是为数不多的天才", 200, 300);
            g.drawString("按下空格重新开始新一轮游戏", 180, 350);
        }

        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game_run && !isVictory && !isFail) {
            for (int i = codex.length - 1; i > 0; i--) {
                codex[i] = codex[i - 1];
                codey[i] = codey[i - 1];
            }

            switch (changeDir.getHead_dir()) {
                case "ActionUp" -> {
                    codey[0] -= 50;
                    if (codey[0] < Constant.FILLRECT_Y) {
                        codey[0] = Constant.FILLRECT_Y + Constant.FILLRECT_HEIGHT - Constant.PICTURE_SIZE;

                    }
                }
                case "ActionDown" -> {
                    codey[0] += 50;
                    if (codey[0] > Constant.FILLRECT_Y + Constant.FILLRECT_HEIGHT - Constant.PICTURE_SIZE) {
                        codey[0] = Constant.FILLRECT_Y;
                        //snakey[0]=Constant.WINDOWY - codey[0]+Constant.PICTURE_SIZE;
                    }
                }
                case "ActionLeft" -> {
                    codex[0] -= 50;
                    if (codex[0] < Constant.FILLRECT_X) {
                        codex[0] = Constant.FILLRECT_X + Constant.FILLRECT_WEIGTH - Constant.PICTURE_SIZE;
                    }
                }
                case "ActionRight" -> {
                    codex[0] += 50;
                    if (codex[0] > Constant.FILLRECT_X + Constant.FILLRECT_WEIGTH - Constant.PICTURE_SIZE) {
                        codex[0] = Constant.FILLRECT_X;
                        //snakex[0]=Constant.WINDOWX - codex[0]+Constant.PICTURE_SIZE;
                    }
                }
            }

            //第二条蛇
            for (int i = snakex.length - 1; i > 0; i--) {
                snakex[i] = snakex[i - 1];
                snakey[i] = snakey[i - 1];
            }
            snakex[0] = Constant.WINDOWX - codex[0] - Constant.PICTURE_SIZE;
            snakey[0] = Constant.WINDOWY - codey[0] - Constant.PICTURE_SIZE;

            if ((codex[0] == foodx && codey[0] == foody) || (snakex[0] == foodx && snakey[0] == foody)) {

                codex[length] = codex[length - 1];
                codey[length] = codey[length - 1];

                //第二条蛇
                snakex[length] = snakex[length - 1];
                snakey[length] = snakey[length - 1];


                length += 1;
                // 每吃一个食物，增加10积分
                scores += 1;
                // 长度等于300，游戏获胜
                // 当length到达一定的值，蛇移动的速度就变快
                if (scores == 20) {
                    isVictory = true;
                } else if (length == 10) {
                    timer = new Timer(500, this);
                }

                create_food();
            }
            //结束判断，头和身体的坐标一致时，游戏结束
            for (int i = 2; i < length; i++) {
                if ((codex[0] == codex[i] && codey[0] == codey[i])
                        || (snakex[0] == codex[i] && snakey[0] == codey[i])
                        || (codex[0] == snakex[i] && codey[0] == snakey[i])
                        || (snakex[0] == snakex[i] && snakey[0] == snakey[i])) {
                    isFail = true;
                    break;
                }


            }
            repaint();
        }
        timer.start();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    // 按键监听器
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (isFail || isVictory) {
                isFail = false;
                isVictory = false;
                init();
            } else {
                game_run = !game_run;
            }
            repaint();
        }

        System.out.println(e.getKeyCode() + "键被敲击");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> {
                if (!changeDir.getHead_dir().equals("ActionDown"))
                    changeDir.setHead_dir("ActionUp");
            }
            case KeyEvent.VK_DOWN -> {
                if (!changeDir.getHead_dir().equals("ActionUp"))
                    changeDir.setHead_dir("ActionDown");
            }
            case KeyEvent.VK_LEFT -> {
                if (!changeDir.getHead_dir().equals("ActionRight"))
                    changeDir.setHead_dir("ActionLeft");
            }
            case KeyEvent.VK_RIGHT -> {
                if (!changeDir.getHead_dir().equals("ActionLeft"))
                    changeDir.setHead_dir("ActionRight");
            }
        }

        String dir = changeDir.getHead_dir();

        //调用蛇头方向改变后对数据的处理
        try {
            Method declaredMethod = null;
            declaredMethod = changeDir.getClass().getDeclaredMethod(dir);
            declaredMethod.invoke(changeDir);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
    }

    // 释放监听器
    @Override
    public void keyReleased(KeyEvent e) {
    }
}