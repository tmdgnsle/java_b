import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        
        List<Integer> candidateKeys = new ArrayList<>();
        
        // 모든 조합 (1 ~ 2^col - 1)
        for (int i = 1; i < (1 << col); i++) {
            
            // 1. 최소성 검사
            boolean isMinimal = true;
            for (int key : candidateKeys) {
                if ((key & i) == key) { // 기존 키가 부분집합이면 탈락
                    isMinimal = false;
                    break;
                }
            }
            if (!isMinimal) continue;
            
            // 2. 유일성 검사
            Set<String> set = new HashSet<>();
            
            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                
                for (int c = 0; c < col; c++) {
                    if ((i & (1 << c)) != 0) {
                        sb.append(relation[r][c]).append(",");
                    }
                }
                
                set.add(sb.toString());
            }
            
            if (set.size() == row) {
                candidateKeys.add(i);
            }
        }
        
        return candidateKeys.size();
    }
}