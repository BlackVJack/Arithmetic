package leetcode;

/**
 * @author 王臻毅
 * @date 2023/9/5.
 *
 * 力扣题库 第 1368 题 使网格图至少有一条有效路径的最小代价
 * does not finish
 *
 **/
public class Leetcode_1368 {

    int height;
    int width;
    int[][] flag;
    int size;
    public int minCost(int[][] grid) {
        height = grid.length;
        width = grid[0].length;
        size = height * width;
        flag = new int[height][width];

        for (int i = 1; i < height; i++) {
            if (grid[i - 1][0] != 3) flag[i][0] = flag[i - 1][0] + 1;
        }
        for (int j = 1; j < width; j++) {
            if (grid[0][j - 1] != 1) flag[0][j] = flag[0][j - 1] + 1;
        }

        for (int i = 1; i < height; i++){
            for (int j = 1; j < width; j++) {
                int x;
                if (grid[i][j - 1] != 1) x = flag[i][j - 1] + 1;
                else x = flag[i][j - 1];
                int y;
                if (grid[i - 1][j] != 3) y = flag[i - 1][j] + 1;
                else y = flag[i - 1][j];
                flag[i][j] = Math.min(x, y);
            }
        }
        return flag[height - 1][width - 1];
    }

    public void minCost(int[][] grid, int i, int j, int count) {
        if (i == 0 && j == 0) {
            size = Math.min(size, count);
            return;
        }
        if (flag[i][j] == 1) {
            return;
        }
        flag[i][j] = 1;
        if (j - 1 >= 0) {
            if (grid[i][j - 1] == 1) minCost(grid, i, j - 1, count);
            else minCost(grid, i, j - 1, count + 1);
        }

        if (j + 1 < width) {
            if (grid[i][j + 1] == 2) minCost(grid, i, j + 1, count);
            else minCost(grid, i, j + 1, count + 1);
        }

        if (i - 1 >= 0) {
            if (grid[i - 1][j] == 3) minCost(grid, i - 1, j, count);
            else minCost(grid, i - 1, j, count + 1);
        }

        if (i + 1 < height) {
            if (grid[i + 1][j] == 4) minCost(grid, i + 1, j, count);
            else minCost(grid, i + 1, j, count + 1);
        }
        flag[i][j] = 0;
    }

    public static void main(String[] args) {

    }

}
