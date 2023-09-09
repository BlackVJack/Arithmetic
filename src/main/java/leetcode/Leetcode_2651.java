package leetcode;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/8 0:52
 *
 * 力扣题库第2651题 计算列车到站时间
 *
 * 给你一个正整数 arrivalTime 表示列车正点到站的时间（单位：小时），另给你一个正整数 delayedTime 表示列车延误的小时数。
 *
 * 返回列车实际到站的时间。
 *
 * 注意，该问题中的时间采用 24 小时制。
 *
 * 示例1
 *      输入: arrivalTime = 15, delayedTime = 5
 *      输出: 20
 *
 * 示例2
 *      输入: arrivalTime = 13, delayedTime = 11
 *      输出: 0
 *
 *
 */
public class Leetcode_2651 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public static void main(String[] args) {

    }

}
