package leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author 1
 * @Date 2021/9/5
 * @Description IntelliJ IDEA
 **/
public class Solution5 {
    public int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public int rand10() {
        double d;
        d = (double) rand7() / 7;
        return (int) (d * 10);
    }

    public int countQuadruplets(int[] nums) {
        int[] arrays = Arrays.copyOf(nums, nums.length);
        int count = 0;
        int length = arrays.length;
        Arrays.sort(arrays);
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    for (int l = k + 1; l < length; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        int nums = properties.length;
        int c = 0;
        int[] bp = new int[nums];
        for (int i = 0; i < nums - 1; i++) {
            int a = properties[i][0];
            int d = properties[i][1];
            if (bp[i] != 1) {
                for (int j = i + 1; j < nums; j++) {
                    if (properties[j][0] > a && properties[j][1] > d) {
                        bp[i] = 1;
                    }
                    if (properties[j][0] < a && properties[j][1] < d) {
                        bp[j] = 1;
                    }
                }
            }
        }
        for (int j : bp) {
            if (j == 1) {
                c++;
            }
        }
        return c;
    }


    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int length = nextVisit.length;
        int day = 0;
        int i = 1 << length;
        while ((i & 1) != i) {

            day++;
        }
        return day;
    }

    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) >> 1;
        int m = -2;
        while (m != mid) {
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
            m = mid;
            mid = (l + r) >> 1;
        }
        return -1;
    }

    public boolean oneEditAway(String first, String second) {
        int f = first.length();
        int s = second.length();

        if (Math.abs(f - s) > 1) return false;
        if (first.equals(second)) return true;

        int count = 0;    // 记录不匹配的次数。
        int i = 0, j = 0; // 用来指向两字符串的指针
        while (i < f && j < s) {
            // 两个字符串从前往后开始遍历，如果当前两字符串字符相同就继续比较下一个。
            if (first.charAt(i++) == second.charAt(j++)) {
                continue;
            }
            count++;
            if (count > 1) return false;

            if (f != s) { // 若不相等，则将短字符串指针前移一位
                if (f > s) j--;
                else i--;
            }
        }
        return true;
    }

    public int balancedStringSplit(String s) {
        int length = s.length();
        int l = 0;
        int r = 0;
        int c = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'L') {
                l++;
            }
            if (s.charAt(i) == 'R') {
                r++;
            }
            if (l == r && l != 0) {
                c++;
                l = 0;
                r = 0;
            }
        }
        return c;
    }


    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean dl = dfs(root.left, p, q);
        boolean dr = dfs(root.right, p, q);
        if ((dl && dr) || ((root.val == p.val || root.val == q.val) && (dl || dr))) {
            ans = root;
        }
        return dl || dr || (root.val == p.val) || (root.val == q.val);
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(len, (o1, o2) -> o2 - o1);
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < len && arr[index][0] <= w) {
                queue.offer(arr[index][1]);
                index++;
            }
            if (!queue.isEmpty())
                w += queue.poll();
        }
        return w;
    }

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int length = chalk.length;
        for (int c : chalk) {
            sum += c;
        }
        long num = k % sum;
        for (int i = 0; i < length; i++) {
            num -= chalk[i];
            if(num < 0){
                return i;
            }else if(num == 0){
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution5 s5 = new Solution5();
        int[][] a = {{1, 5}, {10, 4}, {8, 3}};

        //System.out.println(s5.numberOfWeakCharacters(a));
//        String s1 = "ab";
//        String s2 = "bc";
//        System.out.println(s5.oneEditAway(s1, s2));
//        System.out.println(-3>>>31);

//        int k = 2, w = 0;
//        int[] p = {1, 2, 3};
//        int[] c = {0, 1, 1};
//        System.out.println(findMaximizedCapital(k, w, p, c));



    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}