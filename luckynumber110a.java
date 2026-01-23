import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        int count = 0;

        while (n > 0) {
            long digit = n % 10;
            if (digit == 4 || digit == 7) {
                count++;
            }
            n /= 10;
        }

     
        boolean isLucky = true;

        if (count == 0) {
            isLucky = false;
        } else {
            while (count > 0) {
                int d = count % 10;
                if (d != 4 && d != 7) {
                    isLucky = false;
                    break;
                }
                count /= 10;
            }
        }

        System.out.println(isLucky ? "YES" : "NO");
    }
}
