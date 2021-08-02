package leecode;


import java.util.List;

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
                if(i+wei<=10){
                    int i1 = Integer.parseInt(String.valueOf(arr).substring(i, i+wei));
                    if (low <= i1 && i1 <= high) {
                        list.add(i1);
                    }
                }

            }
        }

        return list;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();

        System.out.println(s.sequentialDigits(100, 300));
    }
}
