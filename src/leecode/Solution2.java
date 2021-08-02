package leecode;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Solution2 {
    public int numSubarraysWithSum(int @NotNull [] nums, int goal) {
        int count = 0;
        for (int n = 0; n < nums.length; n++) {
            int sum = 0;
            for (int i = n; i < nums.length; i++) {
                sum += nums[i];
                if (sum == goal) {
                    count++;
                }
            }
        }
        return count;
    }

    public int numSubarraysWithSum1(int @NotNull [] nums, int goal) {
        int count = 0;
        int[] new_nums = new int[nums.length + 1];
        int sum = 0;
        for (int num : nums) {
            new_nums[sum]++;
            sum += num;

            if (sum - goal >= 0) {
                count += new_nums[sum - goal];
            }
        }
        return count;
    }

    public static int minPairSum(int[] nums) {
        int maxnum = 0;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int sum = nums[i] + nums[j];
            maxnum = Math.max(sum, maxnum);
        }
        return maxnum;
    }

    public static String convert(String s, int numRows) {
        String news = "";
        int length = s.length();

        try {
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";

    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        Solution2 s = new Solution2();
        System.out.println(s.numSubarraysWithSum1(nums, goal));

        int[] numm = {3, 5, 2, 3};
        System.out.println(minPairSum(numm));

        String s1="0";
        int i=1;
        System.out.println(convert(s1,i));


    }
}
