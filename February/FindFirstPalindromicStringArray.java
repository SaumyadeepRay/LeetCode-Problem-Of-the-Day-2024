// Find First Palindromic String in the Array

public class FindFirstPalindromicStringArray {

    // Approach 1
    public static String firstPalindrome1(String[] words) {
        for (String str : words) {
            if (checkPalindrome(str)) {
                return str;
            }
        }
        return "";
    }

    // This code checks if a given string is a palindrome by comparing characters
    // from the beginning and end of the string, returning true if all characters
    // match and false otherwise.
    public static boolean checkPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // Approach 2
    public static String firstPalindrome2(String[] words) {
        for (String word : words) {

            // The code snippet creates a StringBuilder object called "reversed" by
            // reversing the characters in a given string called "word".
            StringBuilder reversed = new StringBuilder(word).reverse();

            // The code checks if a given word is equal to its reversed version. If they are
            // equal, the word is returned.
            if (word.equals(reversed.toString())) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String[] words = { "abc", "car", "ada", "racecar", "cool" };
        System.out.println("Find First Palindromic String in the Array: " + firstPalindrome1(words));
        System.out.println("Find First Palindromic String in the Array: " + firstPalindrome2(words));
    }
}
