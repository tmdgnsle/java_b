import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int[][] scores;
    static ArrayList<Integer> arr;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n][n];
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new ArrayList<>();

        bt(0);

        System.out.println(answer);
    }

    static void bt(int idx){
        if(arr.size() == n / 2){
            calculate();
            return;
        }
        for(int i = idx; i<n; i++){
            arr.add(i);
            bt(i+1);
            arr.remove(arr.size() - 1);
        }
    }

    static void calculate(){
        int idx = 0;
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0; i<n; i++){
            
            if(idx < n/2 && i == arr.get(idx)){
                idx++;
                continue;
            }
            arr2.add(i);
        }

        int total1 = 0;
        int total2 = 0;

        for(int i = 0; i<n/2; i++){
            for(int j = 0; j<n/2; j++){
                if(i==j) continue;

                total1+=scores[arr.get(i)][arr.get(j)];
                total2+=scores[arr2.get(i)][arr2.get(j)];

            }
        }

        int diff = Math.abs(total1 - total2);
        answer = Math.min(answer, diff);

    }
}