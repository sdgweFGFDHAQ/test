package xiecheng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Author 1
 * @Date 2021/9/9
 * @Description IntelliJ IDEA
 **/
public class Solution {
    public static void test() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("\\");
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            //System.out.println(Arrays.toString(s));
            if (s[0].equals("cd")) {
                if (!s[1].equals("..")) {
                    if (sb.toString().equals("\\")) {
                        sb.append(s[1]);
                    } else {
                        sb.append("\\");
                        sb.append(s[1]);
                    }
                } else {
                    int index = sb.lastIndexOf("\\");
                    sb.delete(index, sb.length());
                    if (sb.toString().isEmpty()) {
                        sb.append("\\");
                    }
                }
            } else {
                System.out.println(sb.toString());
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        HashMap map = new HashMap();
        for (int i = 1; i < 101; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            int core = scanner.nextInt();
            map.put(num, core);
        }

        int scores = 0;
        int temp = 0;
        int c = 0;
        for (int i = 0; i < len + 1; i++) {
            if (i == len || s.charAt(i) != '1') {
                temp = max(c, map);
                scores += temp;
                c = 0;
            } else {
                c += 1;
            }

        }
        System.out.println(scores);
    }

    public static int max(int c, HashMap map) {
        int[] dp = new int[c + 1];
        dp[0] = 0;
        for (int i = 1; i < c + 1; i++) {
            dp[i] = Math.max(dp[i - 1] + (int) map.get(1), (int) map.get(i));
        }
        return dp[c];
    }
}

class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ss = br.readLine();
        String[] sss = ss.split(" ");
        int line = Integer.parseInt(sss[1]);
        char[] nums = br.readLine().toCharArray();  // 01序列
        int[][] wvs = new int[line + 1][2];
        for (int i = 1; i <= line; i++) {
            String[] wv = br.readLine().split(" ");
            wvs[i][0] = Integer.parseInt(wv[0]);
            wvs[i][1] = Integer.parseInt(wv[1]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '0') {
                continue;
            }
            int W = 0;
            while (i < nums.length && nums[i] == '1') {
                W++;
                i++;
            }
            list.add(W);
            i--;
        }
        int res = 0;
        for (Integer W : list) {
            res += maxValue(W, wvs);
        }
        System.out.println(res);
    }

    public static int maxValue(int V, int[][] wv) {
        int N = wv.length - 1;
        int[] dp = new int[V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                if (j >= wv[i][0]) {
                    dp[j] = Math.max(dp[j - wv[i][0]] + wv[i][1], dp[j]);
                }
            }
        }
        return dp[V];
    }
}
