package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BlackVJack/Justice
 * @time 2023/9/9 14:27
 *
 * 力扣题库第0207题 课程表
 *
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *  示例1
 *      输入: numCourses = 2, prerequisites = [[1,0]]
 *      输出: true
 *
 *  示例2
 *      输入: numCourses = 2, prerequisites = [[1, 0], [0, 1]]
 *      输出: false
 */
public class Leetcode_0207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] preRequire = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++){
            preRequire[i] = new ArrayList<>();
        }
        for (int[] edge : prerequisites) {
            preRequire[edge[0]].add(edge[1]);
        }

        // TODO 0代表未访问 1代表已经访问 2代表已学
        int[] visitOrLearn = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (visitOrLearn[i] == 2) continue;
            visitOrLearn[i] = check(visitOrLearn, preRequire, i);
            if (visitOrLearn[i] == 1) return false;
        }
        return true;
    }

    public int check(int[] visitOrLearn, ArrayList<Integer>[] preRequire, int course) {
        // TODO 如果已经学过, 说明可达不需要重复遍历, 提前剪枝并防止误判环路
        if (visitOrLearn[course] == 2) return 2;

        // TODO 如果已经走过, 说明形成环路
        if (visitOrLearn[course] == 1) return 1;

        // TODO 标记走过
        visitOrLearn[course] = 1;

        // TODO 获取该课程的前置课程
        List<Integer> preCourses = preRequire[course];

        // TODO 如果前置课程为空, 代表可直接学, 可达
        if (preCourses.size() == 0) {
            return (visitOrLearn[course] = 2);
        }

        // TODO 遍历前置课程, 深度优先搜索, 查看是否可达, 不可达则直接return false, 剪枝, 减少遍历
        for (int preCourse : preCourses) {
            visitOrLearn[preCourse] = check(visitOrLearn, preRequire, preCourse);
            if (visitOrLearn[preCourse] == 1) return 1;
        }
        return 2;
    }


    public static void main(String[] args) {
        Leetcode_0207 leetcode_0207 = new Leetcode_0207();

        int numCourses1 = 3;
        int[][] preRequire1 = new int[][]{{1, 0}, {1, 2}, {0, 1}};
        System.out.println(leetcode_0207.canFinish(numCourses1, preRequire1));
    }

}
