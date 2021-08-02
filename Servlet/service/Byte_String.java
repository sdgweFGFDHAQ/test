package Servlet.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class Byte_String{


    public static void t() throws IOException {

        String s = "cat.jpg";
        String s0 = s.substring(s.lastIndexOf("."));
        System.out.println(s0);

        FileInputStream f = new FileInputStream("E:\\dpan\\bugbuff\\Change_Picture\\1584188246929.jpg");
        byte[] bytes = new byte[f.available()];
        int read = f.read(bytes);
        f.close();
        System.out.println(read);
    }

    public static void ByteToString() {
        byte[] bytes = "a1".getBytes();
        System.out.println(new String(bytes));

        String encode = Base64.getEncoder().encodeToString(bytes);
        System.out.println(encode);
        byte[] decode = Base64.getDecoder().decode(encode);
        System.out.println(new String(decode));
    }

    public static void main(String[] args) throws IOException {
        Byte_String.ByteToString();
        Byte_String.t();
    }

}
