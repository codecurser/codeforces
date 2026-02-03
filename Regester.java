import java.util.HashMap;
import java.util.Scanner;

public class RegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();

            if (!map.containsKey(name)) {
                System.out.println("OK");
                map.put(name, 1);
            } else {
                int count = map.get(name);
                String newName = name + count;
                System.out.println(newName);

                map.put(name, count + 1);
                map.put(newName, 1);
            }
        }
        sc.close();
    }
}
