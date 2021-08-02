package TesT.test;

public class Three {
    public static void main(String args[]){
        String s1="abc"+"def";
        String s2=new String(s1);
        if(s1==s2){//"==" 用于基本数据类型对象比较时，比较的是对象的内容值是否相等;
                   //用于引用数据类型时，比较的是对象的地址值是否相等.
                   //而String 是引用类型，s1生成了一个在内存空间保存 的 “test” ; s1 指向它的内存空间地址。
                   //当s2 生成时，内存空间已有 "test" ，引用类型不会再创建一个新内存空间，而是将s2的也指向原来的 "test"（成员变量存在于常量池中的）。
                   //当s3 new了一个String对象时，相当了对"test"做了一份拷贝，新建了一个内存空间，（对象始终存在于堆中）。
        System.out.println("==succeeded");
        }
        if(s1.equals(s2)){//"equals" 是用来比较方法两个对象的内容是否相等。
            System.out.println(".equals()succeeded");
        }
    }

}
