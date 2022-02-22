package TesT.NumsType;

public class NumType {

    public static void ChangeType() {
        long a = 49900;
        //int b=10L;
        int e = 4;
        a = e;
        //e=a;

        double c = 33.1;
        //float d=1.2;
        float f = 18;
        c = f;
        //f=c;

        int m = Integer.MAX_VALUE;
        System.out.println(m);
    }

    public static void Rounding() {
        int x = 5;
        int y = 2;
        System.out.println(x / y);
        System.out.println(Math.ceil(x / y));
        System.out.println(-(x / y));
        System.out.println((-x) / y);

        double c1 = Math.ceil(11.2);
        double f1 = Math.floor(-11.6);
        System.out.println("c1:" + c1);
        System.out.println("f1" + f1);

        //原来的数字加上0.5后再向下取整
        long r1 = Math.round(11.5);
        long r2 = Math.round(-11.5);
        System.out.println("r1:" + r1);
        System.out.println("r2:" + r2);


    }

    public static void add(Byte b) {
        b = b++;
    }

    public static void test() {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + " ");
    }

    public static void main(String[] args) {
        ChangeType();

        Rounding();

        test();

        StringBuffer sb = new StringBuffer("aa");
        sb.append("bcd");
        System.out.println(sb);

        System.out.println((-7) % 3);//-1
        System.out.println(7 % (-3));//1
        System.out.println((-7) / 3);//-2
    }
}
