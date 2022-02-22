package TesT.treeandgraph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public class Wide {
    /**
     * public class TreeNode {
     * int val = 0;
     * TreeNode left = null;
     * TreeNode right = null;
     * <p>
     * public TreeNode(int val) {
     * this.val = val;
     * <p>
     * }
     * <p>
     * }
     */


//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        ArrayList<Integer> lists = new ArrayList<Integer>();
//        if (root == null)
//            return lists;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            TreeNode tree = queue.poll();
//            if (tree.left != null)
//                queue.offer(tree.left);
//            if (tree.right != null)
//                queue.offer(tree.right);
//            lists.add(tree.val);
//        }
//        return lists;
//    }
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        int[] g = new int[n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') continue;
            int dire = cs[i] == 'L' ? -1 : 1;
            d.add(new int[]{i, 1, dire});
            g[i] = 1;
        }
        while (!d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0], time = info[1], dire = info[2];
            int ne = loc + dire;
            if (cs[loc] == '.' || (ne < 0 || ne >= n)) continue;
            if (g[ne] == 0) { // 首次受力
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) { // 多次受力
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);
    }


    public static void main(String[] args) {
        Wide wide = new Wide();
        String s = "LL..L.R.LRR";
        System.out.println(wide.pushDominoes(s));
        int aa = 1;
        int bb = 1 << aa;
        int a = 3;
        bb = ~bb;
        a = a & bb;
        System.out.println(a);

        a&=~(1<<aa);
        System.out.println(a);
    }


}
