import java.io.*;
import java.util.*;

public class Main {

    static String S, T;
    static boolean answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        answer = false;

        dfs(T);

        if(answer) System.out.println("1");
        else System.out.println("0");
    }

    static void dfs(String word) {
        if(answer) return; // 이미 답을 찾았으면 더 이상 탐색하지 않음

        if(word.length() == S.length()) {
            if(word.equals(S)) {
                answer = true;
            }
            return;
        }

        if(word.length() < S.length()) return; // 길이가 S보다 작으면 불가능

        // 끝이 A로 끝나는 경우: A를 제거
        if(word.charAt(word.length() - 1) == 'A') {
            dfs(word.substring(0, word.length() - 1));
        }

        // 시작이 B로 시작하는 경우: 뒤집고 맨 뒤 B 제거
        if(word.charAt(0) == 'B') {
            String reversed = new StringBuilder(word).reverse().toString();
            dfs(reversed.substring(0, reversed.length() - 1));
        }
    }
}