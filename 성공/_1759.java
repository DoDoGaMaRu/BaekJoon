import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1759 {
    static char[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");

        int wordLen = Integer.parseInt(set[0]);
        int count = Integer.parseInt(set[1]);

        arr = new char[count];
        visit = new boolean[count];
        set = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = set[i].charAt(0);
        }
        Arrays.sort(arr);

        set(0, wordLen, 0, 0, 0);
    }

    static char[] c = {'a', 'e', 'i', 'o', 'u'};

    public static void set(int idx, int len, int count, int ja, int mo) {
        if (idx == arr.length) {
            if (count == len) {
                if (ja >= 2 && mo >= 1) {
                    print();
                }
            }
            return;
        }

        visit[idx] = true;
        boolean m = false;
        for (char x : c) if (x == arr[idx]) m = true;
        set(idx + 1, len, count + 1, m ? ja : (ja + 1), m ? (mo + 1) : mo);
        visit[idx] = false;
        set(idx + 1, len, count, ja, mo);
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (visit[i]) sb.append(arr[i]);
        }

        System.out.println(sb.toString());
    }
}