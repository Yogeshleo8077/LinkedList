import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MissingElements {
    public static List<Integer> missingNumbers(int arr[]) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7 };
        System.out.println(missingNumbers(arr));
    }
}
