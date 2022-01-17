package leecode;


import java.util.*;
import java.util.stream.IntStream;

public class Solution3 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = null;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int ll = String.valueOf(low).length();
        int hl = String.valueOf(high).length();
        int lc = String.valueOf(low).charAt(0);
        int hc = String.valueOf(high).charAt(0);
        for (int wei = 1; wei <= 9; wei++) {
            for (int i = 1; i <= 9; i++) {
                if (i + wei <= 10) {
                    int i1 = Integer.parseInt(String.valueOf(arr).substring(i, i + wei));
                    if (low <= i1 && i1 <= high) {
                        list.add(i1);
                    }
                }

            }
        }

        return list;
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pqueue = new PriorityQueue<>();
        set.add(1L);
        pqueue.offer(1L);
        int re = 0;
        for (int i = 0; i < n; i++) {
            long poll = pqueue.poll();
            re = (int) poll;
            for (int p : primes) {
                Long num = poll * p;
                if (set.add(num)) {
                    pqueue.offer(num);
                }
            }

        }
        return re;
    }

    public static List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();
        String[] words = s.split(" ");

        int len = Arrays.stream(words).flatMapToInt((cur -> IntStream.of(cur.length()))).max().orElse(0);
        //stream 将数组放入stream中，调用max()
        //Collection 将int转换成Integer，调用Collection的max()
        //sort() 缺点是会改变数组顺序

        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else sb.append(" ");
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        } else {
            int left = 0;
            int right = 3;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int index = right;
                while (index <= nums.length && nums[index - 1] - nums[index - 2] == nums[index - 2] - nums[index - 3]) {
                    count++;
                    index++;
                }
                left++;
                right++;
            }
            return count;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int sumEvenGrandparent(TreeNode root) {
        int count = 0;

        if (root.val % 2 == 0) {
            count += tree(root);
        }
        if (root.left != null) {
            count += sumEvenGrandparent(root.left);
        }
        if (root.right != null) {
            count += sumEvenGrandparent(root.right);
        }
        return count;
    }

    public static int tree(TreeNode tn) {
        int c = 0;
        TreeNode left = tn.left;
        TreeNode right = tn.right;
        if (left != null) {
            if (left.left != null) {
                c += left.left.val;
            }
            if (left.right != null) {
                c += left.right.val;
            }

        }
        if (right != null) {
            if (right.left != null) {
                c += right.left.val;
            }
            if (right.right != null) {
                c += right.right.val;
            }
        }
        return c;
    }

    public static int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char c2 = s.charAt(j);
                if (i != length - 1 && j != 0) {
                    if (c1 == c2) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][length - 1];
    }

    public static int countDigitOne(int n) {
        int re = 0;
        if (n == 0) return re;
        int digit = 0;
        int i = n;
        int highDigit = -1;
        while (i != 0) {
            highDigit = i - 1;
            i /= 10;
            digit++;
        }
        re = highDigit * 10 ^ (highDigit - 1) - 10 ^ (highDigit - 2);
        if (highDigit > 1) {

        } else {
            for (int j = 0; j < digit - 1; j++) {


            }
        }
        return re;
    }

    public static int minFlipsMonoIncr(String s) {

        return 0;
    }

    public static void main(String[] args) {
        String s = "0101100011";
        System.out.println(minFlipsMonoIncr(s));
    }
}