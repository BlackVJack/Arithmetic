package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/18 21:14
 *
 * 力扣题库第0337题 打家劫舍3
 *
 *
 */
public class Leetcode_0337 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int rob(TreeNode root) {
        if (root == null) return 0;
        return robbing(root)[1];
    }

    public int[] robbing(TreeNode node) {
        if (node == null) return new int[] {0, 0};

        int[] leftRob = robbing(node.left);
        int[] rightRob = robbing(node.right);

        // TODO 下层的和的最大取值
        int robSum = leftRob[1] + rightRob[1];

        // TODO 下下层的和
        int preSum = leftRob[0] + rightRob[0];

        return new int[]{robSum, Math.max(node.val + preSum, robSum)};
    }

    public static void main(String[] args) {

    }

}
