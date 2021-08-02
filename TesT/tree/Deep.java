package TesT.tree;

/**
 * @Author 1
 * @Date 2021/7/28
 * @Description IntelliJ IDEA
 **/
public class Deep {
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
    //非递归
//
//    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
//        ArrayList<Integer> lists = new ArrayList<Integer>();
//        if (root == null)
//            return lists;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode tree = stack.pop();　　　　　　//先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
//            if (tree.right != null)
//                stack.push(tree.right);
//            if (tree.left != null)
//                stack.push(tree.left);
//            lists.add(tree.val);
//        }
//        return lists;
//    }
    //递归
//    public void depthOrderTraversalWithRecursive()
//    {
//        depthTraversal(root);
//    }
//
//    private void depthTraversal(TreeNode tn)
//    {
//        if (tn!=null)
//        {
//            System.out.print(tn.value+"  ");
//            depthTraversal(tn.left);
//            depthTraversal(tn.right);
//        }
//    }

}
