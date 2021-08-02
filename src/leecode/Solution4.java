package leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

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

    @Test
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

    public static int[] restoreArray(int[][] adjacentPairs){
        HashMap<Integer, Integer> mapm = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> arrayList=new ArrayList<>();
        ArrayList<Integer> arr=new ArrayList<>();
        int x=0;
        for (int i = 0; i < adjacentPairs.length; i++) {
            map.put(adjacentPairs[i][0],map.getOrDefault(adjacentPairs[i][0],0)+1);
            map.put(adjacentPairs[i][1],map.getOrDefault(adjacentPairs[i][1],0)+1);
        }

        for (int i = 0; i < adjacentPairs.length; i++) {
            if(map.get(adjacentPairs[i][0])==1 ){
                arrayList.add(adjacentPairs[i][0]);
            }else if(map.get(adjacentPairs[i][1])==1){
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


        x=arrayList.get(0);
        arr.add(x);
        while(x!=arrayList.get(1)){
            x=map.get(x);
            arr.add(x);
        }
        arr.add(x);
        System.out.println(arr);
        return null;
    }



    public static void main(String[] args) {
        int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
        int[][] a={{4, 5}, {6, 4}, {6, 1}};
        System.out.println(restoreArray(a));
    }
}


