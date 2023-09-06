package leetcode;

/**
 * author: BlackVJack/Justice
 * time:2023/7/27 21:55
 *
 * 力扣题库第0028题
 */


public class Leetcode_0028 {


public int strStr(String haystack, String needle) {
    int length_1 = haystack.length();
    int length_2 = needle.length();

    if (length_2 > length_1) return -1;
    if (length_1 == length_2) {
    if (haystack.equals(needle)) return 0;
        return -1;
    }

    int i = 0;
    while (i < length_1 - length_2 + 1) {
        int j = 0;
        while(j < length_2) {
            if (haystack.charAt(i + j) != needle.charAt(j)) {
                break;
            }
            j++;
        }
        if (j == length_2) return i;
        i++;
    }
    return -1;
}


    public static void main(String[] args) {
        java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
        nf.setGroupingUsed(false);      //关闭科学计数法
        nf.setMaximumFractionDigits(2);   //定义保留几位小数

        String format = nf.format(Math.pow(2, 31) - 1);
        System.out.println(format);
        int x = -2147483648;
        long y = Math.abs(x - 1);
        System.out.println(y);
    }

}
