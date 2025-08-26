import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int dangerCount = 0;
        
        // 각 로봇의 전체 경로를 시간순으로 저장
        List<List<int[]>> allPaths = new ArrayList<>();
        
        for(int[] route : routes) {
            List<int[]> path = new ArrayList<>();
            
            // 시작점
            int[] currentPos = {points[route[0] - 1][0], points[route[0] - 1][1]};
            path.add(new int[]{currentPos[0], currentPos[1]});
            
            // 각 목적지로의 경로 생성
            for(int i = 1; i < route.length; i++) {
                int[] target = {points[route[i] - 1][0], points[route[i] - 1][1]};
                
                // 현재 위치에서 목표까지 이동
                while(currentPos[0] != target[0] || currentPos[1] != target[1]) {
                    // r 좌표 우선 이동
                    if(currentPos[0] != target[0]) {
                        if(currentPos[0] < target[0]) {
                            currentPos[0]++;
                        } else {
                            currentPos[0]--;
                        }
                    }
                    // r 좌표가 같아지면 c 좌표 이동
                    else if(currentPos[1] != target[1]) {
                        if(currentPos[1] < target[1]) {
                            currentPos[1]++;
                        } else {
                            currentPos[1]--;
                        }
                    }
                    
                    path.add(new int[]{currentPos[0], currentPos[1]});
                }
            }
            
            allPaths.add(path);
        }
        
        // 각 시간별로 충돌 확인
        int maxTime = allPaths.stream().mapToInt(List::size).max().orElse(0);
        
        for(int time = 0; time < maxTime; time++) {
            Map<String, Integer> positionCount = new HashMap<>();
            
            // 각 로봇의 현재 시간 위치 확인
            for(int robot = 0; robot < allPaths.size(); robot++) {
                if(time < allPaths.get(robot).size()) {
                    int[] pos = allPaths.get(robot).get(time);
                    String posKey = pos[0] + "," + pos[1];
                    positionCount.put(posKey, positionCount.getOrDefault(posKey, 0) + 1);
                }
            }
            
            // 2대 이상의 로봇이 같은 위치에 있으면 위험상황
            for(int count : positionCount.values()) {
                if(count >= 2) {
                    dangerCount++;
                }
            }
        }
        
        return dangerCount;
    }
}
