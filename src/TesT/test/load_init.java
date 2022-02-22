package TesT.test;

public class load_init {
    public static void main(String[] args) {
        A ab=new B();
        ab=new B();
    }


}
class A{
    static {
        System.out.println("1");
    }
    A(){
        System.out.println("2");
    }
}
class B extends A{
    static {
        System.out.println("a");
    }
    B(){
        System.out.println("b");
    }
}