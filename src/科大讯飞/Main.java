package 科大讯飞;

import java.util.*;

public class Main {
    static int min = 1000000;
    static List<String> list;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int num = 0;
        boolean[][] ch = new boolean[n][m];
        list = new ArrayList<>();
        while (sc.hasNextLine()) {
            String next = sc.nextLine();
            list.add(next);
        }
        int s1 = 0, s2 = 0;
        dfs(s1, s2, ch, num);
        System.out.print(num);
    }

    static void dfs(int s1, int s2, boolean[][] ch, int num) {
        if (s1 == ch.length - 1 && s2 == ch[0].length - 1) {
            min = Math.min(min, num);
        }
        char c = list.get(s1).charAt(s2);
        if ("#".equals(String.valueOf(c))) {
            num++;
        }

        for (int i = 0; i < 4; i++) {
            int p1 = s1 + dir[i][0];
            int p2 = s2 + dir[i][1];
            if ((p1 >= 0 && p1 < ch.length) && (p2 >= 0 && p2 < ch[0].length) && !ch[p1][p2]) {
                ch[p1][p2] = true;
                dfs(p1, p2, ch, num);
                ch[p1][p2] = false;
            }
        }
    }
}