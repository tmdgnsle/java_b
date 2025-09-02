import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 현재 행의 최대값, 최소값을 저장할 배열
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        
        // 첫 번째 행 입력 및 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            int num = Integer.parseInt(st.nextToken());
            maxDp[j] = num;
            minDp[j] = num;
        }
        
        // 두 번째 행부터 마지막 행까지 DP 진행
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] input = new int[3];
            for (int j = 0; j < 3; j++) {
                input[j] = Integer.parseInt(st.nextToken());
            }
            
            // 이전 상태를 임시 저장 (현재 배열이 덮어써지기 전에)
            int prevMax0 = maxDp[0], prevMax1 = maxDp[1], prevMax2 = maxDp[2];
            int prevMin0 = minDp[0], prevMin1 = minDp[1], prevMin2 = minDp[2];
            
            // 최대값 DP 갱신
            maxDp[0] = Math.max(prevMax0, prevMax1) + input[0];
            maxDp[1] = Math.max(Math.max(prevMax0, prevMax1), prevMax2) + input[1];
            maxDp[2] = Math.max(prevMax1, prevMax2) + input[2];
            
            // 최소값 DP 갱신
            minDp[0] = Math.min(prevMin0, prevMin1) + input[0];
            minDp[1] = Math.min(Math.min(prevMin0, prevMin1), prevMin2) + input[1];
            minDp[2] = Math.min(prevMin1, prevMin2) + input[2];
        }
        
        // 결과 출력: 마지막 행에서의 최대값과 최소값
        int maxResult = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int minResult = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);
        
        System.out.println(maxResult + " " + minResult);
    }
}

/* 
시간복잡도: O(N) - 각 행을 한 번씩만 처리
공간복잡도: O(1) - 현재 행의 정보만 저장

DP 점화식:
- maxDp[0] = max(이전행[0], 이전행[1]) + 현재값[0]
- maxDp[1] = max(이전행[0], 이전행[1], 이전행[2]) + 현재값[1]  
- maxDp[2] = max(이전행[1], 이전행[2]) + 현재값[2]

minDp도 동일하게 min으로 계산
*/