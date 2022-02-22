package TesT.abstract_and_interface;

import java.util.Date;

/**
 * @Author 1
 * @Date 2021/8/2
 * @Description IntelliJ IDEA
 **/
class Parent {
    public int a = 1;

    private void test1() {
        System.out.println("父类方法并使用private");
    }

    protected void test2() {
        System.out.println("父类方法并使用protected");
    }

    public void test3() {
        System.out.println("父类方法3");
    }

    public void howToExtend() throws CloneNotSupportedException {
        int b = 2;
    }
}

class Child extends Parent {
    private void test1() {
        System.out.println("子类方法并使用private");
    }

    //    private void test2() {
//        System.out.println("父类方法并使用protected");
//    }
    public void test2() {
        System.out.println("父类方法并使用protected");
    }

    public void test3() {
        System.out.println("尝试覆写父类方法3");
    }

    public void howToExtend() throws CloneNotSupportedException {
        super.clone();
        int c = 3;
    }
}

public class Extend {
    public void me(){
        int a = 3;
        class Mss{
            //内部类的局部变量是需要final修饰的
            int b = a;
            int c = 4;
            public void mes(){
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        Child child = new Child();
//        parent.test1();
//        child.test1();

        parent.test2();
        child.test2();

        parent.test3();
        child.test3();


        new Test().test();
    }
}


class Test extends Date {
    public void test() {
        System.out.println(getClass().getName());
        System.out.println(super.getClass().getName());
        System.out.println(getClass().getSuperclass().getName());
    }
}

