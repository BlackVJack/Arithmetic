package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王臻毅
 * @date 2023/9/14.
 *
 * 力扣题库第1222题 可以攻击国王的皇后
 *
 *
 **/
public class Leetcode_1222 {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] chessBoard = new int[8][8];

        for (int[] position : queens) {
            chessBoard[position[0]][position[1]] = 1;
        }

        search(chessBoard, king[0], king[1], 1, 0, result);
        search(chessBoard, king[0], king[1], 0, 1, result);
        search(chessBoard, king[0], king[1], -1, 0, result);
        search(chessBoard, king[0], king[1], 0, -1, result);
        search(chessBoard, king[0], king[1], 1, 1, result);
        search(chessBoard, king[0], king[1], -1, -1, result);
        search(chessBoard, king[0], king[1], 1, -1, result);
        search(chessBoard, king[0], king[1], -1, 1, result);
        return result;
    }

    public void search(int[][] chessBoard, int positionX, int positionY, int directionX, int directionY, List<List<Integer>> result) {
        while (positionX < 8 && positionX >= 0 && positionY < 8 && positionY >= 0) {
            if (chessBoard[positionX][positionY] == 1) {
                List<Integer> position = new ArrayList<>();
                position.add(positionX);
                position.add(positionY);
                result.add(position);
                return;
            }
            positionX += directionX;
            positionY += directionY;
        }
    }

    public static void main(String[] args) {

    }

}
