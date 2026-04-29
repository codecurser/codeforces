import java.util.*;
 
public class Dragons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int s = sc.nextInt();
        int n = sc.nextInt();
 
        int[][] dragons = new int[n][2];
 
        for (int i = 0; i < n; i++) {
            dragons[i][0] = sc.nextInt(); // strength
            dragons[i][1] = sc.nextInt(); // bonus
        }
 
        // Sort dragons by strength
        Arrays.sort(dragons, Comparator.comparingInt(a -> a[0]));
 
        for (int i = 0; i < n; i++) {
            if (s > dragons[i][0]) {
                s += dragons[i][1];
            } else {
                System.out.println("NO");
                return;
            }
        }
 
        System.out.println("YES");
    }
}
