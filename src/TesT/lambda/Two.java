package TesT.lambda;


import com.mysql.cj.util.StringUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

class AcceptMethod {

    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }

    public static void main(String[] args) {
        List<String> al = Arrays.asList("a", "b", "c", "d");

        for (String a : al) {
            AcceptMethod.printValur(a);
        }
        System.out.println("----------------");
        //下面的for each循环和上面的循环是等价的
        al.forEach(x -> {
            AcceptMethod.printValur(x);
        });
        System.out.println("----------------");

        al.forEach(AcceptMethod::printValur);
        System.out.println("----------------");
        //下面的方法和上面等价的
        Consumer<String> methodParam = AcceptMethod::printValur; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept
    }
}





class Person {

    String name;
    String age;
    String emailAddress;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void printname() {
        System.out.println("name");
    }

    
    public static int compareByAge(Person a, Person b) {
        return a.age.compareTo(b.age);
    }
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c", "d");


        Comparator<Person> compareByAge = Person::compareByAge;
//        (Person a,Person b)->{
//            //int i = compareByAge("a", "b");
//
//
//        })


        System.out.println(StringUtils.isEmptyOrWhitespaceOnly(""));
    }

}


public class Two {

    public static void main(String[] args) {

    }

}
