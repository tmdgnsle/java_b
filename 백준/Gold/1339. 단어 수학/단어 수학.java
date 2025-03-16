import java.io.*;
import java.util.*;

public class Main {
    static String[] words;
    static int[] alphValue;   // 각 알파벳에 할당된 숫자 저장
    static ArrayList<Character> usedAlph; // 사용된 알파벳 목록
    static boolean[] used;     // 사용된 숫자 체크
    static int N;
    static long maxResult;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        alphValue = new int[26]; // A-Z
        used = new boolean[10];  // 0-9
        usedAlph = new ArrayList<>();
        maxResult = Long.MIN_VALUE;
        
        // 단어 입력 받기
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            
            // 사용된 알파벳 추가
            for (char c : words[i].toCharArray()) {
                if (!usedAlph.contains(c)) {
                    usedAlph.add(c);
                }
            }
        }
        
        // 그리디 접근법 사용 - 각 알파벳의 가중치 계산
        int[] weight = new int[26];
        for (int i = 0; i < N; i++) {
            String word = words[i];
            int len = word.length();
            
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                // 자릿수에 따른 가중치 부여 (10^자릿수)
                weight[c - 'A'] += (int)Math.pow(10, len - j - 1);
            }
        }
        
        // 가중치에 따라 알파벳 정렬
        Integer[] indices = new Integer[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (a, b) -> weight[b] - weight[a]);
        
        // 가중치가 높은 알파벳부터 큰 숫자 할당
        int num = 9;
        for (int i = 0; i < 26; i++) {
            if (weight[indices[i]] > 0) {
                alphValue[indices[i]] = num--;
            }
        }
        
        // 최종 합계 계산
        long sum = 0;
        for (int i = 0; i < N; i++) {
            long wordValue = 0;
            for (char c : words[i].toCharArray()) {
                wordValue = wordValue * 10 + alphValue[c - 'A'];
            }
            sum += wordValue;
        }
        
        System.out.println(sum);
    }
}