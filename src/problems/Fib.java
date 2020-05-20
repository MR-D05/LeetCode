//package problems;
//
//import java.util.HashMap;
//
//public class Fib {
//    HashMap<Long, Long> cache = new HashMap<>();
//
//    long fib(long n) {
//        if (cache.containsKey(n)) {
//            return cache.get(n);
//        }
////        if (n <= 1) {
////            return n;
////        }
//        else {
//            long first = fib(n - 1);
//            cache.put(n-1, first);
//            long second = fib(n - 2);
//            cache.put(n-2, second);
////            cache.put(first, first);
////            cache.put(second, second);
//            return first + second;
//            //return first + second;
//        }
//    }
//
//    /*
//    4 : n = 2 first = 1,  second = 0 so 1
//    3 : n = 3 first =
//    3
//    2
//    1
//     */
//
//    public static void main(String[] args) {
//
//        Fib fib = new Fib();
//        fib.cache.put(0L, 0L);
//        fib.cache.put(1L, 1L);
//        System.out.println(fib.fib(70));
//    }
//}
//
//
///*
//public class Fib {
//    HashMap<Integer, Integer> cache = new HashMap<>();
//
//    long fib(long n) {
//        if (cache.get(n) != null) {
//            return cache.get(n);
//        } else {
//            long first = fib(n - 1);
//            long second = fib(n - 2);
//            long result = first + second;
//            cache.put(result, result);
//            return first + second;
//        }
//    }
//
//    public static void main(String[] args) {
//        Fib fib = new Fib();
//        fib.cache.put(0, 0);
//        fib.cache.put(1, 1);
//        System.out.println(fib.fib(4));
//    }
//}
// */
