package leecode;

import java.util.*;

/**
 * @Author 1
 * @Date 2021/9/14
 * @Description IntelliJ IDEA
 **/
public class Solution6 {
    public String findLongestWord(String s, List<String> dictionary) {
        int size = dictionary.size();
        int length = s.length();
        int max = 0;
        String t = "";
        for (String sub : dictionary) {
            int i = 0, j = 0;
            int len = sub.length();
            while (i < length && j < len) {
                if (s.charAt(i) == sub.charAt(j)) {
                    i++;
                    j++;
                } else i++;
            }
            if (j == len) {
                if (len > max) {
                    max = len;
                    t = sub;
                } else if (len == max) t = t.compareTo(sub) > 0 ? sub : t;
            }
        }
        return t;
    }

    public int findPeakElement(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int t = -1;
        while (i < j) {
            t = i + (i + j) / 2;
            if (nums[t] > nums[t + 1]) {
                j = t;
            } else i = t + 1;
        }
        return nums[t];
    }

    Set<String> set = new HashSet<>();
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis = new boolean[15][15];
    List<String> ans = new ArrayList<>();
    int m, n;
    char[][] board1;

    public List<String> findWords(char[][] board, String[] words) {
        board1 = board;
        m = board.length;
        n = board[0].length;
        StringBuilder sb = new StringBuilder();
        //set.addAll(Arrays.asList(words));
        for (String word : words) set.add(word);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = true;
                sb.append(board[i][j]);
                dfs(i, j, sb);
                sb.deleteCharAt(sb.length() - 1);
                vis[i][j] = false;
            }
        }
        return ans;
    }

    public void dfs(int i, int j, StringBuilder sb) {
        if (sb.length() > 10) return;
        String s = sb.toString();
        if (set.contains(s)) {
            ans.add(s);
            set.remove(s);
        }
        for (int[] d : dirs) {
            int i1 = i + d[0], j1 = j + d[1];
            if (i1 < 0 || i1 > m - 1 || j1 < 0 || j1 > n - 1) continue;
            if (vis[i1][j1]) continue;
            vis[i1][j1] = true;
            sb.append(board1[i1][j1]);
            dfs(i1, j1, sb);
            sb.deleteCharAt(sb.length() - 1);
            vis[i1][j1] = false;
        }
    }


    public static int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int bit_a = (a >> i) & 1;
            int bit_b = (b >> i) & 1;
            int bit_c = (c >> i) & 1;
            if (bit_c == 0) {
                ans += bit_a + bit_b;
            } else {
                if (bit_a + bit_b == 0) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public int minSteps(int n) {
        int[] f = new int[n + 1];
        for (int i = 2; i <= n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; ++j) {
                if (i % j == 0) {
                    f[i] = Math.min(f[i], f[j] + i / j);
                    f[i] = Math.min(f[i], f[i / j] + j);
                }
            }
        }
        return f[n];
    }

    public int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            int l = 1;
            int pre = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > pre) {
                    l++;
                    pre = nums[j];
                }
            }
            map.put(l, map.getOrDefault(l, 0) + 1);
        }
        int m = -1;
        for (int k : map.keySet()) {
            m = Math.max(m, k);
        }
        return map.get(m);
    }

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, m = 0, n = 0, max = 0;
        for (int k = 0; k < fruits.length; k++) {
            m = fruits[k];
            i++;
            if(fruits[k] == m){
                i++;
            }else {
                n = fruits[k];
                j++;
            }
            if(fruits[k] == n){
                j++;
            }else {
                max = Math.max(max, i + j);
                m = n;
                i = j;
            }

        }
        return max;
    }
    
    public static void main(String[] args) {
        Solution6 s6 = new Solution6();
        int[] a = new int[]{1, 3, 5, 4, 7};
        System.out.println(s6.findNumberOfLIS(a));
    }
}

