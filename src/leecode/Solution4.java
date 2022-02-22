package leecode;

import java.util.*;

public class Solution4 {
    public int longestConsecutive(int[] nums) {
        int maxl = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], (hashMap.getOrDefault(nums[i], 0)));
            hashMap.put(nums[i] - 1, hashMap.get(nums[i] - 1) + 1);
            hashMap.put(nums[i] + 1, hashMap.get(nums[i] + 1) + 1);
        }
        return maxl;
    }

    public void t() {
        int[] n = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(n));
    }


    public static int getLucky(String s, int k) {
        int re = 0;
        int count = 1;
        StringBuilder sB = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            sB.append(s.charAt(i) - 96);
        }
        String substring = sB.substring(0);
        while (count <= k) {
            int sum = 0;
            for (int i = 0; i < substring.length(); i++) {
                sum += Integer.parseInt(String.valueOf(substring.charAt(i)));
            }
            substring = Integer.toString(sum);
            re = sum;
            count++;
        }
        return re;
    }


    public static String maximumNumber(String num, int[] change) {
        StringBuilder replace = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int n = Integer.parseInt(String.valueOf(num.charAt(i)));
            int b = change[n];
            if (n < b) {
                n = b;
            }
            replace.append(n);
        }
        String s = replace.toString();
        return s;
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Integer> mapm = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < adjacentPairs.length; i++) {
            map.put(adjacentPairs[i][0], map.getOrDefault(adjacentPairs[i][0], 0) + 1);
            map.put(adjacentPairs[i][1], map.getOrDefault(adjacentPairs[i][1], 0) + 1);
        }

        for (int i = 0; i < adjacentPairs.length; i++) {
            if (map.get(adjacentPairs[i][0]) == 1) {
                arrayList.add(adjacentPairs[i][0]);
            } else if (map.get(adjacentPairs[i][1]) == 1) {
                arrayList.add(adjacentPairs[i][1]);
            }

            if (adjacentPairs[i][0] > adjacentPairs[i][1] && !mapm.containsKey(adjacentPairs[i][1])) {
                int t = adjacentPairs[i][0];
                adjacentPairs[i][0] = adjacentPairs[i][1];
                adjacentPairs[i][1] = t;
            }
            mapm.put(adjacentPairs[i][0], adjacentPairs[i][1]);
        }

        System.out.println(map);
        System.out.println(arrayList);
        System.out.println(mapm);


        x = arrayList.get(0);
        arr.add(x);
        while (x != arrayList.get(1)) {
            x = map.get(x);
            arr.add(x);
        }
        arr.add(x);
        System.out.println(arr);
        return null;
    }
//    int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
//    int[][] a={{4, 5}, {6, 4}, {6, 1}};
//        System.out.println(restoreArray(a));


//    public int countArrangement(int n) {
//        if(n == 0){
//            return 0;
//        }
//        int count = 0;
//
//    }

    public static int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][2][3]; // 长度，A 的数量，结尾连续 L 的数量
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以 P 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 2; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }
            // 以 A 结尾的数量
            for (int k = 0; k <= 2; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
            // 以 L 结尾的数量
            for (int j = 0; j <= 1; j++) {
                for (int k = 1; k <= 2; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int j = 0; j <= 1; j++) {
            for (int k = 0; k <= 2; k++) {
                sum = (sum + dp[n][j][k]) % MOD;
            }
        }
        return sum;
    }

    public static int compress(char[] chars) {
        int n = chars.length;
        int write = 0, left = 0;
        for (int read = 0; read < n; read++) {
            if (read == n - 1 || chars[read] != chars[read + 1]) {
                chars[write++] = chars[read];
                int num = read - left + 1;
                if (num > 1) {
                    int anchor = write;
                    while (num > 0) {
                        chars[write++] = (char) (num % 10 + '0');
                        num /= 10;
                    }
                    reverse(chars, anchor, write - 1);
                }
                left = read + 1;
            }
        }
        return write;
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    public static int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int[] arr = new int[n + 1];
            int re = 0;
            arr[0] = 0;
            arr[1] = 1;
            for (int i = 0; i < n + 1; i++) {
                int a = 2 * i;
                int b = 2 * i + 1;
                if (a >= 2 && a <= n) {
                    arr[a] = arr[i];
                }
                if (b >= 2 && b <= n) {
                    arr[b] = arr[i] + arr[i + 1];
                }
                re = Math.max(re, arr[i]);
            }
            return re;
        }

    }

    public static int numTeams(int[] rating) {
        int n = rating.length;
        if (n <= 2) {
            return 0;   //总共没有3个士兵
        }
        int[] minToMax2 = new int[n];     //minToMax2[j]代表,i->j中间有多少数rating[j]小
        int[] maxToMin2 = new int[n];     //maxToMin2[j]代表,i->j中间有多少数rating[j]大
        int i, j, result = 0;
        for (i = 0; i < n; i++) {
            minToMax2[i] = 0;
            maxToMin2[i] = 0;
            for (j = i - 1; j >= 0; j--) {
                if (rating[i] > rating[j]) {
                    minToMax2[i]++;     //计算有多少数比rating[i]小
                    result += minToMax2[j];       //rating[i]>rating[j],rating[j]比minToMax2[j]个下标小于j的数大,所以{rating[k](k<j)<rating[j]<rating[i]}共有minToMax2[j种情况]
                }
                if (rating[i] < rating[j]) {
                    maxToMin2[i]++;
                    result += maxToMin2[j];
                }
            }
        }
        return result;
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int MAX = 1000 * 101 + 1;
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], MAX);
        }
        dp[0][src] = 0;
        for (int i = 1; i < k + 2; i++) {
            for (int[] flight : flights) {
                int start = flight[0], end = flight[1], distance = flight[2];
                System.out.println(dp[i][end]);
                System.out.println(dp[i - 1][start] + distance);
                dp[i][end] = Math.min(dp[i][end], dp[i - 1][start] + distance);
            }
        }
        int ans = MAX;
        for (int i = 1; i < k + 2; i++) {
            ans = Math.min(ans, dp[i][dst]);
        }

        return ans == MAX ? -1 : ans;

    }
//    int n = 3;
//    int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
//    int src = 0, dst = 2, k = 1;
//        System.out.println(findCheapestPrice(n, edges, src, dst, k));

    public boolean isBoomerang(int[][] points) {
        return (points[2][1] - points[1][1]) * (points[0][0] - points[1][0]) != (points[2][0] - points[1][0]) * (points[0][1] - points[1][1]);
    }

    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        int ans = 0;

        for (int k = 1; k < 100000; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 2; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }
        for (int k = 1; k < 100000; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for (int i = sb.length() - 1; i >= 0; --i)
                sb.append(sb.charAt(i));
            long v = Long.parseLong(sb.toString());
            v *= v;
            if (v > R) break;
            if (v >= L && isPalindrome(v)) ans++;
        }

        return ans;
    }

    public boolean isPalindrome(long v) {
        long x = v;
        long ans = 0;
        while (x > 0) {
            ans = 10 * ans + x % 10;
            x /= 10;
        }
        return v == ans;

    }

    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            ans++;
        }
        return ans;
    }

    //    int[] people = {1,2};
//    int limit = 3;
//        System.out.println(s4.numRescueBoats(people, limit));
    public int maxArea(int[] height) {
        int l = 0;
        int length = height.length;
        int r = length - 1;
        int area = 0;
        int temp = 0;
        while (l < r) {
            int t = 0;
            if (height[l] < height[r]) {
                t = height[l];
                temp = (r - l) * t;
                l++;
            } else {
                t = height[r];
                temp = (r - l) * t;
                r--;
            }
            area = Math.max(area, temp);
        }
        return area;
    }

    public int lastRemaining(int n) {
        return f(1, 1, n);
    }

    public static int f(int start, int step, int n) {
        if (n == 1) return 1;
        return f(start + (n - 1 - (n & 1)) * step, step * 2, n / 2);
    }

    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        int count = 1;
        int length = nums.length;
        int max = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] - 1 == nums[i - 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
            if (i == length - 1) {
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        boolean match = true;
        for (int l = 1; l * 2 <= len; l++) {
            match = true;
            if (len % l == 0) {
                for (int i = l; i < len; i++) {
                    if (s.charAt(i) != s.charAt(i - l)) {
                        match = false;
                        break;
                    }
                }
            }
        }
        return match;
    }

    public static int maxSumDivThree(int[] nums) {
        Queue<Integer> q1 = new PriorityQueue<>();
        Queue<Integer> q2 = new PriorityQueue<>();
        int sum = 0;
        for (int n : nums) {
            if (n % 3 == 1) q1.add(n);
            if (n % 3 == 2) q2.add(n);
            sum += n;
        }
        if (sum % 3 == 1) {
            if (q1.size() > 0 && q2.size() > 1) {
                sum = Math.max(sum - q1.poll(), sum - q2.poll() - q2.poll());
            } else if (q1.size() > 0) {
                sum = sum - q1.poll();
            } else return 0;
        }
        if (sum % 3 == 2) {
            if (q1.size() > 1 && q2.size() > 0) {
                sum = Math.max(sum - q1.poll() - q1.poll(), sum - q2.poll());
            } else if (q2.size() > 0) {
                sum = sum - q2.poll();
            } else return 0;
        }
        return sum;
    }

    public static boolean checkValidString(String s) {
        Stack<Integer> kh = new Stack<>();
        Stack<Integer> xh = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                kh.push(i);
            } else if (s.charAt(i) == '*') {
                xh.push(i);
            } else {
                if (!kh.isEmpty()) {
                    kh.pop();
                } else if (!xh.isEmpty()) {
                    xh.pop();
                } else return false;

            }
        }

        if (kh.size() > xh.size()) return false;
        while (!kh.isEmpty()) {
            int i1 = kh.pop();
            int i2 = xh.pop();
            if (i1 > i2) return false;
        }
        return true;
//        while (!kh.isEmpty() && !xh.isEmpty()){
//            int i1 = kh.poll();
//            int i2 = xh.poll();
//            if(i1 > i2) return false;
//        }
//        return kh.isEmpty();
    }

    List<List<String>> ans = new ArrayList<List<String>>();
    List<String> res = new ArrayList<>();
    int len;
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        len = s.length();
        dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }
        huiwen(s, 0);
        return ans;
    }

    public void huiwen(String s, int index) {
        if (index == len) {
            ans.add(new ArrayList<>(res));
            return;
        }

        for (int i = index; i < len; i++) {
            if (dp[index][i]) {
                res.add(s.substring(index, i + 1));
                huiwen(s, i + 1);
                res.remove(res.size() - 1);
            }

        }

    }

    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p : points) {
            Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
            for (int[] q : points) {
                int dis = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                cnt.put(dis, cnt.getOrDefault(dis, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution4 s4 = new Solution4();
        //System.out.println(s4.longestConsecutive1(new int[]{0,1,1,2}));
//        String s = "abab";
//        System.out.println(repeatedSubstringPattern(s));
//        int[] a = new int[]{3, 6, 5, 1, 8};
//        System.out.println(maxSumDivThree(a));
//        String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
//        System.out.println(checkValidString(s));

//        String s = "aab";
//        System.out.println(s4.partition(s));

        int[][] arr = new int[][]{{1, 1}, {2, 2}, {3, 3}};
        System.out.println(s4.numberOfBoomerangs(arr));
    }
}

