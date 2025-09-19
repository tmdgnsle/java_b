import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int M = Integer.parseInt(br.readLine());
        boolean[] S = new boolean[21];


        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String operation = input[0];

            switch (operation) {
                case "add":
                    int addNum = Integer.parseInt(input[1]);
                    S[addNum] = true;
                    break;

                case "remove":
                    int removeNum = Integer.parseInt(input[1]);
                    S[removeNum] = false;
                    break;

                case "check":
                    int checkNum = Integer.parseInt(input[1]);
                    if(S[checkNum]){
                        sb.append(1 + "\n");
                    }else {
                        sb.append(0 + "\n");
                    }
                    break;

                case "toggle":
                    int toggleNum = Integer.parseInt(input[1]);
                    S[toggleNum] = !S[toggleNum];
                    break;

                case "all":
                    Arrays.fill(S, true);
                    break;

                case "empty":
                    Arrays.fill(S, false);
                    break;
            }
        }
        System.out.print(sb);


    }
}