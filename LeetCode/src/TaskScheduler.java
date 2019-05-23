import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Q: Given a char array representing tasks CPU need to do.
 *    It contains capital letters A to Z where different letters represent different tasks.
 *    Tasks could be done without original order.
 *    Each task could be done in one interval.
 *    For each interval, CPU could finish one task or just be idle.
 *
 *    However, there is a non-negative cooling interval n that means between two same tasks,
 *    there must be at least n intervals that CPU are doing different tasks or just be idle.
 *
 *    You need to return the least number of intervals the CPU will take to finish
 *    all the given tasks.
 */
public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task: tasks)
            ++freq[task - 'A'];

        PriorityQueue<Integer> tasksFrequency = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int frequency: freq){
            if (frequency != 0)
                tasksFrequency.add(frequency);
        }

        int time = 0;

        while (!tasksFrequency.isEmpty()){
            List<Integer> tempTasks = new ArrayList<>();
            int i = 0;
            while (i <= n){
                if (!tasksFrequency.isEmpty()){
                    if (tasksFrequency.peek() > 1){
                        tempTasks.add(tasksFrequency.poll() - 1);
                    }
                    else
                        tasksFrequency.poll();
                }
                ++i;
                ++time;
                if (tasksFrequency.isEmpty() && tempTasks.isEmpty())
                    break;
            }
            for (int remaining: tempTasks)
                tasksFrequency.add(remaining);
        }

        return time;
    }

    public static void main(String[] args){
        char[] tasks = {'A', 'A', 'A', 'B', 'B','B'};
        System.out.println(leastInterval(tasks, 2));
    }

}
