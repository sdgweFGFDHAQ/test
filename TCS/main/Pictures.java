package TCS.main;

import javax.swing.*;
import java.net.URL;

public class Pictures {
    public static URL url=Pictures.class.getResource("../resources/hup.png");
    private static ImageIcon hup = new ImageIcon(url);
    private static ImageIcon hdown = new ImageIcon(Pictures.class.getResource("../resources/hdown.png"));
    private static ImageIcon hleft = new ImageIcon(Pictures.class.getResource("../resources/hleft.png"));
    private static ImageIcon hright = new ImageIcon(Pictures.class.getResource("../resources/hright.png"));
    private static ImageIcon body = new ImageIcon(Pictures.class.getResource("../resources/body.png"));
    private static ImageIcon tail = new ImageIcon(Pictures.class.getResource("../resources/tail.png"));
    private static ImageIcon food = new ImageIcon(Pictures.class.getResource("../resources/food.png"));

    public static ImageIcon getHup() {
        return hup;
    }

    public static void setHup(ImageIcon hup) {
        Pictures.hup = hup;
    }

    public static ImageIcon getHdown() {
        return hdown;
    }

    public static void setHdown(ImageIcon hdown) {
        Pictures.hdown = hdown;
    }

    public static ImageIcon getHleft() {
        return hleft;
    }

    public static void setHleft(ImageIcon hleft) {
        Pictures.hleft = hleft;
    }

    public static ImageIcon getHright() {
        return hright;
    }

    public static void setHright(ImageIcon hright) {
        Pictures.hright = hright;
    }

    public static ImageIcon getBody() {
        return body;
    }

    public static void setBody(ImageIcon body) {
        Pictures.body = body;
    }

    public static ImageIcon getTail() {
        return tail;
    }

    public static void setTail(ImageIcon tail) {
        Pictures.tail = tail;
    }

    public static ImageIcon getFood() {
        return food;
    }

    public static void setFood(ImageIcon food) {
        Pictures.food = food;
    }

}
