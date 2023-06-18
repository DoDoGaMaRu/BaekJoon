import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class _18870 {
    public static void main(String[] args) throws Exception  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        String[] set = br.readLine().split(" ");
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) arr[i] = Integer.parseInt(set[i]);

        Arrays.sort(arr);
        for (int i = 0; i < count; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], map.size());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(map.get(Integer.parseInt(set[i])));
            sb.append(' ');
        }

        System.out.println(sb.toString());
    }
}