package level3.me;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HeapPriorityQueue {

    //디스크 컨트롤러
//    static int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    static int[][] jobs = {{0, 2}, {1, 1}};
    public static int solution(int[][] jobs) {
        int answer = 0;

        HashMap<Integer, int[]> diskMap = new HashMap<>();
        PriorityQueue<Integer> diskPQ = new PriorityQueue<>();

        for(int[] job : jobs) {
            diskMap.put(job[0]+job[1], job);
            diskPQ.offer(job[0]+job[1]);
        }

        int endNum = 0;
        while(!diskPQ.isEmpty()) {
            int[] diskJob = diskMap.get(diskPQ.poll());
            answer += endNum - diskJob[0] + diskJob[1];
            endNum += diskJob[1];
        }

        return answer/jobs.length;
    }

    public static void main(String[] args) {
//        System.out.println(solution(jobs));
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>();

        int[] arr = {1,2};
        int[] arr1 = {0,3};
        priorityQueue.offer(arr);
        priorityQueue.offer(arr1);

        System.out.println(priorityQueue);
    }
}
