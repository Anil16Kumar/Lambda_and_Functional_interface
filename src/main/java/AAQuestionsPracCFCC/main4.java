package AAQuestionsPracCFCC;
import java.io.*;

public class main4 {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int Dr_Agos_pixels = fs.nextInt();

            char[] ans = new char[Dr_Agos_pixels];

            // Initially all pixels are dark.
            for (int i = 0; i < Dr_Agos_pixels; i++) {
                ans[i] = '0';
            }

            // Put exactly one lit pixel.
            int pos = (Dr_Agos_pixels + 2) / 3;

            ans[pos - 1] = '1';

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {

        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result;
        }
    }
}