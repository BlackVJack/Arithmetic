package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/16 16:39
 *
 * 力扣题库第0134题 加油站
 */
public class Leetcode_0134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        if (length == 1) {
            if (gas[0] >= cost[0]) return 0;
            else return -1;
        }


        long sum = 0;
        List<Integer> indexList = new ArrayList<>();
        List<Long> costList = new ArrayList<>();
        int[] left = new int[length];
        // TODO 记录每个加油站的最终"收支"和
        for (int i = 0; i < length; i++) {
            left[i] = gas[i] - cost[i];
            sum += left[i];
            if (left[i] > 0) indexList.add(i);
        }
        if (sum < 0) return -1;

        long s;
        int size = indexList.size();
        for (int i = 0; i < size - 1; i++) {
            s = 0;
            for (int j = indexList.get(i); j < indexList.get(i + 1); j++) {
                s += left[j];
            }
            costList.add(s);
        }
        s = 0;
        for (int i = indexList.get(size - 1); i < length + indexList.get(0); i++) {
            s += left[i >= length ? i - length : i];
        }
        costList.add(s);


        // TODO
        return calculate(costList, indexList, size);
    }

    public int calculate(List<Long> costList, List<Integer> list, int size) {

        // TODO 计算和
        long s;
        int start = 0;

        // TODO 每个起点只计算一次
        while (start < size) {
            int end = start;
            s = 0;

            // TODO 从每个起点开始往后计算
            while (true) {
                // TODO 如果求和小于0
                if (s < 0) {
                    // TODO 减去起点加的值
                    s -= costList.get(start);
                    // TODO 起点往前移动
                    start++;
                    // TODO 如果起点为终点, 结束, 重新计算
                    if (end == start) {
                        break;
                    }
                    continue;
                }
                s += costList.get(end);
                end = ++end >= size ? end - size : end;
                if (end == start) return list.get(start);
            }
        }
        return -1;
    }


    public static void main(String[] args) {

    }

}
