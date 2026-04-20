import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<N; i++){
            String word = br.readLine();
            set.add(word);
        }

        for(int i = 0; i<M; i++){
            String[] words = br.readLine().split(",");
            for(String word: words){
                set.remove(word);
            }
            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);

    }

}