package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Black Jack
 * @date 2023/7/18.
 **/
public class Leetcode_0022 {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *  示例 1
     *      输入：n = 1
     *      输出：["()"]
     *
     * 示例 2
     *      输入：n = 3
     *      输出：["((()))","(()())","(())()","()(())","()()()"]
     */

    public static void main(String[] args) {
        List<String> strings = new Leetcode_0022().generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        generate(builder, 1, 0, n);
        return result;
    }

    public void generate(StringBuilder builder, int left, int right, int n) {
        if (2 * n == left + right) {
            result.add(builder.toString());
            return;
        }

        if (left < n) {
            builder.append("(");
            generate(builder, left + 1, right, n);
            builder.deleteCharAt(left + right);
        }


        if (right < n && left > right){
            builder.append(")");
            generate(builder, left, right + 1, n);
            builder.deleteCharAt(left + right);
        }

    }

}
