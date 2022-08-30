import java.util.Scanner;

public class _1152{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner s = new Scanner(sc.nextLine());
        int i = 0;
        while (s.hasNext()) {
            s.next();
            i++;
        }

        System.out.print(i);
    }
}
