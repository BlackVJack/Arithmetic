package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/7 23:34
 *
 * 找出星型图的中心节点
 */
public class Leetcode_1791 {
    public int findCenter(int[][] edges) {
        int length = edges.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] points : edges) {

            map.putIfAbsent(points[0], 0);
            map.put(points[0], map.get(points[0]) + 1);

            map.putIfAbsent(points[1], 0);
            map.put(points[1], map.get(points[1]) + 1);

        }
        int mark = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == length) return mark;
        }
        return mark;
    }

    public static void main(String[] args) {

    }


}
