import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        int idx = 0; // S에서 매칭되고 있는 위치
        int num = 0; // 현재 이어 쓰고 있는 자연수

        while (idx < S.length()) {
            num++;
            String cur = Integer.toString(num);

            for (int i = 0; i < cur.length() && idx < S.length(); i++) {
                if (cur.charAt(i) == S.charAt(idx)) {
                    idx++; // 매칭되면 S의 다음 문자로 이동
                }
            }
        }

        System.out.println(num);
    }
}