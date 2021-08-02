package TesT.sort;

import java.util.Arrays;

public class GuiBing {

    public int[] cutting(int[] arr){
        while (arr.length<2){
            return arr;
        }

        int middle = (int) Math.floor(arr.length/2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(cutting(left),cutting(right));
    }

    public int[] merge(int[] left, int[] right){
        int[] temp = new int[left.length + right.length];
        int i = 0;
        while (left.length>0 && right.length > 0){
            if(left[0] < right[0]){
                temp[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }else {
                temp[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0){
            temp[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }
        while (right.length > 0){
            temp[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return temp;
    }

    public static void main(String[] args) {
        GuiBing gb = new GuiBing();
        int[] arr = {4,8,1,9,2,4,2,4,5,1,6};
        System.out.println(Arrays.toString(gb.cutting(arr)));
    }
}
