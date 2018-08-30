package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumTime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long machines = Long.parseLong(br.readLine().split(" ")[1]);
        String[] content = br.readLine().split(" ");
        int[] times = new int[content.length];
        for (int i = 0; i < content.length; i++) {
            times[i] = Integer.parseInt(content[i]);
        }

        System.out.println(getMinimumDays(times, machines));

    }

    private static long getMinimumDays(int[] times, long machines) {
        Arrays.sort(times);
        long minDays = 0;
        long maxDays = machines * times[0];

        while (minDays <= maxDays){
            long middle = minDays + (maxDays - minDays)/2;
            long currentMachines = getMachinesProduced(times, middle);
            if (currentMachines == machines){
                while (getMachinesProduced(times, middle) == machines)
                    --middle;
                return middle + 1;
            }
            else if (currentMachines < machines){
                minDays = middle + 1;
            }
            else {
                maxDays = middle - 1;
            }
        }

        return -1;

    }

    private static int getMachinesProduced(int[] times, long days){
        long total = 0;
        for (long time: times){
            total += days / time;
            if (total > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) total;
    }
}
