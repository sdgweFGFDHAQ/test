package TesT.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 1
 * @Date 2021/10/8
 * @Description IntelliJ IDEA
 * 升序字典序全排列
 **/
public class QuanPaiLie2 {
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         *
         *
         * @param nums int整型一维数组
         * @return int整型二维数组
         */
        //这个方法用于获取下一个字典序的数组
        private static int[] getNext(int[] nums){
            int n = nums.length;
            int head = -1,tail = -1;
            for(int i = n - 1;i > 0;i--){
                if(nums[i] > nums[i - 1]){
                    head = i - 1;break;
                }
            }
            if(head == -1) return null;
            for(int i = n - 1;i > head;i--){
                if(nums[i] > nums[head]){
                    tail = i;break;
                }
            }
            int swap = nums[head];nums[head] = nums[tail];nums[tail] = swap;
            Arrays.sort(nums,head + 1,n);
            return nums;
        }

        public int[][] UniquePerm (int[] nums) {
            // write code here
            int n = nums.length;
            List<int[]> res = new ArrayList<>();
            Arrays.sort(nums);
            int []newN = new int[nums.length];
            for(int i = 0;i < newN.length;i++){
                newN[i] = nums[i];
            }
            res.add(newN);
            while(true){
                nums = getNext(nums);
                if(nums == null) break;
                int[] ins = new int[nums.length];
                for(int i = 0;i < nums.length;i++){
                    ins[i] = nums[i];
                }
                res.add(ins);
            }
            int [][]result = new int[res.size()][n];
            for(int i = 0;i < res.size();i++){
                result[i] = res.get(i);
            }
            return result;
        }
}
