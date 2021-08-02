package TesT.sort;

import java.util.Arrays;

public class ChaRu {

    public static int[] charu(int[] arr){
        int[] temp = Arrays.copyOf(arr,arr.length);
        for (int i = 1; i < temp.length; i++) {
            int t = temp[i];
            int j = i;
            while(j>0 && t < temp[j-1]){
                temp[j] = temp[j-1];
                j--;
            }
            if(j != i){
                temp[j] = t;
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr={4,7,1,3,0,3,1,2,8};
        System.out.println(Arrays.toString(charu(arr)));
    }
}
