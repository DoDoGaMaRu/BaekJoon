import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2565 {
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

    static class A implements Comparable<A>{
        int idx, val;

        public A(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }


        @Override
        public int compareTo(A o) {
            return idx - o.idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        A[] tempArr = new A[count];
        for (int i = 0; i < count; i++) {
            String[] set = br.readLine().split(" ");
            tempArr[i] = new A(Integer.parseInt(set[0]), Integer.parseInt(set[1]));
        }
        Arrays.sort(tempArr);

        List<Integer> arr = new ArrayList<>();
        int current = 0;
        int idx = 0;

        for (int i = 0; i < count; i++) {
            current = tempArr[i].val;
            idx = lowerBound(arr, current);

            if (idx < arr.size())
                arr.set(idx, current);
            else
                arr.add(idx, current);
        }
        System.out.println(count - arr.size());
    }
}