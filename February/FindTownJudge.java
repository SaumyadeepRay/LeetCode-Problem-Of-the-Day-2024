// Find the Town Judge

public class FindTownJudge {

    public static int findJudge(int n, int[][] trust) {

        int m = trust.length;
        int inDegree[] = new int[n + 1];

        // This code snippet iterates through an array of pairs and increments the value
        // at the index specified in the second element of each pair in another array.
        for (int i = 0; i < m; i++) {
            inDegree[trust[i][1]]++;
        }

        int answer = 0;

        // This code iterates through a range of numbers and assigns the value of `i` to
        // `answer` if the condition `inDegree[i] == n - 1` is met.
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1) {
                answer = i;
            }
        }

        // This code checks if the value of "answer" is present in the first element of
        // each subarray in the "trust" array. If found, it returns -1.
        for (int i = 0; i < m; i++) {
            if (trust[i][0] == answer) {
                return -1;
            }
        }

        return answer == 0 ? -1 : answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        System.out.println("Find the Town Judge: " + findJudge(n, trust));
    }
}
