import java.io.*;
import java.util.*;

public class Main {
    static boolean[] v;
    static int N;
    static ArrayList<Integer> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        v = new boolean[N+1];
        arr = new ArrayList<>();
        bt();
    }

    static void bt(){
        if(arr.size() == N){
            for (int i = 0; i < N; i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!v[i]){
                v[i] = true;
                arr.add(i);
                bt();
                v[i] = false;
                arr.remove(arr.size() - 1);
            }
        }
    }
}