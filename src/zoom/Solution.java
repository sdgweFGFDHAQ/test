package zoom;

import java.util.*;

/**
 * @Author 1
 * @Date 2021/8/28
 * @Description IntelliJ IDEA
 **/
public class Solution {

    public static int find132Pattern(int[] nums) {
        // write code here
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] < nums[k] && nums[k] < nums[j]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                k = Math.max(k, deque.pollLast());
            }
            deque.addLast(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ans = null;

        String[] substring = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int len = substring.length;
        ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = Integer.parseInt(substring[i]);
        }

        System.out.println(find132Pattern(ans));

    }
}

