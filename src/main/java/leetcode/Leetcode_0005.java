package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/2 11:11
 *
 *   最长回文字串
 */
public class Leetcode_0005 {

    public String longestPalindrome(String s) {
        int length = s.length();
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < length; i++) {
            checkTwoSides(i, i + 1, s, result);
            checkTwoSides(i - 1, i + 1, s, result);
        }
        return result.toString();
    }

    public void checkTwoSides(int leftIndex, int rightIndex, String target, StringBuilder result) {
        while (leftIndex >= 0 && rightIndex < target.length()) {
            char left = target.charAt(leftIndex);
            char right = target.charAt(rightIndex);
            if (left != right) break;
            leftIndex--;
            rightIndex++;
        }
        leftIndex++;
        rightIndex--;
        int length = result.length();
        if (length < rightIndex + 1 - leftIndex) {
            result.delete(0, length);
            result.append(target.substring(leftIndex, rightIndex + 1));
        }
    }

}
