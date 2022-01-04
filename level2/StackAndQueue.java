package level2;

import java.util.LinkedList;
import java.util.Queue;

public class StackAndQueue {

    static class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

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

    public static void main(String[] args) {
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

}
