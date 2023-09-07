package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/8 0:52
 *
 * 力扣题库第2651题 计算列车到站时间
 */
public class Leetcode_2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public static void main(String[] args) {

    }

}
