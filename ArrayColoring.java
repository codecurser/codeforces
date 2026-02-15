
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int odd = 0, even = 0;

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (x % 2 == 0)
                    even++;
                else
                    odd++;
            }

            if (odd >= 2 || (odd >= 1 && even >= 1))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
