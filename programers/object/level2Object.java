package programers.object;

//객체들의 객체
public class level2Object {

    public static class Truck {
        public int weight;
        public int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    /*public static class LeastCommonMultiple implements Comparable<LeastCommonMultiple> {
        public int numCnt;

        public LeastCommonMultiple(int numCnt) {
            this.numCnt = numCnt;
        }

        @Override
        public int compareTo(LeastCommonMultiple o) {
            return numCnt - o.numCnt;
        }
    }*/

}