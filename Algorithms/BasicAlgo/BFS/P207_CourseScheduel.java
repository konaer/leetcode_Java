
package BasicAlgo.BFS;

import java.util.*;

public class P207_CourseScheduel {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> courses = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            courses.get(prerequisite[1]).add(prerequisite[0]);
            indegrees[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curCourse = queue.poll();
            count++;
            for (int nextCourse : courses.get(curCourse)) {
                indegrees[nextCourse]--;
                if (indegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        return count == numCourses;
    }
}
