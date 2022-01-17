package leecode;

import java.util.*;

public class Solution0 {
    public int[] twoSum(int[] nums, int target) {
        int[] index_array = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n = 0; n < nums.length; n++) {
            if (hashMap.get(nums[n]) == null) {
                hashMap.put(nums[n], n);
            } else {
                index_array[0] = hashMap.get(nums[n]);
                index_array[1] = n;
            }

            if (hashMap.get(target - nums[n]) != null) {
                index_array[0] = hashMap.get(target - nums[n]);
                index_array[1] = n;
            }

        }
        return index_array;
    }

    public static int titleToNumber(String columnTitle) {
        int num = 0;
        int sum = 0;
        int n = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            sum += Integer.parseInt(String.valueOf(c)) * 26 * n;
        }
        return num;
    }

    public static int[] nextPermutation(int[] nums) {
        boolean b = false;
        for (int i = nums.length - 1; i > 0; i--) {
            while (nums[i] > nums[i - 1]) {
                if (!b) {
                    int t = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = t;
                    b = true;
                }
                break;
            }
        }
        if (!b) {
            Arrays.sort(nums);
        }
        return nums;
    }

    public int nthUglyNumber(int n) {
        int[] abc = {2, 3, 5};
        int count = 1;
        int[] nums = new int[1000];
        nums[1] = 1;
        for (int i = 1; i < 1000; i++) {
            int re = 1;
            for (int j = 0; j < 3; j++) {
                re *= abc[j];
            }
        }
        Arrays.sort(nums);
        return nums[n];
    }

    class MinStack {

        Stack<Integer> stackA, stackB;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void push(int x) {
            stackA.push(x);
            if (stackB.empty() || stackB.peek() >= x) {
                stackB.push(x);
            }
        }

        public void pop() {
            if (stackA.pop().equals(stackB.peek())) {
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    public static int fib(int n) {
        int res = 0;
        int tmp = 1;
        if (n == 0) {
            return res;
        } else if (n == 1) {
            return tmp;
        } else {
            for (int i = 2; i <= n; i++) {
                int t = tmp;
                tmp = res + tmp;
                res = t;
            }
            return tmp;
        }
    }

    public static int motaHP(int[] nums){
        long hp = 1;
        for (int num : nums) {
            hp += num;
        }
        if(hp<=0) return -1;
        hp = 1;
        int c = 0;
        Queue<Integer> q = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                q.offer(nums[i]);
            }
            hp+=nums[i];
            if(hp<=0){
                c++;
                hp-=q.poll();
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
//        int target = 6;
//        Solution0 s = new Solution0();
//        System.out.println(Arrays.toString(s.twoSum(nums, target)));


//        System.out.println(Arrays.toString(nextPermutation(nums)));

//        System.out.println(fib(3));

        //int[] nums = {100,200,100,-250,-100,-100,100};
        //System.out.println(motaHP(nums));
    }
}
