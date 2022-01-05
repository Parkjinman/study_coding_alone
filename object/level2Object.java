package object;

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

    /*public static class Price {
        public int standardNum;
        public int compareNum;
        public int increaseValue = 0;

        public Price(int standardNum, int compareNum) {
            this.standardNum = standardNum;
            this.compareNum = compareNum;
        }

        public void increaseIng() {
            if(compareNum >= standardNum) increaseValue++;
        }
    }*/

}