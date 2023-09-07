package leetcode;

import java.util.*;

/**
 * @author 王臻毅
 * @date 2023/9/7.
 *
 * 力扣题库第2594题 修车的最少时间
 *
 *
 **/
public class Leetcode_2594 {

    public long repairCars2(int[] ranks, int cars) {
        long r = cars;
        long l = 1;
        long min = Long.MAX_VALUE;
        while (l < r) {
            long x = (r + l) / 2;
            long baseTime = x * x;
            int sum = 0;
            for (int rank : ranks) {
                sum += compute(baseTime, rank);
            }
            if (sum >= cars) {
                if (baseTime < min) min = baseTime;
                r = x - 1;
            }
            else {
                l = x + 1;
            }
        }

        return min;
    }

    public int compute(long time, int rank) {
        long x = time / rank;
        return (int) Math.floor(Math.sqrt(x));
    }

    public long repairCars(int[] ranks, int cars) {
        List<Long> square = new ArrayList<>();
        square.add(0L);
        square.add(1L);
        Map<Long, Long> map = new HashMap<>();
        for (int rank : ranks) {
            map.put((long) rank, 0L);
        }

        // 0 - rank, 1 - nums
        Queue<long[]> queue = new PriorityQueue<>((o1, o2) -> {
            long rank1 = o1[0];
            long rank2 = o2[0];

            long nums1 = o1[1] + 1;
            long nums2 = o2[1] + 1;
            return (int) (rank1 * compute(square, (int) nums1) - rank2 * compute(square, (int) nums2));
        });

        for (int rank : ranks) {
            queue.offer(new long[]{rank, 0});
        }

        int count = 0;
        while (true) {
            long[] poll = queue.poll();
            long rank = poll[0];
            poll[1]++;
            map.put(rank, rank * compute(square, (int) poll[1]));
            count++;
            if (cars == count) break;
            queue.offer(poll);
        }

        long sum = 0;
        for (Long key : map.keySet()) {
            Long temp = map.get(key);
            if (temp > sum) sum = temp;
        }
        return sum;
    }


    public long compute(List<Long> array, int n) {
        if (array.size() < n + 1) {
            array.add((long) n * n);
        }
        return array.get(n);
    }

    public static void main(String[] args) {
        Leetcode_2594 leetcode_2594 = new Leetcode_2594();

        int[] ranks = new int[] {4, 2, 3, 1};
        int cars = 10;
        System.out.println(leetcode_2594.repairCars2(ranks, cars));


        int[] ranks1 = new int[] {1, 1, 3, 3};
        int cars1 = 74;
        System.out.println(leetcode_2594.repairCars2(ranks1, cars1));


    }

}
