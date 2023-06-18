import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");

        int count = Integer.parseInt(set[0]);
        int qCount = Integer.parseInt(set[1]);
        HashMap<String,String> map = new HashMap<>();

        for (int i = 0; i < count; i++) {
            set = br.readLine().split(" ");
            map.put(set[0], set[1]);
        }

        for (int i = 0; i < qCount; i++) {
            String q = br.readLine();
            System.out.println(map.get(q));
        }
    }
}
// 테스트 케이스 통과, 해시라 아마 맞을 거임