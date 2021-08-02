package TesT.sort;

import java.util.Arrays;

public class XiEr {
    public static int[] xier(int[] arr){
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,6,2,8,4,9,3};
        System.out.println(Arrays.toString(xier(arr)));
    }
}
