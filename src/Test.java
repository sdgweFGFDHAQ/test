import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject{
    void visit();
}
class RealSubject implements Subject {

    private String name = "name";
    @Override
    public void visit() {
        System.out.println(name);
    }
}
class DynamicProxy implements InvocationHandler{
    private Object object;
    public DynamicProxy(Object o){
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
        Object result = method.invoke(object, args);
        return result;
    }
}

public class Test {
    public static void test1(){
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);
        //~n=-n-1
    }

    public static void test2(){
        int a=0;
        System.out.println(a);
        System.out.println(a++);
        System.out.println(a);

    }



    public int search(int[] nums, int target) {
        int count=0;
//        HashMap<Integer,Integer> map=new HashMap<>();


        return count;
    }
    public static void main(String[] args) {
//        test2();
//        Child child = new Child();
//        child.test();
//        Child.add();
        Subject resultSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(resultSubject);
        ClassLoader classLoader = resultSubject.getClass().getClassLoader();
        Subject subject = (Subject) Proxy.newProxyInstance(classLoader, new Class[]{Subject.class}, proxy);
        subject.visit();

    }
}

class Parents{
    public static void add(){
        System.out.println("static");
    }
    public void test(){
        System.out.println("parents' static method");
    }
}
class Child extends Parents{
    public void test(){
        System.out.println("children' static method");
    }
}

abstract class p{
    //private abstract void a1();
    protected abstract void a2();
    public abstract void a3();
}
class c extends p{
    //void a1(){}
    protected void a2(){}
    public void a3(){}
}
