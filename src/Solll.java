import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 1
 * @Date 2021/9/18
 * @Description IntelliJ IDEA
 **/
public class Solll {
    public String multiply (String num1, String num2) {
        // write code here
        long n1 = Integer.parseInt(num1),n2 = Integer.parseInt(num2);
        String ans = String.valueOf(n1 * n2);
        return ans;
    }

    public static void test(){
        char[] a = new char[]{'a','c','s'};
        //char[] a = new char[3]{'a','c','s'};
        String s1 = new String("abc");
        String s2 = new String("ccc");

        StringBuilder sb = new StringBuilder("sb");
        sb.append("sc");
        final List l = new LinkedList();
        l.add(s1);
        s1 = s2;
        l.add(sb);
        System.out.println(l.get(0));
        System.out.println(l.get(1));
    }

    public static void main(String[] args) {
        int a = 505000;
        System.out.println(a);
        System.out.println((-5)&6);
        test();
        List<int[]> v = new ArrayList<>();
        v.add(new int[]{1,2,3});
        v.add(new int[]{3,2,1});
        System.out.println(v.toString());
        int[][] arr = v.toArray(new int[v.size()][]);
        System.out.println(Arrays.deepToString(arr));
    }
}
