package leecode;

import java.util.PriorityQueue;

/**
 * @Author 1
 * @Date 2021/10/10
 * @Description IntelliJ IDEA
 **/
public class Solution8 {
    private PriorityQueue<int[]> time;
    private PriorityQueue<int[]> value;

    public Solution8() {
        time = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        value = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    }

    public void update(int timestamp, int price) {
        time.add(new int[]{timestamp, price});
        value.add(new int[]{timestamp, price});
    }

    public int current() {
        assert time.peek() != null;
        return time.peek()[1];
    }

    public int maximum() {
        assert value.peek() != null;
        return value.peek()[1];
    }

    public int minimum() {
        assert value.peek() != null;
        return value.peek()[1];
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        boolean l = (len & 1 ) == 0;
        boolean r = bits[len - 2] == 1;
        return !l || !r;
    }

    public static void main(String[] args) {
        Solution8 s8 = new Solution8();
        s8.update(1,2);
        s8.update(2,3);
        s8.update(3,1);
        s8.update(1,4);
        System.out.println(s8.current());
        System.out.println(s8.maximum());
        System.out.println(s8.minimum());
        int[] bits = {1,1,1,0};
        System.out.println(isOneBitCharacter(bits));
    }
}
