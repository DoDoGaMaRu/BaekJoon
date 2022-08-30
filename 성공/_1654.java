import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1654 {
    static class Lan {
        long size;

        Lan(long size) {
            this.size = size;
        }

        long cut(long len) {
            return size / len;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");
        int n = Integer.parseInt(set[0]);
        int target = Integer.parseInt(set[1]);


        long high = 0;
        long low = 1;
        long mid = 0;


        Lan[] arr = new Lan[n];
        for (int i = 0; i < n; i++) {
            long size = Integer.parseInt(br.readLine());
            arr[i] = new Lan(size);

            if (high < size) {
                high = size;
            }
        }


        long ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long sum = 0;
            for (Lan i : arr) {
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