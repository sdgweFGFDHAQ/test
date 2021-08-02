package TesT.sort;

import java.util.Arrays;

/**
 * @Author 1
 * @Date 2021/7/27
 * @Description IntelliJ IDEA
 **/
public class JiShuPaiXu {
    public int[] jiShuPaiXu(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        int maxDigit = getMaxDigit(temp);
        return radixSort(temp,maxDigit);
    }

    private int getMaxDigit(int[] temp){
        int maaxValue = getMaxValue(temp);
        return getNumLenght(maaxValue);
    }

    private int getMaxValue(int[] temp){
        int maxValue = temp[0];
        for(int value : temp){
            if(maxValue < value){
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLenght(long num){
        if(num == 0){
            return 1;
        }
        int lenght = 0;
        for(long t = num; t != 0; t /=10){
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] temp, int maxDigit){
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10,mod *=10) {
            int[][] counter = new int[mod*2][0];
            for (int j = 0; j < temp.length; j++) {
                int bucket = ((temp[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], temp[j]);
            }
            int pos = 0;
            for(int[] bucket : counter){
                for(int value : bucket){
                    temp[pos++] = value;
                }
            }
        }
        return temp;
    }

    private int[] arrayAppend(int[] temp, int value) {
        temp = Arrays.copyOf(temp, temp.length + 1);
        temp[temp.length - 1] = value;
        return temp;
    }

    public static void main(String[] args) {
        JiShuPaiXu jspx = new JiShuPaiXu();
        int[] arr = {3, 8, 9, 2, 7, 2, 4, 5, 1, 6};
        System.out.println(Arrays.toString(jspx.jiShuPaiXu(arr)));
    }
}
