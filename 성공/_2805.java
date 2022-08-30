import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2805 {
    static class Tree{
        long size;

        Tree(long size) {
            this.size = size;
        }

        long cut(long height) {
            long temp = size - height;
            return Math.max(temp, 0);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");
        int n = Integer.parseInt(set[0]);
        int target = Integer.parseInt(set[1]);


        long high = 0;
        long low = 0;
        long mid = 0;


        Tree[] arr = new Tree[n];
        set = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long size = Integer.parseInt(set[i]);
            arr[i] = new Tree(size);

            if (high < size) {
                high = size;
            }
        }


        long ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long sum = 0;
            for (Tree i : arr) {
                sum += i.cut(mid);
            }

            if (sum >= target) {
                low = mid + 1;
                ans = mid;
            }
            else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}