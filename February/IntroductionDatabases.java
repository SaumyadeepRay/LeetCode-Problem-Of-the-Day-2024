// Introduction to Databases

public class IntroductionDatabases {

    // Brute force
    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static int countSubstrings1(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // Expand Middle
    public static int countSubstrings2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int even = palindromeCount(s, i, i + 1);
            int odd = palindromeCount(s, i - 1, i + 1);
            ans += even + odd + 1;
        }
        return ans;
    }

    public static int palindromeCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }
        return count;
    }

    // DP
    public static int countSubstrings3(String s) {
        int n = s.length();
        boolean[][] palindrome = new boolean[n][n];
        int ans = 0;

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1) && (len <= 2 || palindrome[i + 1][i + len - 2])) {
                    palindrome[i][i + len - 1] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println("Introduction to Databases: " + countSubstrings1(s));
        System.out.println("Introduction to Databases: " + countSubstrings2(s));
        System.out.println("Introduction to Databases: " + countSubstrings3(s));
    }
}
