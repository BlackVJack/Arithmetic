package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author BlackVJack/Justice
 * @time 2023/8/6 14:25
 *
 * 力扣题库第0037题
 * does not finish
 */
public class Leetcode_0037 {

    public void solveSudoku(char[][] board) {
        HashSet<Integer>[][] set = new HashSet[9][9];
//        int[][] flag = new int[9][9];
        initSet(set);

        int count = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.') count++;
            }
        }

        while (count != 81) {
            count += checkByMatrix(set, board);
            count += checkByRow(set, board);
            count += checkByColumn(set, board);
        }

    }


    public void initSet(Set<Integer>[][] set) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                set[i][j] = new HashSet<>();
                for (int k = 1; k < 10; k++) {
                    set[i][j].add(k);
                }
            }
        }
    }

    public void removeByMatrix(Set<Integer>[][] set, int i, int j, int target) {
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                set[i * 3 + ii][j * 3 + jj].remove(target);
            }
        }
    }

    public void removeByRow(Set<Integer>[][] set, int row, int target) {
        for (int j = 0; j < 9; j++) {
            set[row][j].remove(target);
        }
    }

    public void removeByColumn(Set<Integer>[][] set, int column, int target) {
        for (int i = 0; i < 9; i++) {
            set[i][column].remove(target);
        }
    }

    public int checkByMatrix(Set<Integer>[][] set, char[][] board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                for (int ii = 0; ii < 3; ii++) {

                    for (int jj = 0; jj < 3; jj++) {
                        if (board[i * 3 + ii][j * 3 + jj] != '.') {
                            int x = Integer.parseInt(board[i * 3 + ii][j * 3 + jj] + "");
                            set[i * 3 + ii][j * 3 + jj].clear();
                            removeByMatrix(set, i, j, x);
                            continue;
                        }
                        if (set[i * 3 + ii][j * 3 + jj].size() == 1) {
                            Integer target = new ArrayList<>(set[i * 3 + ii][j * 3 + jj]).get(0);
                            board[i * 3 + ii][j * 3 + jj] = getTarget(target);
                            set[i * 3 + ii][j * 3 + jj].clear();
                            count++;
                            removeByMatrix(set, i, j, target);
                        }
                    }
                }
            }
        }

        return count;
    }

    public char getTarget(int x) {
        char t;
        switch (x) {
            case 1:
                t = '1';
                break;
            case 2:
                t = '2';
                break;
            case 3:
                t = '3';
                break;
            case 4:
                t = '4';
                break;
            case 5:
                t = '5';
                break;
            case 6:
                t = '6';
                break;
            case 7:
                t = '7';
                break;
            case 8:
                t = '8';
                break;
            default:
                t = '9';
        }
        return t;
    }

    public int checkByRow (Set<Integer>[][] set, char[][] board) {
        int count = 0;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int x = Integer.parseInt(board[i][j] + "");
                    set[i][j].clear();
                    removeByRow(set, i, x);
                    continue;
                }

                if (set[i][j].size() == 1) {
                    Integer target = new ArrayList<>(set[i][j]).get(0);
                    board[i][j] = getTarget(target);
                    set[i][j].clear();
                    count++;
                    removeByRow(set, i, target);
                }
            }
        }

        return count;
    }

    public int checkByColumn(Set<Integer>[][] set, char[][] board) {
        int count = 0;

        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int x = Integer.parseInt(board[i][j] + "");
                    set[i][j].clear();
                    removeByColumn(set, j, x);
                    continue;
                }

                if (set[i][j].size() == 1) {
                    Integer target = new ArrayList<>(set[i][j]).get(0);
                    board[i][j] = getTarget(target);
                    set[i][j].clear();
                    count++;
                    removeByColumn(set, j, target);
                }
            }
        }

        return count;
    }

}
