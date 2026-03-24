import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < n; t++) {
            String line = br.readLine();
            int idx = -1;

            StringTokenizer st = new StringTokenizer(line);
            int pos = 0;

            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                while (pos < line.length() && line.charAt(pos) == ' ') {
                    pos++;
                }

                char c = line.charAt(pos);
                int alpha = Character.toLowerCase(c) - 'a';

                if (!used[alpha]) {
                    used[alpha] = true;
                    idx = pos;
                    break;
                }

                pos += word.length();
            }

            if (idx == -1) {
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (Character.isAlphabetic(c)) {
                        int alpha = Character.toLowerCase(c) - 'a';
                        if (!used[alpha]) {
                            used[alpha] = true;
                            idx = i;
                            break;
                        }
                    }
                }
            }

            if (idx == -1) {
                sb.append(line).append("\n");
            } else {
                sb.append(line, 0, idx)
                        .append('[')
                        .append(line.charAt(idx))
                        .append(']')
                        .append(line.substring(idx + 1))
                        .append("\n");
            }

        }

        System.out.println(sb);


    }
}