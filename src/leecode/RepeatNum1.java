package leecode;

public class RepeatNum1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean b = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (j - i <= k) {
                        b = true;
                    }
                }
            }
        }
        return b;
    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1,2,3};
        RepeatNum1 r=new RepeatNum1();
        System.out.println(r.containsNearbyDuplicate(num, 2));
    }
}
