import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        char G;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        G = st.nextToken().charAt(0);

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<N; i++){
            set.add(br.readLine());
        }

        int answer = 0;

        int total = set.size();

        if(G == 'Y'){
            answer = total;
        }else if(G == 'F'){
            answer = total / 2;
        }else if(G == 'O'){
            answer = total / 3;
        }

        System.out.println(answer);

    }
}