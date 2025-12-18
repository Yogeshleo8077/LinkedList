import java.util.HashMap;

public class LongestSubArrayEqualsK {
    public static int longestSubarray(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = i + 1;
            }

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - (sum - k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 5, 2, 7, 1, -10 };
        int k = 15;

        System.out.println(longestSubarray(arr, k));
    }
}