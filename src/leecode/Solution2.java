package leecode;

import java.util.*;

public class Solution2 {

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
//    int[] nums = {1, 0, 1, 0, 1};
//    int goal = 2;
//    Solution2 s = new Solution2();
//        System.out.println(s.numSubarraysWithSum1(nums, goal));
//
//    int[] numm = {3, 5, 2, 3};
//        System.out.println(minPairSum(numm));
//
//    String s1="0";
//    int i=1;
//        System.out.println(convert(s1,i));

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> endCode = new ArrayList<>();
        for (int value = 0; value < graph.length; value++) {
            if (graph[value].length == 0) {
                endCode.add(value);
            }
        }
        for (int value = 0; value < graph.length; value++) {
            boolean what = true;
            for (int i = 0; i < graph[value].length; i++) {
                what = endCode.contains(graph[value][i]);
                if (!what) {
                    break;
                }
            }
            if (what && !endCode.contains(value)) {
                endCode.add(value);
            }
        }
        Collections.sort(endCode);
        return endCode;
    }
//    int[][] arr = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
//    int[][] temp = {{}, {0, 2, 3, 4}, {3}, {4}, {}};
//        System.out.println(eventualSafeNodes(temp));

    class Solution {
        int n;
        int[] nums;

        public boolean circularArrayLoop(int[] _nums) {
            nums = _nums;
            n = nums.length;
            for (int i = 0; i < n; i++) {
                if (check(i)) return true;
            }
            return false;
        }

        boolean check(int start) {
            int cur = start;
            boolean flag = nums[start] > 0;
            int k = 1;
            while (true) {
                if (k > n) return false;
                int next = ((cur + nums[cur]) % n + n) % n;
                if (flag && nums[next] < 0) return false;
                if (!flag && nums[next] > 0) return false;
                if (next == start) return k > 1;
                cur = next;
                k++;
            }
        }
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, right = 0;
        int max = 0;
        int c = 0;
        while (left < nums.length) {
            if (nums[right] == 1) {
                c++;
                right++;
            } else {
                c = 0;
                right++;
            }
            left++;
            max = Math.max(max, c);
        }
        return max;
    }
    //int[] arr = {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1};
    //System.out.println(findMaxConsecutiveOnes(arr));

    public static String decodeAtIndex(String s, int k) {
        char[] str = s.toCharArray();
        int size = 0;
        int index = -1;
        for (char c : str) {
            index++;
            if (Character.isDigit(c))
                size *= c - '0';
            else size++;
            if (size >= k) break;
        }

        for (int i = index; i >= 0; i--) {
            k %= size;
            if (k == 0 && Character.isLetter(str[i])) return String.valueOf(str[i]);
            if (Character.isDigit(str[i])) {
                size /= str[i] - '0';
            } else size--;
        }
        return "-1";
    }

    public String decodeAtIndex1(String S, int K) {
        if (S == null || S.length() == 0) return S;

        char[] str = S.toCharArray();
        long size = 0;
        int index = -1;
        for (char item : str) {
            index++;
            if (Character.isDigit(item))
                size *= item - '0';
            else size++;
            if (size >= K) break;
        }

        for (int i = index; i >= 0; i--) {
            K %= size;
            if (K == 0 && Character.isLetter(str[i])) return String.valueOf(str[i]);
            if (Character.isDigit(str[i]))
                size /= str[i] - '0';
            else size--;
        }

        return "-1";
    }
//    String s = "y959q969u3hb22odq595";
//    int k = 222280369;
//        System.out.println(decodeAtIndex(s, k));

    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (s.equals(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int n = piles.length;
        int ans = 0;
        for (int i : piles) {
            ans += i;
            q.offer(i);
        }
        while (k-- > 0 && !q.isEmpty()) {
            int x = q.poll();
            int y = (int) Math.floor(x / 2);
            ans -= y;
            if (x - y <= 0) continue;
            q.offer(x - y);
        }
        return ans;
    }

    public double knightProbability(int n, int k, int row, int column){
        double[][][] dp = new double[k + 1][n][n];
        int[][] dirs = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};

        for (int step = 0; step <= k; step++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(step == 0){
                        dp[step][i][j] = 1;
                    }else {
                        for(int[] dir : dirs){
                            int ni = i + dir[0], nj = j + dir[1];
                            if(ni >= 0 && ni <= n && nj >= 0 && nj < n){
                                dp[step][i][j] += dp[step - 1][ni][nj];
                            }
                        }
                    }

                }
            }
        }
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        int[] piles = {5, 4, 9};
        int k = 2;
        System.out.println(minStoneSum(piles, k));

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        q.offer(1);
        q.offer(3);
        q.offer(2);
        System.out.println(q.peek());
        System.out.println(q.poll());
    }
}
