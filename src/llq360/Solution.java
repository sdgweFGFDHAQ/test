package llq360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/8/28
 * @Description IntelliJ IDEA
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 100, res = 0;
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++)
            scores[i] = sc.nextInt();
        Arrays.sort(scores);
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && scores[i] < scores[i + 1]) num--;
            double sum = (p * num + q * scores[i]) / 100;
            if (sum >= 60) res++;
        }
        System.out.println(res);
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int p = sc.nextInt();
//        int q = sc.nextInt();
//        int[] stu = new int[n];
//        for (int i = 0; i < n; i++) {
//            stu[i] = sc.nextInt();
//        }
//        Arrays.sort(stu);
//        // 平时分为100
//        int a = 100;
//        // 及格人数
//        int count = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            // 判断最后一个数
//            if (i == n - 1) {
//                // 期末分数b
//                int b = stu[i];
//                int grade = (p * a + q * b) / 100;
//                if (grade < 60) {
//                    System.out.println(count);
//                    break;
//                } else {
//                    count++;
//                }
//            } else if (i < n - 1 && stu[i] == stu[i + 1]) {
//                count++;
//            } else {
//                // 期末分数b
//                int b = stu[i];
//                a--;
//                int grade = (p * a + q * b) / 100;
//                if (grade < 60) {
//                    System.out.println(count);
//                    break;
//                } else {
//                    count++;
//                }
//            }
//            if (i == 0) {
//                System.out.println(count);
//            }
//        }
//
//    }


//    public static int MaxNums(int p, int q, PriorityQueue queue) {
//        int max = 0;
//        int size = queue.size();
//        int g = 100;
//        for (int i = 0; i < size; i++) {
//            int needG = (60 * 100 - (int) queue.poll() * q) / p;
//            if (needG <= g) {
//                max++;
//                g--;
//            }else break;
//        }
//        return max;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        PriorityQueue<Integer> pqueue = new PriorityQueue<>((a, b) -> (b - a));
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            int p = sc.nextInt();
//            int q = sc.nextInt();
//            sc.nextLine();
//            String[] grates = sc.nextLine().split(" ");
//            for (String s : grates) {
//                pqueue.add(Integer.parseInt(s));
//            }
//            System.out.println(MaxNums(p, q, pqueue));
//        }
//
//    }
}

