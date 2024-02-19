// Power of Two

public class PowerOfTwo {

    // Iterative Solution
    public static boolean isPowerOfTwo1(int n) {
        // Constraints:
        // -231 <= n <= 231 - 1
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == n) {
                return true;
            }
        }
        return false;
    }

    // Recursive Solution
    public static boolean isPowerOfTwo2(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo2(n / 2);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("Power of Two: " + isPowerOfTwo1(n));
        System.out.println("Power of Two: " + isPowerOfTwo2(n));
    }
}
