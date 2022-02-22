package TesT.lambda;

import java.util.Arrays;

public class one {
    public one() {

    }

    public void test(){

    }

    public static void main(String[] args) {

        String s[] = {"aa", "b", "ccc"};
        Arrays.sort(s, (s1, s2) -> s1.length() - s2.length());

        // 输出
        Arrays.stream(s).forEach(System.out::println);

        int x=4;
        int y=5;

        new Thread(()-> System.out.println("lambda")).start();

    }
}
