package leetcode;

import java.util.*;

/**
 * @author 王臻毅
 * @date 2023/9/14.
 *
 * 力扣题库第1462题 课程表4
 **/


public class Leetcode_1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // TODO 每个课程的前置课程, 初始值设为空列表, 代表无前置课程
        int[][] preRequire = new int[numCourses][numCourses];

        // TODO 记录直接前置课程
        for (int[] course : prerequisites) {
            preRequire[course[1]][course[0]] = 1;
        }


        // TODO 递归查询
        int[] visit = new int[numCourses];
        for (int course = 0; course < numCourses; course++) {
            search(preRequire, visit, course, numCourses);
        }

        for (int i = 0; i < numCourses; i++) {
            System.out.println(Arrays.toString(preRequire[i]));
        }
        // TODO 查询
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(preRequire[query[1]][query[0]] == 1);
        }
        return res;
    }


    public void search(int[][] preRequire, int[] visit, int course, int numCourses) {
        if (visit[course] == 1) {
            return;
        }
        visit[course] = 1;

        int[] preCourses = preRequire[course];

        // TODO 前置课程
        for (int preCourse = 0; preCourse < numCourses; preCourse++) {

            if (preCourses[preCourse] == 0) continue;
            search(preRequire, visit, preCourse, numCourses);

            for (int i = 0; i < numCourses; i++) {
                if (preRequire[preCourse][i] == 1) preRequire[course][i] = 1;
            }
        }
    }


    public static void main(String[] args) {
        Leetcode_1462 leetcode_1462 = new Leetcode_1462();

        int numCourses1 = 2;
        int[][] prerequisites1 = new int[][]{{1, 0}};
        int[][] queries1 = new int[][]{{0, 1}, {1, 0}};
        System.out.println(leetcode_1462.checkIfPrerequisite(numCourses1, prerequisites1, queries1));


        int numCourses2 = 2;
        int[][] prerequisites2 = new int[][]{};
        int[][] queries2 = new int[][]{{0, 1}, {1, 0}};
        System.out.println(leetcode_1462.checkIfPrerequisite(numCourses2, prerequisites2, queries2));


        int numCourses3 = 3;
        int[][] prerequisites3 = new int[][]{{1, 2}, {1, 0}, {2, 0}};
        int[][] queries3 = new int[][]{{0, 1}, {1, 2}};
        System.out.println(leetcode_1462.checkIfPrerequisite(numCourses3, prerequisites3, queries3));


        int numCourses4 = 5;
        int[][] prerequisites4 = new int[][]{{4, 3}, {4, 1}, {4, 0}, {3, 2}, {3, 1}, {3, 0}, {2, 1}, {2, 0}, {1, 0}};
        int[][] queries4 = new int[][]{{1, 4}, {4, 2}, {0, 1}, {4, 0}, {0, 2}, {1, 3}, {0, 1}};
        System.out.println(leetcode_1462.checkIfPrerequisite(numCourses4, prerequisites4, queries4));

    }

}
