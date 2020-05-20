package problems;

public class Fib2 {

    long fib(long n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        Fib2 fib = new Fib2();
        System.out.println(fib.fib(70));
    }
}
