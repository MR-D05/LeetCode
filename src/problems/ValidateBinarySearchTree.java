package problems;

public class ValidateBinarySearchTree {
    public static class TreeNode {
        int val;
        ValidateBinarySearchTree.TreeNode left;
        ValidateBinarySearchTree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, ValidateBinarySearchTree.TreeNode left, ValidateBinarySearchTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        if (!helper(node.right, val, upper)) {
            return false;
        }
        return helper(node.left, lower, val);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {

        /*
        Example 1:

            2
           / \
          1   3

        Input: [2,1,3]
        Output: true

        Example 2:

            5
           / \
          1   4
             / \
            3   6

        Input: [5,1,4,null,null,3,6]
        Output: false
        Explanation: The root node's value is 5 but its right child's value is 4.
         */
        ValidateBinarySearchTree ValidateBinarySearchTree = new ValidateBinarySearchTree();
//        TreeNode three = new TreeNode(3, null, null);
//        TreeNode one = new TreeNode(1, null, null);
//        TreeNode two = new TreeNode(2, one, three);

//        TreeNode six = new TreeNode(6, null, null);
//        TreeNode three = new TreeNode(3, null, null);
//        TreeNode four = new TreeNode(4, three, six);
//        TreeNode one = new TreeNode(1, null, null);
//        TreeNode five = new TreeNode(5, one, four);

//        TreeNode six = new TreeNode(6, null, null);
//        TreeNode four = new TreeNode(4, null, null);
//        TreeNode two = new TreeNode(2, null, null);
//        TreeNode zero = new TreeNode(0, null, null);
//        TreeNode five = new TreeNode(5, four, six);
//        TreeNode one = new TreeNode(1, zero, two);
//        TreeNode three = new TreeNode(3, one, five);
        //[3,1,5,0,2,4,6]

        //[3,1,5,0,2,4,6,null,null,null,3]


//        TreeNode twenty = new TreeNode(20, null, null);
//        TreeNode six = new TreeNode(6, null, null);
//        TreeNode fifteen = new TreeNode(15, six, twenty);
//        TreeNode five = new TreeNode(5, null, null);
//        TreeNode ten = new TreeNode(10, five, fifteen);

//        TreeNode three2 = new TreeNode(3, null, null);
//        TreeNode six = new TreeNode(6, null, null);
//        TreeNode four = new TreeNode(4, null, null);
//        TreeNode two = new TreeNode(2, null, three2);
//        TreeNode zero = new TreeNode(0, null, null);
//        TreeNode five = new TreeNode(5, four, six);
//        TreeNode one = new TreeNode(1, zero, two);
//        TreeNode three = new TreeNode(3, one, five);


//        TreeNode negativeFourtyFive = new TreeNode(-45, null, null);
//        TreeNode twentyFive = new TreeNode(25, negativeFourtyFive, null);
//        TreeNode thirtyEight = new TreeNode(38, twentyFive, null);
//        TreeNode negativeEighty = new TreeNode(-80, null, thirtyEight);

        //TreeNode fourtyFive = new TreeNode(45, null, null);
        TreeNode fifteen = new TreeNode(15, null, null);
        TreeNode twenty = new TreeNode(20, null, null);
        TreeNode ten = new TreeNode(10, twenty, fifteen);
        TreeNode thirty = new TreeNode(30, ten, null);
        TreeNode three = new TreeNode(3, null, thirty);

        //[3,null,30,10,null,null,15,null,45]

        System.out.println(ValidateBinarySearchTree.isValidBST(three));
    }
}
