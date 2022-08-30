import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2512 {
    static class Department {
        long requestBudget;

        Department(long budget) {
            this.requestBudget = budget;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long high = 0;
        long low = 1;
        long mid = 0;


        Department[] arr = new Department[n];
        String[] set = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            long size = Long.parseLong(set[i]);
            arr[i] = new Department(size);

            if (high < size) {
                high = size;
            }
        }

        long budget = Long.parseLong(br.readLine());

        long ans = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            long sum = budget;
            for (Department i : arr) {
                sum -= Math.min(i.requestBudget, mid);
            }

            if (sum >= 0) {
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