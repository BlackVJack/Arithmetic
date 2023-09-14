package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 王臻毅
 * @date 2023/9/14.
 *
 * 力扣题库第2596题 检查骑士巡视方案
 *
 *
 **/
public class Leetcode_2596 {

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;

        int height = grid.length;
        int width = grid[0].length;

        int size = width * height;
        int[][] array = new int[size][2];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                array[grid[i][j]][0] = i;
                array[grid[i][j]][1] = j;
            }
        }


        for (int i = 0; i < size - 1; i++) {
            int j = i + 1;
            if (Math.abs((array[i][0] - array[j][0]) * (array[i][1] - array[j][1])) != 2)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
