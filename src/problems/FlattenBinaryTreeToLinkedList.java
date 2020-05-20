package problems;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        List<Integer> linkedList = inorder(root, new ArrayList<>());
        root.left = null;
        for (int i = 1; i<linkedList.size(); i++) {
            root.right = new TreeNode(linkedList.get(i));
            root = root.right;
        }
    }

    public List<Integer> inorder(TreeNode node, List<Integer> temp) {
        temp.add(node.val);
        if (node.left != null) {
            inorder(node.left, temp);
        }
        if (node.right != null) {
            inorder(node.right, temp);
        }
        return temp;
    }


    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5, null, six);
        TreeNode two = new TreeNode(2, three, four);
        TreeNode one = new TreeNode(1, two, five);
        flattenBinaryTreeToLinkedList.flatten(one);
        System.out.println(one);
    }
}
