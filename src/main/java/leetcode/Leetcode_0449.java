package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/4 12:25
 *
 * 力扣题库第0449题 序列化和反序列化二叉搜索树
 *
 * 解法1: 中序、后序、先序遍历中任意两种遍历唯一确定一棵二叉树
 *
 * 解法2: 先序遍历 把null全部算上, 左右都为null则不添加
 *
 *
 */
public class Leetcode_0449 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }





    // TODO 解法1: 中序、后序、先序遍历中任意两种遍历唯一确定一棵二叉树
    private StringBuilder builder = new StringBuilder();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        midRootSearch(root);
        builder.append(",");
        lastRootSearch(root);

        String s = builder.toString();
        builder.delete(0, s.length());
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] tree = data.split(",");

        String[] mid = tree[0].split(" ");
        String[] last = tree[1].split(" ");

        int length = mid.length;
        int[] midInt = new int[length];
        int[] lastInt = new int[length];
        for (int i = 0; i < length; i++) {
            midInt[i] = Integer.parseInt(mid[i]);
            lastInt[i] = Integer.parseInt(last[i]);
        }

        return generate(midInt, lastInt, 0, length, 0, length);
    }


    public TreeNode generate(int[] mid, int[] last, int midBegin, int midEnd, int lastBegin, int lastEnd) {
        int length = midEnd - midBegin;
        if (length == 0) return null;

        int rootVal = last[lastEnd - 1];
        TreeNode root = new TreeNode(rootVal);

        int mark = midBegin;
        for (int i = midBegin; i < midEnd; i++) {
            if (mid[i] == rootVal) {
                mark = i;
                break;
            }
        }
        root.left = generate(mid, last,
                midBegin, mark,
                lastBegin, lastBegin + mark - midBegin);
        root.right = generate(mid, last,
                mark + 1, midEnd,
                lastBegin + mark - midBegin, lastEnd - 1);
        return root;
    }


    // TODO 解法2: 先序遍历 把null全部算上, 左右都为null则不添加
    private StringBuilder strBuilder = new StringBuilder();
    private int process = 0;
    private String[] strList;

    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        rootFirstSearch(root);
        String s = strBuilder.toString();
        strBuilder.delete(0, s.length());
        return s;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        strList = data.split(",");
        return build();
    }


    public TreeNode build() {
        String target = strList[process++];
        if (target.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(target));
        root.left = build();
        root.right = build();
        return root;
    }


    /**
     * 先序遍历
     * @param root 树节点
     */
    public void rootFirstSearch(TreeNode root) {
        if (root == null) {
            strBuilder.append("null,");
            return;
        }
        strBuilder.append(root.val);
        strBuilder.append(",");
        rootFirstSearch(root.left);
        rootFirstSearch(root.right);
    }


    /**
     * 中序遍历
     * @param root 树节点
     */
    public void midRootSearch(TreeNode root) {
        if (root == null) return;
        midRootSearch(root.left);
        builder.append(root.val).append(' ');
        midRootSearch(root.right);
    }


    /**
     * 后序遍历
     * @param root 树节点
     */
    public void lastRootSearch(TreeNode root) {
        if (root == null) return;
        lastRootSearch(root.left);
        lastRootSearch(root.right);
        builder.append(root.val).append(' ');
    }







}
