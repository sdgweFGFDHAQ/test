package TesT.math;

/**
 * @Author 1
 * @Date 2021/9/5
 * @Description IntelliJ IDEA
 * 两个水壶倒水问题
 * 通过辗转相除法求最大公约数
 * 贝祖定理，ax+by=z a,x,b,y均为正整数,有解当且仅当 z 是 x, y 的最大公约数的倍数
 **/
public class GCD {
    public static int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }


    public static void main(String[] args) {
        System.out.println(gcd(35,28));
    }
}
