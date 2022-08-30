import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class _23035 {
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

    static class Cat implements Comparable<Cat>{
        int i, j;

        public Cat(int i, int j) {
            this.i = i;
            this.j = j;
        }


        @Override
        public int compareTo(Cat o) {
            int temp = i - o.i;
            return (temp == 0) ? j - o.j : temp;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");
        int maxI = Integer.parseInt(set[0]);
        int maxJ = Integer.parseInt(set[1]);

        int count = Integer.parseInt(br.readLine());

        LinkedList<Cat> catList = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            set = br.readLine().split(" ");
            int x = Integer.parseInt(set[0]);
            int y = Integer.parseInt(set[1]);

            if (x <= maxI && y <= maxJ) {
                catList.add(new Cat(x, y));
            }
        }
        Collections.sort(catList);

        ArrayList<Integer> arr = new ArrayList<>();
        for (Cat c : catList) {
            int current = c.j;
            int idx = higherBound(arr, current);

            if (idx < arr.size()) {
                arr.set(idx, current);
            }
            else {
                arr.add(current);
            }
        }
        System.out.println(arr.size());
    }
}