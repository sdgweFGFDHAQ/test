package TesT.test;

import java.io.UnsupportedEncodingException;

public class Reverse {
    public static char try_finally(){
        char c='a';
        try {
            System.out.println("try模块");
            return c;
        } finally {
            //保存return结果，然后运行finall块，再执行return语句
            System.out.println("finally模块");
            c='b';
        }
    }
    public static void change_UTF() throws UnsupportedEncodingException {
        String s1 = "你好";
        String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
        System.out.println(s2);
    }
    public static String re(String originStr){
        if(originStr==null||originStr.length()<=1)
            return originStr;
        return re(originStr.substring(1))+originStr.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(re("12345"));
        System.out.println(try_finally());
        try {
            change_UTF();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
