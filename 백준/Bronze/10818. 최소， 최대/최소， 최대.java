

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> input = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int number: input) {
            min = Math.min(min, number);
            max = Math.max(max, number);
        }

        System.out.println(min + " " + max);



//        System.out.println(input.stream()
//                .max(Integer::compareTo)
//                .get());

    }
}
