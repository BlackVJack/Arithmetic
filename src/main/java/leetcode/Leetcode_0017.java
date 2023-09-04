package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Black Jack
 * @date 2023/7/18.
 **/
public class Leetcode_0017 {

    /**
     *
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *  示例1
     *      输入：digits = "23"
     *      输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *  示例2
     *      输入：digits = ""
     *      输出：[]
     *  示例3
     *      输入：digits = "2"
     *      输出：["a","b","c"]
     */
    public static void main(String[] args) {
        List<String> strings = new Leetcode_0017().letterCombinations("23");
        for (String str : strings) {
            System.out.println(str);
        }
    }


    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if (length == 0) return new ArrayList<>();

        Map<Integer, char[]> map = new HashMap<>();
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});

        generate(map, new StringBuilder(), digits, 0);
        return result;
    }

    public void generate(Map<Integer, char[]> map, StringBuilder builder, String s, int i) {
        if (i == s.length()) {
            result.add(builder.toString());
            return;
        }

        char[] array = map.get(Integer.valueOf(s.charAt(i) + ""));
        for (char c : array) {
            builder.append(c);
            generate(map, builder, s, i + 1);
            builder.deleteCharAt(i);
        }
    }
}
