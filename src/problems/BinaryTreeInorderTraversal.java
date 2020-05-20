//package problems;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class BinaryTreeInorderTraversal {
//    public static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode() {
//        }
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//
//        TreeNode(int val, TreeNode left, TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> traversal = new ArrayList<>();
//        recurse(root, traversal);
//        return traversal;
//    }
//
//    public void recurse(TreeNode root, List<Integer> traversal) {
//        if (root.left != null) {
//            recurse(root.left, traversal);
//        }
//        traversal.add(root.val);
//        if (root.right != null) {
//            recurse(root.right, traversal);
//        }
//    }
//
//    public static void main(String[] args) {
//        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
//        TreeNode three = new TreeNode(3, null, null);
//        TreeNode two = new TreeNode(2, three, null);
//        TreeNode one = new TreeNode(1, null, two);
//
//
//        System.out.println(binaryTreeInorderTraversal.inorderTraversal(one));
//
//    }
//}
