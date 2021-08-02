package TesT.sort;

import java.util.Arrays;

public class XuanZhe {

    public static int[] xuanzhe(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < temp.length; i++) {
            int min = i;
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[min] > temp[j]) {
                    min = j;
                }
            }
            if(min != i){
                int t = temp[min];
                temp[min] = temp[i];
                temp[i] = t;
            }
        }
        for (int i :
                temp) {
            System.out.println(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] a = {3,5,1,4,6,8,6,2};
        System.out.println(xuanzhe(a));
    }
}
