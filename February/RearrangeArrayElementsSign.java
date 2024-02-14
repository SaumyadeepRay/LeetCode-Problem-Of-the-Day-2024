// Rearrange Array Elements by Sign

import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementsSign {

    // Approach 1 (Brute Force)
    public static int[] rearrangeArray1(int[] nums) {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                v1.add(num);
            } else {
                v2.add(num);
            }
        }

        int ind1 = 0, ind2 = 0;

        while (ind2 < nums.length / 2) {
            ans.add(v1.get(ind1));
            ind1++;
            ans.add(v2.get(ind2));
            ind2++;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // Approach 2 (Optimized)
    public static int[] rearrangeArray2(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0, neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };
        System.out.println("Rearrange Array Elements by Sign: " + rearrangeArray1(nums));
        System.out.println("Rearrange Array Elements by Sign: " + rearrangeArray1(nums));
    }
}
