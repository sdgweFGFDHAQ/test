package leecode;

import java.util.PriorityQueue;

/**
 * @Author 1
 * @Date 2021/8/27
 * @Description IntelliJ IDEA
 **/
public class Median {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        System.out.println(m.findMedian());
        m.addNum(-2);
        System.out.println(m.findMedian());

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
        q.offer(3);
        q.offer(5);
        q.add(4);
        q.add(1);
        while (!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}

class MedianFinder {
    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public MedianFinder() {
        queMin = new PriorityQueue<Integer>((a, b) -> (b - a));
        queMax = new PriorityQueue<Integer>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
            queMin.offer(num);
            if (queMax.size() + 1 < queMin.size()) {
                queMax.offer(queMin.poll());
            }
        } else {
            queMax.offer(num);
            if (queMax.size() > queMin.size()) {
                queMin.offer(queMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queMin.size() > queMax.size()) {
            return queMin.peek();
        }
        return (queMin.peek() + queMax.peek()) / 2.0;
    }
}

