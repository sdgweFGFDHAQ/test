package leecode;

import java.util.*;

/**
 * @Author 1
 * @Date 2021/8/2
 * @Description IntelliJ IDEA
 **/
public class Solution7 {

    public int networkDelayTime(int[][] times, int n, int k) {

        return 1;
    }

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (x * i + y * j <= bound) {
            double a1 = Math.pow(x, i);
            double b1 = Math.pow(y, j);
            list.add((int) (a1 + b1));
            double a2 = Math.pow(x, i + 1);
            double b2 = Math.pow(y, j + 1);
            if (a1 + b2 <= a2 + b1) {
                j++;
            } else {
                i++;
            }
        }
        return list;
    }

    public static String char_and_num_return(String text_source) {
        // write code here
        String[] t = text_source.split(" ");
        Queue<Integer> q = new PriorityQueue<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            int v = t[i].charAt(0) - 'A';
            if (v >= 0) sb2.append(t[i]).append(" ");
            else q.add(Integer.parseInt(t[i]));
        }
        for (int i : q) {
            sb1.append(i).append(" ");
        }
        String ss = sb2.append(sb1).toString();
        return ss.substring(0, ss.length() - 1);
    }

    public static int singleNonDuplicate(int[] nums) {
        int num = -1;
        int len = nums.length;
        int l = 0, r = len - 1;
        while(l != r){
            int t = ( l + r) / 2;
            if(nums[t - 1] == nums[t]){
                r = t;
            }else if(nums[t] == nums[t + 1]){
                l = t;
            }else {
                num = nums[t];
            }
        }
        return num;
    }

    public static String pushDominoes(String dominoes) {
        String result = "";
        StringBuilder sb = new StringBuilder();
        int len = dominoes.length();
        for(int i = 0; i < len; i++){
            if(i == 0){
                
            }else if(i == len - 1){

            }else {

            }
        }
        result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(nums));
    }
}
