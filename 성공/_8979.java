import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class _8979 {
    static class Country implements Comparable<Country>{
        int idx, g, s, c;

        public Country(int idx, int g, int s, int c) {
            this.idx = idx;
            this.g = g;
            this.s = s;
            this.c = c;
        }

        @Override
        public int compareTo(Country o) {
            return (o.g != g) ? o.g - g : (o.s != s) ? o.s - s : (o.c != c) ? o.c - c : 0;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");

        int numOfCountry = Integer.parseInt(set[0]);
        int target = Integer.parseInt(set[1]);

        LinkedList<Country> list = new LinkedList<>();
        for (int i = 0; i < numOfCountry; i++) {
            set = br.readLine().split(" ");
            int idx = Integer.parseInt(set[0]);
            int g = Integer.parseInt(set[1]);
            int s = Integer.parseInt(set[2]);
            int c = Integer.parseInt(set[3]);

            list.add(new Country(idx, g, s, c));
        }

        Collections.sort(list);

        Country last = list.get(0);
        int ranking = 1;
        int ghostRank = 0;
        for (Country cur : list) {
            if (last.compareTo(cur) != 0) {
                ranking += ghostRank;
                ghostRank = 1;
            }
            else {
                ghostRank++;
            }

            if (cur.idx == target) {
                break;
            }

            last = cur;
        }

        System.out.println(ranking);
    }
}