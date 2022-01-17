package blbl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/9/13
 * @Description IntelliJ IDEA
 **/
public class Main {


    static int count = 0;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int[][] arr = new int[num][2];
//        for (int i = 0; i < num; i++) {
//            arr[i][0] = scanner.nextInt();
//            arr[i][1] = scanner.nextInt();
//        }
//        int max = 0;
//        for (int i = 0; i < 5000001; i++) {
//            int count1 = 0;
//            int count2 = 0;
//            for (int j = 0; j < num; j++) {
//                if (arr[j][0] == i) {
//                    count1++;
//                }
//                if (arr[j][1] == i) {
//                    count2++;
//                }
//            }
//            max = Math.max(max, Math.max(count1, count2));
//        }
//        System.out.println(max);

//        Scanner scanner = new Scanner(System.in);
//        int[][] arr;
//        int r = 0;
//        int c = 0;
//        while (true) {
//            r = scanner.nextInt();
//            c = scanner.nextInt();
//            if (r == -1 || c == -1) break;
//            arr = new int[r][c];
//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//                    arr[i][j] = scanner.nextInt();
//                }
//            }
//            //arr,r,c
//            int r0 = 0;
//            int c0 = 0;
//            int r1 = 0;
//            int r2 = r - 1;
//            int c1 = 0;
//            int c2 = c - 1;
//            int dir = 0;
//            for (int i = 0; i < r * c; i++) {
//                if(i == r * c -1){
//                    System.out.print(arr[r1][c1]);
//                }else {
//                    System.out.print(arr[r1][c1] + ",");
//                }
//
//                if(dir == 0){
//                    c1++;
//                    if(c1 > c2){
//                        c1--;
//                        r1++;
//                        r0++;
//                        dir = 1;
//                    }
//                }else if(dir == 1){
//                    r1++;
//                    if(r1 > r2){
//                        r1--;
//                        c1--;
//                        r2--;
//                        dir = 2;
//                    }
//                }else if(dir == 2){
//                    c1--;
//                    if(c1 < c0){
//                        c1++;
//                        r1--;
//                        c2--;
//                        dir = 3;
//                    }
//                }else {
//                    r1--;
//                    if(r1 < r0){
//                        r1++;
//                        c1++;
//                        c0++;
//                        dir = 0;
//                    }
//                }
//            }
//            System.out.println();
//        }

/*
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,1,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 */

        Scanner scanner = new Scanner(System.in);
        List<List<String>> arr = new ArrayList<>();
        List<String> a;
        int index = 0;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("0")) break;
            a = new ArrayList<>();
            String[] split = s.replace("[", "").replace("]", "").split(",");
            for (int i = 0; i < split.length; i++) {
                a.add(i, split[i]);
            }
            arr.add(index++, a);
        }

        int r = arr.size();
        int c = arr.get(0).size();
        int max = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dfs(i, j, r, c, arr);
                max = Math.max(max, count);
                count = 0;
            }
        }
    }

    public static void dfs(int i, int j, int r, int c, List<List<String>> arr) {
        if (i + 1 < r && arr.get(i + 1).get(j).equals("1")) {
            count++;
            dfs(i + 1, j, r, c, arr);
        }
        if (i - 1 >= 0 && arr.get(i - 1).get(j).equals("1")) {
            count++;
            dfs(i - 1, j, r, c, arr);
        }
        if (j + 1 > c && arr.get(i).get(j + 1).equals("1")) {
            count++;
            dfs(i, j + 1, r, c, arr);
        }
        if (j - 1 >= 0 && arr.get(i).get(j - 1).equals("1")) {
            count++;
            dfs(i, j - 1, r, c, arr);
        }
    }
}
