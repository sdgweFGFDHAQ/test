package leecode;

import java.util.Arrays;
//a^b^a=a
public class Swap_ab {
    public int[] swapNumbers(int[] nums) {
        nums[1] = nums[0] ^ nums[1];
        nums[0] = nums[0] ^ nums[1];
        nums[1] = nums[0] ^ nums[1];
        return nums;
    }

    public static void main(String[] args) {
        Swap_ab swap_ab = new Swap_ab();
        int[] nums = {5, 4};

        System.out.println(Arrays.toString(swap_ab.swapNumbers(nums)));
    }

}
