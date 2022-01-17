package llq360;

import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/8/29
 * @Description IntelliJ IDEA
 **/
public class Main {

    public static int maxZDL(int n,int m,int x,int k,int[] arr){
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[j]+=k;
                for (int l = 1; l <= x; l++) {
                    if(j+l< arr.length){
                        arr[j+l]+=k;
                    }
                    if(j-l>=0){
                        arr[j-l]+=k;
                    }
                }

            }

        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String[] fht = sc.nextLine().split(" ");
            int[] arrays = new int[n];
            for (int i = 0; i < fht.length; i++) {
                arrays[i] = Integer.parseInt(fht[i]);
            }
            System.out.println(maxZDL(n, m, x, k, arrays));
        }
    }
}
