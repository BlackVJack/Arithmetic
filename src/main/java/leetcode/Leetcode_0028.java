package leetcode;

/**
 * author: BlackVJack/Justice
 * time:2023/7/27 21:55
 */


public class Leetcode_0028 {

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
