package TesT.test;

public class Intertest {

    public static void main(String[] args) {
//        Integer a = new Integer(3);
//        Integer b = 3;                  // 将3自动装箱成Integer类型
//        int c = 3;
//        System.out.println(a == b);     // false 两个引用没有引用同一对象
//        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
//        System.out.println(c == b);
//
//
//        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
//
//        System.out.println(f1 == f2);
//        System.out.println(f3 == f4);

//        float f=3;
//        //float f=3.4;
//        System.out.println(f);

        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);

        String s3 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1 == s3);
        }

}

