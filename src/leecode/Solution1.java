package leecode;

import java.util.*;

public class Solution1 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int lSs(String s) {
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        int cl = matrix.length;
        int rl = matrix[0].length;
        int max = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < cl; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < rl; j++) {
                if (matrix[i][0] == 0) {
                    temp.append(matrix[i][j]);
                } else {
                    temp.append((matrix[i][j] ^ 1));
                }
            }
            String tempStr = temp.toString();
            max = Math.max(map.getOrDefault(tempStr, 0) + 1, max);
            map.put(tempStr, map.getOrDefault(tempStr, 0) + 1);
        }
        return max;
    }
//    int[][] arr = {{0, 1}, {1, 1}};//1
//    int[][] arr1 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};//2
//        System.out.println(maxEqualRowsAfterFlips(arr));
//        System.out.println(maxEqualRowsAfterFlips(arr1));


    public static int findUnsortedSubarray(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int len = 0;
        while (i <= j) {
            int l = 0;
            if(i == j){
                len = 0;
                break;
            }
            if (nums[i] == Min(nums, i, j)) {
                i++;
            }
            if (nums[j] == Max(nums, i, j)) {
                j--;
            }
            l = j - i + 1;
            if (l == len) {
                break;
            }
            len = l;
        }
        return len;
    }

    public static int Min(int[] nums, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j + 1; k++) {
            min = Math.min(nums[k], min);
        }
        return min;
    }

    public static int Max(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int k = i; k < j + 1; k++) {
            max = Math.max(nums[k], max);
        }
        return max;
    }
    //int[] nums = {2, 6, 4, 8, 10, 9, 15};
    //int[] nums = {1,2,3,3,5,6};
//    int[] nums = {1, 2, 3, 3, 3};
//        System.out.println(findUnsortedSubarray(nums));

    public static int triangleNumber(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            for (int j = i + 1; j < len ; j++) {
                int k = j + 1;
                while (k < len && nums[k++] < nums[i] + nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int triangleNumber1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;
            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4};
        //int[] arr = {2, 3, 4, 4};
        System.out.println(triangleNumber(arr));
    }
}
