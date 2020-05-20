package problems;

import java.util.HashMap;

public class FibTest {
    HashMap<Long, Long> cache = new HashMap<>();

    public Long fib(long n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            long first = fib(n - 1);
            cache.put(n - 1, first);
            long second = fib(n - 2);
            cache.put(n - 2, second);
            return first + second;
        }
    }

    public static void main(String[] args) {
        FibTest fib = new FibTest();
        fib.cache.put(0L, 0L);
        fib.cache.put(1L, 1L);
        System.out.println(fib.fib(4L));
    }
}
