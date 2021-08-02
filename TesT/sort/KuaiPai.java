package TesT.sort;

import java.util.Arrays;

/**
 * @Author 1
 * @Date 2021/7/26
 * @Description IntelliJ IDEA
 **/
public class KuaiPai {

    public int[] sort(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        return quicksort(arr, 0, arr.length - 1);
    }

    private int[] quicksort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quicksort(arr, left, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

    }

    public static void main(String[] args) {
        KuaiPai kp = new KuaiPai();
        int[] arr = {4, 8, 1, 9, 2, 4, 2, 4, 5, 1, 6};
        System.out.println(Arrays.toString(kp.sort(arr)));
    }
}
