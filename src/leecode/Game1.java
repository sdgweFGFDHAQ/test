package leecode;

import java.util.HashMap;

public class Game1 {
    public int longestConsecutive(String text, String brokenLetters) {
        int maxl = 0;
        String[] stext = text.split(" ");
        for (String s : stext) {
            boolean b = true;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < brokenLetters.length(); j++) {
                    if (s.charAt(i) == brokenLetters.charAt(j)) {
                        b = false;
                    }
                }
            }
            if (b == true) {
                maxl++;
            }

        }
        return maxl;
    }

    public static int addRungs(int[] rungs, int dist) {
        int num = 0;
        int add = 0;
        for (int i = 0; i < rungs.length; i++) {
            int dis = rungs[i] - add;
            add = rungs[i];
            if (dis > dist) {
                int n = dis % dist;
                if (n == 0) {
                    num += dis / dist - 1;
                } else {
                    num += dis / dist;
                }

            }
        }
        return num;
    }

    public static long maxPoints(int[][] points) {
        long maxp = 0;
        
        for (int r = 0; r < points.length; r++) {
            for (int c = 0; c < points[r].length; c++) {
                HashMap<Integer,Integer> map=new HashMap<>();
                long point = 0;
                for (int r1 = 0; r1 < points.length; r1++) {
                    point+=points[r][0];
                }
                point += points[r][0];
                maxp = Math.max(maxp, point);
            }

        }


        return maxp;
    }

    public static void main(String[] args) {
        int[][] p = {{1, 5}, {2, 3}, {4, 2}};
        System.out.println(maxPoints(p));
    }
}
