package leecode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution0 {
    public int[] twoSum(int[] nums, int target) {
        int[] index_array = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            if (hashMap.get(nums[n]) == null) {
                hashMap.put(nums[n], n);
            } else {
                index_array[0] = hashMap.get(nums[n]);
                index_array[1] = n;
            }

            if (hashMap.get(target - nums[n]) != null) {
                index_array[0] = hashMap.get(target - nums[n]);
                index_array[1] = n;
            }

        }
        return index_array;
    }

    public static int titleToNumber(String columnTitle) {
        int num = 0;
        int sum = 0;
        int n = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            sum += Integer.parseInt(String.valueOf(c)) * 26 * n;
        }
        return num;
    }

    public static int[] nextPermutation(int[] nums) {
        boolean b = false;
        for (int i = nums.length-1; i > 0; i--) {
            while (nums[i]>nums[i-1]){
                if (!b){
                    int t = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = t;
                    b = true;
                }
                break;
            }
        }
        if (!b){
            Arrays.sort(nums);
        }
        return nums;
    }

    public int nthUglyNumber(int n) {
        int[] abc = {2,3,5};
        int count = 1;
        int[] nums = new int[1000];
        nums[1] = 1;
        for (int i = 1; i < 1000; i++) {
            int re = 1;
            for(int j = 0;j < 3;j++){
                re *= abc[j];
            }
        }
        Arrays.sort(nums);
        return nums[n];
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
//        int target = 6;
//        Solution0 s = new Solution0();
//        System.out.println(Arrays.toString(s.twoSum(nums, target)));


//        System.out.println(Arrays.toString(nextPermutation(nums)));

    }
}
