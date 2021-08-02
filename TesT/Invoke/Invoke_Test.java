package TesT.Invoke;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.*;

public class Invoke_Test extends Change_Direction implements KeyListener {

    private String dir="ActionUp";

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP){
            this.setDir("ActionUp");
            System.out.println("key-aa");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public void ActionUp() {

        System.out.println("ActionUp");
    }

    public void ActionDown() {

        System.out.println("ActionDown");
    }

    public void ActionLeft() {

        System.out.println("ActionLeft");
    }

    public void ActionRight() {

        System.out.println("ActionRight");
    }


    public static void main(String[] args)  {
        Invoke_Test invoke_test = new Invoke_Test();
        String invoke_testDir = invoke_test.getDir();


        try {
            Method method = Invoke_Test.class.getDeclaredMethod(invoke_testDir);
            //自动new完整对象： Ctrl+Alt+V，可以引入变量
            method.invoke(invoke_test);
        } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
