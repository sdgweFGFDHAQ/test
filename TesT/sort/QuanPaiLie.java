package TesT.sort;

import java.util.Arrays;

/**
 * @Author 1
 * @Date 2021/7/27
 * @Description IntelliJ IDEA
 **/


public class QuanPaiLie {
    public static int count = 0;
    public static int count1 = 1;

    //基于递归的实现
    private void core(int[] array) {
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }

    private void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            count++;
            System.out.println(count + ":" + Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }
                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i); // 用于对之前交换过的数据进行还原
            }
        }
    }

    //java: 无法从静态上下文中引用非静态 方法 swap(int[],int,int)
    //静态方法不能调用静态方法
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //基于非递归的实现
    private void core1(int[] array) {
        // 先排序
        Arrays.sort(array);
        System.out.println(Arrays.toString(array)); // 最初始的序列
        do {
            nextArray(array);
            count1++;
            System.out.println(count1+ ":" +Arrays.toString(array));
        } while (!isLast(array));
    }

    private void nextArray(int[] array) {
        int length = array.length;
        // 寻找替换点
        int cursor = 0;
        for (int i = length - 1; i >= 1; i--) {
            // 找到第一个递增的元素对
            if (array[i - 1] < array[i]) {
                cursor = i - 1; // 找到替换点
                break;
            }
        }

        // 寻找在替换点后面的次小元素
        int biggerCursor = cursor + 1;
        for (int i = cursor + 1; i < length; i++) {
            if (array[cursor] < array[i] && array[i] < array[biggerCursor]) {
                biggerCursor = i;
            }
        }

        // 交换
        swap(array, cursor, biggerCursor);

        // 对替换点之后的序列进行反转
        reverse(array, cursor);

    }

    private void reverse(int[] array, int cursor) {
        int end = array.length - 1;
        for (int i = cursor + 1; i <= end; i++, end--) {
            swap(array, i, end);
        }
    }

    private boolean isLast(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            if (array[i - 1] < array[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        QuanPaiLie quanPaiLie = new QuanPaiLie();
        int[] arr = {1, 3, 2, 1};
        quanPaiLie.core(arr);

        int[] arr1 = {2, 1, 3, 4};
        quanPaiLie.core1(arr1);

    }
}
