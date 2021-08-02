package leecode;

import java.util.Arrays;

public class FrequceNum {
    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 1, sum = 0;
        int mf = 1;
        while ((j - i + 1) * nums[j] - k <sum){
            sum += nums[i] + nums[j];
        }

        return mf;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 4, 8, 13};
//        int k = 5;
        int[] nums = {9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990,
                9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000,
                9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981,
                9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926,
                9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946,
                9966};
        int k = 3056;
        System.out.println(maxFrequency(nums, k));
    }
}
