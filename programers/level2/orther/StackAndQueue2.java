package programers.level2.orther;

import java.util.*;
import java.util.stream.Collectors;

public class StackAndQueue2 {

    //더 맵게(heap) Comparable을 이용한 다른사람의 풀이
    static int[] scoville = {1, 2, 3, 9, 10, 12};
    static int K = 7;
//    static int[] scoville = {1,1};
//    static int K = 4;
    public static int solution(int[] scoville, int K) {
        Foods foods = Arrays.stream(scoville)
                .mapToObj(Food::new)
                .collect(Collectors.collectingAndThen(Collectors.toCollection(PriorityQueue::new), Foods::new));


        return Mixer.calculateMixCount(foods, K);
    }

    private static class Mixer {
        private static final Integer NOT_REACHABLE_TARGET_SCOVILLE = -1;

        public static Integer calculateMixCount(Foods foods, int scoville) {
            int mixCount = 0;
            while (foods.mixable() && !foods.isAllScovilleReachedTo(scoville)) {
                foods.mix();
                mixCount++;
            }

            if (!foods.isAllScovilleReachedTo(scoville)) {
                return NOT_REACHABLE_TARGET_SCOVILLE;
            }

            return mixCount;
        }
    }

    private static class Foods {
        private final Queue<Food> foods;

        public Foods(Queue<Food> foods) {
            this.foods = foods;
        }

        public void mix() {
            Food firstFood = foods.poll();
            Food secondFood = foods.poll();

            Food mixedFood = firstFood.mixWithSecondFood(secondFood);
            foods.add(mixedFood);
        }


        public boolean mixable() {
            return foods.size() > 1;
        }

        public boolean isAllScovilleReachedTo(int targetScoville) {
            return foods.stream()
                    .allMatch(food -> food.isScovilleReachedTo(targetScoville));
        }
    }

    private static class Food implements Comparable<Food> {
        private final Integer scoville;

        public Food(int scoville) {
            this.scoville = scoville;
        }

        public boolean isScovilleReachedTo(int targetScoville) {
            return this.scoville >= targetScoville;
        }

        public Food mixWithSecondFood(Food secondFood) {
            return new Food(scoville + secondFood.scoville * 2);
        }

        @Override
        public int compareTo(Food o) {
            return this.scoville.compareTo(o.scoville);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(scoville, K));
    }

}
