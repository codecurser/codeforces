import java.io.*;
import java.util.*;
 
public class Main {
 
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;
 
        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
 
        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val;
        }
 
        long nextLong() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val;
        }
 
        String next() throws IOException {
            int c;
            while ((c = read()) <= ' ');
            StringBuilder sb = new StringBuilder();
            while (c > ' ') {
                sb.append((char) c);
                c = read();
            }
            return sb.toString();
        }
    }
 
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder out = new StringBuilder();
 
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();
            int k = fs.nextInt();
 
            long[] robots = new long[n];
            for (int i = 0; i < n; i++) robots[i] = fs.nextLong();
 
            long[] spikes = new long[m];
            for (int i = 0; i < m; i++) spikes[i] = fs.nextLong();
 
            String s = fs.next();
 
            Arrays.sort(spikes);
 
            // prefix movement
            long[] minPref = new long[k + 1];
            long[] maxPref = new long[k + 1];
            long cur = 0;
 
            for (int i = 1; i <= k; i++) {
                cur += (s.charAt(i - 1) == 'L') ? -1 : 1;
                minPref[i] = Math.min(minPref[i - 1], cur);
                maxPref[i] = Math.max(maxPref[i - 1], cur);
            }
 
            // death time of each robot
            int[] death = new int[n];
            Arrays.fill(death, k + 1);
 
            for (int i = 0; i < n; i++) {
                long r = robots[i];
 
                int lo = 1, hi = k, ans = k + 1;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    long L = r + minPref[mid];
                    long R = r + maxPref[mid];
 
                    // check if any spike in [L, R]
                    int idx = Arrays.binarySearch(spikes, L);
                    if (idx < 0) idx = -idx - 1;
 
                    if (idx < m && spikes[idx] <= R) {
                        ans = mid;
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                }
                death[i] = ans;
            }
 
            // prefix count of deaths
            int[] deadCount = new int[k + 2];
            for (int d : death) {
                if (d <= k) deadCount[d]++;
            }
 
            int alive = n;
            for (int i = 1; i <= k; i++) {
                alive -= deadCount[i];
                out.append(alive).append(' ');
            }
            out.append('\n');
        }
 
        System.out.print(out);
    }
}
