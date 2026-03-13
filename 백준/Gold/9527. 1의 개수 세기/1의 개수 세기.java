import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(countOnes(B) - countOnes(A - 1));
    }

    static long countOnes(long x) {
        if (x < 0) return 0;

        long count = 0;

        for (long bit = 1; bit <= x; bit <<= 1) { // bit = bit << 1
            long cycle = bit << 1; // bit * 2 -> 2진수로 바꿨을 때 1자리 위로 올린다 -> 0010을 0100으로
            long fullCycles = (x + 1) / cycle;
            long remainder = (x + 1) % cycle;

            count += fullCycles * bit;
            count += Math.max(0, remainder - bit);
        }

        return count;
    }
}