package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author: BlackVJack/Justice
 * time:2023/6/14 16:51
 *
 * 力扣题库第0139题: 单词拆分
 *      给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *      注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例1:
 *      输入: s = "leetcode", wordDict = ["leet", "code"]
 *      输出: true
 *
 * 示例2:
 *      输入: s = "applepenapple", wordDict = ["apple", "pen"]
 *      输出: true
 *
 * 示例3:
 *      输入: "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 *      输出: false
 */
public class Leetcode_0139 {

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] flag = new boolean[length + 1];
        flag[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (flag[j] && set.contains(s.substring(j, i + 1))) {
                    flag[i + 1] = true;
                }
            }
        }
        return flag[length];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int length = s.length();
        boolean[] array = new boolean[length + 1];
        array[0] = true;
        for (int i = 1; i < length + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] && set.contains(s.substring(j, i))) {
                    array[i] = true;
                }
            }
        }
        return array[length];
    }


    public static void main(String[] args) {
        // TODO 示例1
        String s1 = "leetcode";
        List<String> wordDict1 = new ArrayList<>();
        wordDict1.add("leet");
        wordDict1.add("code");

        // TODO 示例2
        String s2 = "applepenapple";
        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("apple");
        wordDict2.add("pen");

        // TODO 示例3
        String s3 = "catsandog";
        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("cats");
        wordDict3.add("dog");
        wordDict3.add("sand");
        wordDict3.add("and");
        wordDict3.add("cat");


        Leetcode_0139 leetcode_0139 = new Leetcode_0139();
        boolean flag1 = leetcode_0139.wordBreak2(s1, wordDict1);
        boolean flag2 = leetcode_0139.wordBreak2(s2, wordDict2);
        boolean flag3 = leetcode_0139.wordBreak2(s3, wordDict3);
        System.out.println("real answer: false, my answer: " +flag1);
        System.out.println("real answer: false, my answer: " +flag2);
        System.out.println("real answer: false, my answer: " +flag3);
    }
}
