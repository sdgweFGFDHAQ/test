package leecode;

public class Dongtai_Guihua {
    public static void test1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxNum = 0;
        int previousCount = 0;
        for (int num : nums) {
            previousCount = Math.max(previousCount + num, num);
            maxNum = Math.max(previousCount, maxNum);
        }
        System.out.println(maxNum);
    }




    public static void main(String[] args) {
        test1();
    }
}
