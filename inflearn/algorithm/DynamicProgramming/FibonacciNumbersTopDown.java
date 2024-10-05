package inflearn.algorithm.DynamicProgramming;

import java.util.HashMap;

/**
 * Fibonacci Numbers Top-Down 방식으로 구현
 */
public class FibonacciNumbersTopDown {
    static HashMap<Integer, Integer> memoization = new HashMap<>();

    public static void main(String[] args) {
        memoization.put(1, 1);
        memoization.put(2, 1);

        System.out.println(fibonacci(7));
    }

    private static int fibonacci(int n) {
        if (memoization.containsKey(n)) {
            return memoization.get(n);
        }

        memoization.put(n, fibonacci(n - 1) + fibonacci(n - 2));

        return memoization.get(n);
    }
}
