import java.io.*;
import java.util.*;

public class Main {

    static class Razer{
        int razer;
        int idx;

        public Razer(int razer, int idx){
            this.razer = razer;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] razers = new int[n+1];
        Stack<Razer> temp = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            razers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n+1];

        for(int i = n; i>=1; i--){
            if(temp.isEmpty()){
                temp.add(new Razer(razers[i], i));
            } else {
                if(temp.peek().razer > razers[i]){
                    temp.push(new Razer(razers[i], i));
                    continue;
                }
                while(!temp.isEmpty() && temp.peek().razer < razers[i]){
                    Razer current = temp.pop();
                    result[current.idx] = i;
                }
                temp.push(new Razer(razers[i], i));
            }
        }

        for(int i =1; i<=n; i++){
            System.out.print(result[i] + " ");
        }

    }
}