import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _12015 {
    static int higherBound(List<Integer> arr, int target) {
        int high = arr.size() - 1;
        int low = 0;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr.get(mid) > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    static int lowerBound(List<Integer> arr, int target) {
        int high = arr.size() - 1;
        int low = 0;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (arr.get(mid) >= target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());


        List<Integer> arr = new ArrayList<>();
        String[] set = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            int current = Integer.parseInt(set[i]);
            int idx = lowerBound(arr, current);

            if (idx < arr.size())
                arr.set(idx, current);
            else
                arr.add(idx, current);
        }
        System.out.println(arr.size());
    }
}