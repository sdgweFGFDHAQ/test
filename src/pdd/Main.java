package pdd;

import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/9/29
 * @Description IntelliJ IDEA
 **/
public class Main {
    public void Solution1(){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = {a,b,c};
        for (int i = 0; i < 2; i++) {
            for (int j = i + 1; j < 3; j++) {
                if(arr[i] > arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        int i, j, k;
        i = len / arr[0];
        j = (len - i * arr[0]) / arr[1];
        k = (len - i * arr[0] - j * arr[1]) / arr[2];
        while (arr[0] * i + arr[1] * j + arr[2] * k != len) {
            if (i != 0) {
                i--;
                j++;
            } else if (j != 0) {
                j--;
                k++;
            } else System.out.println(-1);
        }
        System.out.print(i);
        System.out.print(" ");
        System.out.print(j);
        System.out.print(" ");
        System.out.print(k);
    }

    public static void main(String[] args) {
        int i = 0;
        while (true){
            for (int j = 0; j < 3; j++) System.out.println(j);
            if (++i > 1) break;
            System.out.println("s"+i);
        }

    }
}
