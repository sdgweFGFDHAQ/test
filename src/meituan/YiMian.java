package meituan;

/**
 * @Author 1
 * @Date 2021/9/7
 * @Description IntelliJ IDEA
 **/
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class YiMian {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
//        String a = new String("ab");
//        String b = new String("ab");
//        String c = "ab";
//        String d = "a";
//        String e = new String("b");
//        String f = d + e;
//
//        System.out.println(a.intern() == b);
//        System.out.println(a.intern() == b.intern());
//        System.out.println(a.intern() == c);
//        System.out.println(a.intern() == f);

        //String t0 = "hello";
        //String t1 = new String("hello");
        //System.out.println(t0 == t1);
        String t1 = new String("he") + new String("llo");
        t1.intern();
        String t2 = "hello";
        System.out.println(t2 == t1);

        String t3 = new String("wo") + new String("rld");
        String t4 = "world";
        t3.intern();
        System.out.println(t3 == t4);
    }
}
