package TesT.use_enum;

//定义常量
enum STA {
    RED, YELLOW, GREEN
}

//构造方法和方法的实现
enum Color {
    RED("红色", 1, "red"), GREEN("绿色", 2, "green"),
    BLANK("白色", 3, "black"), YELLO("黄色", 4, "yellow");
    // 成员变量
    private String name;
    private int index;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // 构造方法
    Color(String name, int index, String text) {
        this.name = name;
        this.index = index;
        this.text = text;
    }

    // 普通方法
    public static String queryName(int index) {
        for (Color c : Color.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return "没有这个index值";
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
//重写toString
enum String_Override {
    WORD("hello", "enum");

    private String a;
    private String b;

    String_Override(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return this.a
                + " "
                + this.b;
    }
}

//swich的使用
public class Test_Enum {

    public STA test(STA x) {
        switch (x) {
            case RED:
                x = STA.RED;
            case YELLOW:
                x = STA.YELLOW;
            case GREEN:
                x = STA.GREEN;
        }
        return x;
    }


    public static void main(String[] args) {
        System.out.println("--设置常量--");
        Test_Enum test_enum = new Test_Enum();
        test_enum.test(STA.GREEN);

        System.out.println(STA.RED==STA.GREEN);

        System.out.println("--swich的使用，实现自定义方法--");
        String name = Color.RED.getName();
        System.out.println(name);
        String s = Color.queryName(2);
        System.out.println(s);
        
        int ordinal = Color.RED.ordinal();
        System.out.println(ordinal);

        System.out.println(Color.GREEN.equals(Color.RED));

        System.out.println("--重写toString方法--");
        String s1 = String_Override.WORD.toString();
        System.out.println(s1);

    }
}




