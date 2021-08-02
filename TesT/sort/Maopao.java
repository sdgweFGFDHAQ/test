package TesT.sort;

import java.util.Comparator;

public class Maopao implements Sorter{

    @Override
    public <T extends Comparable<T>> void sort(T[] list) {
        boolean declared=true;
        for (int i=1,len=list.length;i<len&&declared;i++){
            declared=false;
            for (int j=0;j<len-i;j++){
                if(list[j].compareTo(list[j+1])>0){
                    T temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                    declared=true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comparator) {
        boolean declared=true;
        for (int i=1,len=list.length;i<len&&declared;i++){
            declared=false;
            for (int j=0;j<len-i;j++){
                if(comparator.compare(list[j],list[j+1])>0){
                    T temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                    declared=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Maopao mp=new Maopao();
        Integer[] integerArray = new Integer[]{6,5,1,4,2,3};
        mp.sort(integerArray);

        for (Integer integer : integerArray) {
            System.out.print(integer+" ");
        }

        System.out.println("--------------lambda-----------------");
        mp.sort(integerArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("--------------------------------------");
        mp.sort(integerArray, (o1, o2) -> o1.compareTo(o2));
        System.out.println("--------------------------------------");
        mp.sort(integerArray, Integer::compareTo);
        System.out.println("--------------lambda--------------------");

        for (Integer integer : integerArray) {
            System.out.print(integer+" ");
        }


        //::的使用
        System.out.println(new Something("abc"));
        //访问静态方法
        IConvert<String, String> startsWith = Something::startsWith;
        String convert = startsWith.convert("123");
        //访问对象方法
        Something something = new Something();
        //IConvert<String, String> endwith=Something::endWith;
        //endwith.convert("456");
        //访问构造方法
        IConvert<String, Something> strSthIConvert = Something::new;
        Something convert1 = strSthIConvert.convert("789");
    }
}
class Something {

    // constructor methods
    Something() {}

    Something(String st) {
        System.out.println(st);
    }

    // static methods
    static String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }

    // object methods
    String endWith(String s) {
        return String.valueOf(s.charAt(s.length()-1));
    }

    void endWith() {}
}
@FunctionalInterface
//定义接口名，定义类型F、T
interface IConvert<F,T>{
    //定义函数名和形参
    T convert(F from);
}