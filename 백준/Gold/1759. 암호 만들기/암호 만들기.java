import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static String[] alph;
    static String m = "aeiou";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alph = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alph[i] = st.nextToken();
        }

        Arrays.sort(alph);


        bt("", 0);

    }

    static void bt(String current, int index){
        if(current.length() == L){
            int mo = 0;
            int ja = 0;
            for (int i = 0; i < L; i++) {
                String str = current.substring(i, i+1);
                if(m.contains(str)) {
                    mo++;
                } else {
                    ja++;
                }
            }
            if(mo >= 1 && ja >= 2) System.out.println(current);
            return;
        }



        for (int i = index; i < C; i++) {
            String next = current + alph[i];
            bt(next, i+1);
        }
    }

}