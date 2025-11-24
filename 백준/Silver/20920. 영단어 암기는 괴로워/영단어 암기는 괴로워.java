import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue; 

            map.put(word, map.getOrDefault(word, 0) + 1);
        }


        List<String> words = new ArrayList<>(map.keySet());

        words.sort((a, b) -> {
            int countA = map.get(a);
            int countB = map.get(b);

            if (countA != countB) return countB - countA;            
            if (a.length() != b.length()) return b.length() - a.length(); 
            return a.compareTo(b);     
        });

        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append("\n");
        }

        System.out.println(sb);
    }
}