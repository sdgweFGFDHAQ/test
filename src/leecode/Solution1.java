package leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    public static void main(String[] args) {

        int[][] arr = {{0, 1}, {1, 1}};//1
        int[][] arr1 = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};//2
        System.out.println(maxEqualRowsAfterFlips(arr));
        System.out.println(maxEqualRowsAfterFlips(arr1));

    }
}
