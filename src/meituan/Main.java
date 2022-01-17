package meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/8/15
 * @Description IntelliJ IDEA
 **/

public class Main {

    public static String resort(int len, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String choose = "Yes";
        for (int j = 0; j < len; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }
        for (int j = 1; j < len + 1; j++) {
            if (map.get(j) == null || map.get(j) != 1) {
                choose = "No";
            }
        }
        return choose;
    }

    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//
//        String[] re = new String[num];
//        for (int i = 0; i < num; i++) {
//            int len = scanner.nextInt();
//            int[] nums = new int[len];
//            for (int j = 0; j < len; j++) {
//                nums[j]=scanner.nextInt();
//            }
//
//            re[i] = resort(len, nums);
//        }
//        for (int i = 0; i < num; i++) {
//            System.out.println(re[i]);
//        }
//    }

    public static int huiWen(String str) {
        int re = Integer.MIN_VALUE;
        int length = str.length();

        for (int i = 0; i < length; i++) {
            int j = i - 1, k = i + 1;
            int count = 1;
            while (j >= 0 && k < length && str.charAt(j) == str.charAt(k)) {
                count += 2;
                j--;
                k++;
            }
            re = Math.max(re, count);
        }
        for (int i = 0; i < length - 1; i++) {
            int j = i, k = i + 1;
            if (str.charAt(i) == str.charAt(i+1)) {
                int count = 0;
                while (j >= 0 && k < length && str.charAt(j) == str.charAt(k)) {
                    count += 2;
                    j--;
                    k++;
                }
                re = Math.max(re, count);
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(huiWen(str));

    }
}
