package level2;

import object.level2Object.Truck;

import java.util.*;

public class StackAndQueue {

    //다리를 지나는 트럭
    static int bridge_length = 2;
    static int weight = 10;
    static int[] truck_weights = {7,4,5,6};
    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for(int t : truck_weights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while( !waitQ.isEmpty() || !moveQ.isEmpty() ) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridge_length) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }

    //주식가격
    static int[] prices = {1, 2, 3, 2, 3};
    public static int[] solution(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];

        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }

    //더 맵게(heap)
//    static int[] scoville = {1, 2, 3, 9, 10, 12};
//    static int K = 7;
    static int[] scoville = {1,1};
    static int K = 4;
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); //최대 힙

        for(int s : scoville) {
            priorityQueue.offer(s);
        }

        while ( !priorityQueue.isEmpty() ) {
            if(priorityQueue.size() == 1) {
                if(priorityQueue.peek() >= K) {
                    break;
                } else {
                    return -1;
                }
            }
            if(priorityQueue.peek() >= K) break;

            int standardNum = priorityQueue.poll();
            int compareNum = priorityQueue.peek();

            priorityQueue.offer(standardNum + compareNum * 2);
            answer++;

            priorityQueue.poll();
        }

        if(answer == 0) {
            answer = -1;
        }

        return answer;
    }

    //올바른 괄호
//    static String s = "()()";
//    static String s = "(())()";
//    static String s = ")()(";
    static String s = "(()(";
    public static boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.add(0);
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(solution(bridge_length, weight, truck_weights));
        System.out.println(solution(prices));
//        System.out.println(solution(scoville, K));
//        System.out.println(solution(s));
    }

}
