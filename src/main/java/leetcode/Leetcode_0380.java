package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 王臻毅
 * @date 2023/9/15.
 *
 * 力扣题库第0380题 O(1)时间插入、删除和获取随机元素
 **/
public class Leetcode_0380 {

    static class RandomizedSet {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> removeIndexSet = new HashSet<>();
        Random random = new Random();
        int size = 0;
        public RandomizedSet() {

        }

        public boolean insert(int val) {
            boolean add = map.containsKey(val);
            if (!add) {
                map.put(val, size);
                list.add(val);
                size++;
            }
            return !add;
        }

        public boolean remove(int val) {
            Integer index = map.remove(val);
            boolean remove = index != null;
            if (remove){
                removeIndexSet.add(index);
            }
            return remove;
        }

        public int getRandom() {
            int randomIndex = Math.abs(random.nextInt()) % size;
            while(removeIndexSet.contains(randomIndex)) {
                randomIndex = Math.abs(random.nextInt()) % size;
            }
            return list.get(randomIndex);
        }
    }

}
