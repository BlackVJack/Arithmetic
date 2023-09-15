package lcp;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库LCP.0050 宝石补给
 **/
public class Lcp_0050 {

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int give = gem[operation[0]] / 2;
            gem[operation[0]] -= give;
            gem[operation[1]] += give;
        }
        int min = 1001;
        int max = -1;

        for (int score : gem) {
            if (score < min) min = score;
            if (score > max) max = score;
        }
        return max - min;
    }

    public static void main(String[] args) {

    }

}
