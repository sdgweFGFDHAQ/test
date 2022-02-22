package TesT.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {

        int[] arry = {49, 38, 65, 97, 76, 13, 27};

//程序还有问题.比如当数据为49,38, 65, 97, 76, 13, 27,12,11 的时候,第一次就把最小一位放到第一位,,而出现问题

        QuickSort.method2(arry);

        Arrays.sort(arry, 0, arry.length);

        for (int i = 0; i < arry.length; i++) {

            System.out.println("结果:" + arry);

        }

    }

    /**
     * 快速排序
     *
     * @param array
     */

    public static void method2(int[] array) {

//1）设置两个变量I、J，排序开始的时候：I=0，J=N-1；

        int i = 0;

        int j = array.length - 1;//获取数组最后一位

//2）以第一个数组元素作为关键数据，赋值给key，即 key=A[0]；

        int k = array[0];//获取数组第一位

        int f = 0;

        boolean check = false;

        int x = 0;

        while (i != j) {

//3）从J开始向前搜索，即由后开始向前搜索（J=J-1），找到第一个小于key的值A[J]，A[j]与A交换；

            while (array[j] > k) {

                j--;

            }

            int temp = k;

            k = array[j];

            array[j] = temp;

//[49, 38, 65, 97, 76, 13, 27] //[27, 38, 65, 97, 76, 13, 49]//[27, 38, 49, 97, 76, 13, 65]

//[27, 38, 49, 97, 76, 49, 65] //[27, 38, 13, 97, 76, 49, 65]//[27, 38, 13, 49, 76, 97, 65]

//[27, 38, 13, 49, 76, 97, 65]

//4）从I开始向后搜索，即由前开始向后搜索（I=I+1），找到第一个大于key的A，A[j]与A交换；

            //while (array < k) {
            //    i++;
            //}
            int temp1 = k;
            //k = array;
            //array = temp1;

//[27, 38, 65, 97, 76, 13, 49] //[27, 38, 49, 97, 76, 13, 49] //[27, 38, 49, 97, 76, 13, 65]

//[27, 38, 13, 97, 76, 49, 65] //[27, 38, 13, 49, 76, 49, 65] //[27, 38, 13, 49, 76, 97, 65]

            System.out.println(array + " " + array[j]);

            //if (array == array[j]) {

            x++;

            if (x > (array.length / 2 + 1)) {

                check = true;

            }

        }

        if (i == j || check) {

            k = array[0];//获取数组第一位

            if (i == j && i == 0) {

                k = array[1];

            }

            i = 0;

            j = array.length - 1;//获取数组最后一位

            check = false;

            x = 0;

            if (f > (array.length / 2 + 1)) {

                k = array[j];

            }

            if (f == array.length) {

                //break;

            }

            f++;

        }//[27, 38, 13, 49, 76, 97, 65] //[13, 27, 38, 49, 76, 97, 65]

    }

}

