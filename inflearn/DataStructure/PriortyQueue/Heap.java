package inflearn.DataStructure.PriortyQueue;

import java.util.PriorityQueue;

public class Heap {

    public static void main(String[] args) {
        int[] arr = {3, 5, 10, 7, 8, 9, 1, 2, 4, 6};
        PriorityQueue<Integer> heap = new PriorityQueue<>(); // min heap

        // python의 heapq.hipify(arr)와 같은 기능
        for (int num : arr) {
            heap.add(-1 * num);
        }

        System.out.println(heap);
        // 힙에서 요소를 하나씩 제거하며 출력
        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
    }

}
