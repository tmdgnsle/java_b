import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N을 i번 사용해서 만들 수 있는 수들의 집합을 저장
        // dp[i] = N을 i번 사용해서 만들 수 있는 모든 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        
        // 0번 사용하는 경우는 없으므로 인덱스 맞추기 위해 빈 집합 추가
        dp.add(new HashSet<>());
        
        for (int i = 1; i <= 8; i++) {
            Set<Integer> currentSet = new HashSet<>();
            
            // N을 i번 연속으로 붙인 수 추가 (예: N=5일 때, 5, 55, 555, ...)
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            currentSet.add(repeatedN);
            
            // j개와 (i-j)개를 사용한 집합들의 모든 조합으로 새로운 수 생성
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);           // N을 j번 사용한 집합
                Set<Integer> set2 = dp.get(i - j);       // N을 (i-j)번 사용한 집합
                
                // 두 집합의 모든 원소에 대해 사칙연산 수행
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        // 덧셈
                        currentSet.add(num1 + num2);
                        
                        // 뺄셈 (양방향)
                        currentSet.add(num1 - num2);
                        currentSet.add(num2 - num1);
                        
                        // 곱셈
                        currentSet.add(num1 * num2);
                        
                        // 나눗셈 (0으로 나누는 경우 제외)
                        if (num2 != 0) {
                            currentSet.add(num1 / num2);
                        }
                        if (num1 != 0) {
                            currentSet.add(num2 / num1);
                        }
                    }
                }
            }
            
            dp.add(currentSet);
            
            // 현재 집합에서 목표 숫자를 찾았다면 현재 사용 횟수 반환
            if (currentSet.contains(number)) {
                return i;
            }
        }
        
        // 8번 이하로 만들 수 없는 경우
        return -1;
    }
}

