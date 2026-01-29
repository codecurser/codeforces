import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int)1e9;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();

            int[] freq = new int[n + 1];
            for (int i = 0; i < n; i++) {
                freq[fs.nextInt()]++;
            }

            int[] dp = new int[n + 1];
            Arrays.fill(dp, INF);

            // Direct usage
            for (int i = 1; i <= n; i++) {
                if (freq[i] > 0) dp[i] = 1;
            }

            // DP transitions
            for (int i = 1; i <= n; i++) {
                if (dp[i] == INF) continue;
                for (int j = i * 2; j <= n; j += i) {
                    int x = j / i;
                    if (freq[x] > 0) {
                        dp[j] = Math.min(dp[j], dp[i] + 1);
                    }
                }
            }

            // Output
            for (int i = 1; i <= n; i++) {
                out.append(dp[i] == INF ? -1 : dp[i]).append(' ');
            }
            out.append('\n');
        }

        System.out.print(out);
    }

    // -------- Fast Scanner --------
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
