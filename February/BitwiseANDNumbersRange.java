// Bitwise AND of Numbers Range

public class BitwiseANDNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {
        int shift = 0;

        // This code repeatedly shifts the values of "left" and "right" to the right by
        // one bit until they are equal, while keeping track of the number of shifts in
        // the variable "shift".
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }

        // This line of code left shifts the value of the variable "left" by the number
        // of bits specified by the variable "shift" and returns the result.
        return left << shift;
    }

    public static void main(String[] args) {
        int left = 5;
        int right = 7;
        System.out.println("Bitwise AND of Numbers Range: " + rangeBitwiseAnd(left, right));
    }
}
