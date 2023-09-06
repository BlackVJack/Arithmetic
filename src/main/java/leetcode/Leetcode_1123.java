package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/7 0:36
 *
 * 力扣题库第1123题 最深叶节点的最近公共祖先
 *
 * 解法1 暴力: 第一次遍历找最深并标记节点, 第二次遍历找最近公共祖先
 *
 * 解法2 边遍历边寻找
 */
public class Leetcode_1123 {
    static class TreeNode {
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


    // TODO 解法2
    int max = 0;
    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        lca(root, 0);
        return mark;
    }

    public int lca(TreeNode root, int dept) {
        if (root == null) return 0;
        int left = lca(root.left, dept + 1);
        int right = lca(root.right, dept + 1);

        if (left == right) {
            if (max <= dept + left) {
                mark = root;
                max = dept + left;
            }
        }
        return Math.max(left, right) + 1;
    }




    // TODO 解法1
    int maxDept = 0;
    Set<TreeNode> set = new HashSet<>();
    TreeNode mark = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        getDept(root, 0);
        lca(root);
        return mark;
    }


    public void getDept(TreeNode root, int dept) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (dept < maxDept) return;
            if (dept > maxDept) {
                set.clear();
                maxDept = dept;
            }
            set.add(root);
            return;
        }
        getDept(root.left, dept + 1);
        getDept(root.right, dept + 1);
    }


    public int lca(TreeNode root) {
        if (root == null) return 0;
        if (set.contains(root)) {
            if (set.size() == 1) mark = root;
            return 1;
        }
        int x = lca(root.left) + lca(root.right);
        if (x == 0) return 0;
        if (x == 2) mark = root;
        return 1;
    }

    public static void main(String[] args) {

    }

}
