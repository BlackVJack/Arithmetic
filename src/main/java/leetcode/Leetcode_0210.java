package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/10 12:19
 *
 * 力扣题库第0210题 课程表2
 *      现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 *      给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 *
 *      例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 *      返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。
 *      如果不可能完成所有课程，返回 一个空数组 。
 *
 *  示例1
 *      输入: numCourses = 2, prerequisites = [[1,0]]
 *      输出: [0,1]
 *
 *  示例2
 *      输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 *      输出: [0,2,1,3]
 */
public class Leetcode_0210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] preRequire = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preRequire[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            preRequire[pre[0]].add(pre[1]);
        }

        List<Integer> learnOrder = new ArrayList<>();

        // TODO 0未访问, 1访问, 2已学
        int[] visitOrLearn = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {

            int canLearn = search(preRequire, i, visitOrLearn, learnOrder);
            // TODO 返回1 代表访问过, 但是未学, 代表无法完成学习
            if (canLearn == 1) return new int[0];
            // TODO 返回2 代表已经学过, 不用管
            if (canLearn == 2) continue;
            // TODO 返回0 代表可学
            learnOrder.add(i);
            visitOrLearn[i] = 2;
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = learnOrder.get(i);
        }
        return res;
    }

    public int search(ArrayList<Integer>[] preRequire, int course, int[] visitOrLearn, List<Integer> learnOrder) {
        // TODO 只要不是 未访问, 都直接返回
        if (visitOrLearn[course] != 0) return visitOrLearn[course];

        // TODO 标记访问
        visitOrLearn[course] = 1;

        // TODO 获取前置课程
        ArrayList<Integer> preCourses = preRequire[course];

        // TODO 没有前置课程, 返回0 表示可学
        if (preCourses.size() == 0) {
            return 0;
        }

        // TODO 遍历 前置课程
        for (int preCourse : preCourses) {
            int canLearn = search(preRequire, preCourse, visitOrLearn, learnOrder);
            // TODO 遍历返回1 代表无法完成
            if(canLearn == 1) return 1;
            // TODO 遍历返回2 代表已学 继续遍历
            if (canLearn == 2) continue;
            // TODO 遍历返回0 代表可学 标记已学
            visitOrLearn[preCourse] = 2;
            learnOrder.add(preCourse);
        }
        // TODO 返回0 代表可学
        return 0;
    }



    public static void main(String[] args) {
        Leetcode_0210 leetcode_0210 = new Leetcode_0210();

        int numCourses1 = 3;
        int[][] preRequire1 = new int[][]{{1, 0}, {1, 2}, {0, 1}};
        System.out.println("输入=>> 课程数: " + numCourses1 + "; 课程先修规则: " + Arrays.deepToString(preRequire1));
        System.out.println("输出: " + Arrays.toString(leetcode_0210.findOrder(numCourses1, preRequire1)));



        int numCourses2 = 2;
        int[][] preRequire2 = new int[][]{{1, 0}};
        System.out.println("输入=>> 课程数: " + numCourses2 + "; 课程先修规则: " + Arrays.deepToString(preRequire2));
        System.out.println("输出: " + Arrays.toString(leetcode_0210.findOrder(numCourses2, preRequire2)));
    }
}
