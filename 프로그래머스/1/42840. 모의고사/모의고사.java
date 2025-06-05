import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        // 각 수포자의 찍기 패턴
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 각 수포자의 정답 개수
        int[] scores = new int[3];
        
        // 각 문제에 대해 정답 비교
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            
            // 1번 수포자 정답 확인
            if(answer == pattern1[i % pattern1.length]) {
                scores[0]++;
            }
            
            // 2번 수포자 정답 확인
            if(answer == pattern2[i % pattern2.length]) {
                scores[1]++;
            }
            
            // 3번 수포자 정답 확인
            if(answer == pattern3[i % pattern3.length]) {
                scores[2]++;
            }
        }
        
        // 최고 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // 최고 점수를 받은 수포자들 찾기
        List<Integer> winners = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            if(scores[i] == maxScore) {
                winners.add(i + 1); // 수포자 번호는 1부터 시작
            }
        }
        
        // List를 배열로 변환
        
        int[] result = new int[winners.size()];
        for(int i = 0; i<winners.size(); i++){
            result[i] = winners.get(i);
        }
        
        return result;
    }
}