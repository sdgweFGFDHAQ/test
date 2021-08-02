package leecode;

import java.util.HashMap;

public class Moer_Count {
    public int majorityElement(int[] nums) {
        int most_num = 0;
        boolean b=false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (nums.length % 2 == 0) {
                b = map.get(nums[nums.length - 1]) > (nums.length / 2);
            } else {
                b = map.get(nums[nums.length - 1]) >= (nums.length / 2);
            }
        }

        if (b){
            most_num = nums[nums.length - 1];
        }else{
            most_num = -1;
        }


        return most_num;
    }

    public static void main(String[] args) {
        Moer_Count mc = new Moer_Count();
        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(mc.majorityElement(nums));
    }
}
