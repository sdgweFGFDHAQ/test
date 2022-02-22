package TesT.Invoke;
import java.util.Arrays;
import java.util.List;
/**
 * @Author 1
 * @Date 2021/9/2
 * @Description IntelliJ IDEA
 **/


public class Duotai {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //题外话，Arrays.asList 可变参数列表，可以把传入的多个对象转为一个list
        List<Shape> shapes = Arrays.asList(new Triangle(),new Circle());
        for (Shape shape : shapes) {
            shape.draw();
        }
        
        Class<Circle> circles = Circle.class;
        Circle circle = circles.newInstance();//第一：泛化class.newInstance可以直接得到具体的对象
        Class<? super Circle> shape = circles.getSuperclass();
        Object shape1 = shape.newInstance();//第二：它的父类，只能用逆变的泛型class接收，newInstance得到的是Object类型
    }
}

abstract class Shape {
    void draw(){
        System.out.println(this+".draw()");
    }
    abstract public String toString();
}
class Circle extends Shape{
    @Override
    public String toString() {        return "Circle";    }

}
class Triangle extends Shape{
    @Override
    public String toString() {        return "Triangle";    }

}


