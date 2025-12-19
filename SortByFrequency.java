import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortByFrequency {
    public static ArrayList<Integer> sortByIncresingFrequency(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a) != map.get(b)) {
                return map.get(b) - map.get(a); // high freq first
            }

            return a - b;
        });

        pq.addAll(map.keySet());

        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int num = pq.poll();
            int freq = map.get(num);

            while (freq > 0) {
                result.add(num);
                freq--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 3 };
        System.out.println(sortByIncresingFrequency(arr));
    }
}
