package TesT.test;

import java.io.IOException;

public class Four {
    private static int a=100;
    public class Test1{
        public float name(float a,float b) throws IOException {
            return a+b;
        }
    }
    public class Test2 extends Test1 {
        public float name(float a, float b) throws IOException {//public不能改变
            return a + b;
        }
    }

    public static void main(String[] args){
        Four f1=new Four();
        f1.a++;

        a++;

        Four.a++;
        System.out.println(a);
    }
}
