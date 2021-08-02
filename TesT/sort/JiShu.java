package TesT.sort;

import java.util.Arrays;

/**
 * @Author 1
 * @Date 2021/7/27
 * @Description IntelliJ IDEA
 **/
public class JiShu {
    public int[] jishu(int[] arr) {
        int[] temp = Arrays.copyOf(arr,arr.length);

        int maxValue = getMaxValue(temp);

        return countinfSort(temp,maxValue);
    }

    private  int getMaxValue(int[] temp){
        int maxValue = temp[0];
        for(int value : temp){
            if(maxValue < value){
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int[] countinfSort(int[] temp, int maxValue){
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];
        for(int value : temp){
            bucket[value]++;
        }

        int sortedIndex = 0;
        for(int i = 0; i < bucketLen; i++){
            while (bucket[i] > 0){
                temp[sortedIndex++] = i;
                bucket[i]--;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        JiShu js = new JiShu();
        int[] arr = {3, 8, 9, 2, 7, 2, 4, 5, 1, 6};
        System.out.println(Arrays.toString(js.jishu(arr)));
    }
}
