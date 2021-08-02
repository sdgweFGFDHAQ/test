package leecode;

import java.util.Arrays;

public class Peak_and_valley {
    public void wiggleSort(int[] nums) {
        boolean a;
        boolean b;
        int t;
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] == nums[i + 1]) {
                t = nums[i + 1];
                nums[i + 1] = nums[i + 2];
                nums[i + 2] = t;
            } else if (nums[i + 2] == nums[i + 1]) {
                t = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = t;
            } else if((nums[i] < nums[i + 1]) ==
                    (nums[i + 1] < nums[i + 2]))
            {
                t = nums[i + 1];
                nums[i + 1] = nums[i + 2];
                nums[i + 2] = t;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Peak_and_valley pav = new Peak_and_valley();
        int[] nums = {3, 5, 2, 1, 6, 4};
        pav.wiggleSort(nums);
    }
}
