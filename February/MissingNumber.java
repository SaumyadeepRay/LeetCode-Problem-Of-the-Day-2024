// Missing Number

public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int n = nums.length;

        // This line of code calculates the sum of the first n natural numbers using the
        // formula n * (n + 1) / 2.
        int sumN = n * (n + 1) / 2;

        int sum = 0;

        for (int val : nums) {
            sum += val;
        }

        return sumN - sum;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        System.out.println("Missing Number: " + missingNumber(nums));
    }
}
