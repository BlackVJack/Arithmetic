package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/9 15:54
 *
 * 力扣题库第0824题 山羊拉丁文
 *
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 *
 *  请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 *      1.如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 *          例如，单词 "apple" 变为 "applema" 。
 *      2.如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 *          例如，单词 "goat" 变为 "oatgma" 。
 *      3.根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 *          例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 *
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 *
 *  示例1:
 *      输入: sentence = "I speak Goat Latin"
 *      输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 *
 *  示例2:
 *      输入: sentence = "The quick brown fox jumped over the lazy dog"
 *      输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 */
public class Leetcode_0824 {

    public String toGoatLatin(String sentence) {
        StringBuilder strBuilder = new StringBuilder();
        String[] words = sentence.split(" ");

        int length = words.length;
        for (int i = 0; i < length; i++) {
            String str = words[i];
            if (aeiou(str.charAt(0))) strBuilder.append(str);
            else strBuilder.append(str.substring(1)).append(str.charAt(0));
            strBuilder.append("ma");
            for (int j = -1; j < i; j++) {
                strBuilder.append("a");
            }
            if (i != length - 1) strBuilder.append(" ");
        }
        return strBuilder.toString();
    }

    public boolean aeiou(char x) {
        if (x == 'a' || x == 'A') return true;
        if (x == 'e' || x == 'E') return true;
        if (x == 'i' || x == 'I') return true;
        if (x == 'o' || x == 'O') return true;
        if (x == 'u' || x == 'U') return true;
        return false;
    }

}
