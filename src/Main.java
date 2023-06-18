import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
    사용되지 않은 항목을 저장하고 한 번호를 10자리로 만들어 모두 검사후 결과가 가장 큰 값을 다음 run에게 전달
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set = br.readLine().split(" ");

        int n = Integer.parseInt(set[0]);
        int m = Integer.parseInt(set[1]);




        set = br.readLine().split(" ");
        int[] arr = new int[set.length];
        for (int i=0; i<set.length; i++) arr[i] = Integer.parseInt(set[i]);
    }
}