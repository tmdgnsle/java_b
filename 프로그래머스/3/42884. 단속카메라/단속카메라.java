import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 차량들을 진출 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int cameraCount = 0;
        int lastCameraPosition = Integer.MIN_VALUE;
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            // 현재 차량이 마지막 카메라 위치를 지나지 않는 경우
            if (start > lastCameraPosition) {
                // 새로운 카메라를 진출 지점에 설치
                cameraCount++;
                lastCameraPosition = end;
            }
        }
        
        return cameraCount;
    }
}