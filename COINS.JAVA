import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
            totalSum += coins[i];
        }

        
        Arrays.sort(coins);
        int mySum = 0;
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {
            mySum += coins[i];
            count++;
            if (mySum > totalSum - mySum) {
                break;
            }
        }

        System.out.println(count);
    }
}
