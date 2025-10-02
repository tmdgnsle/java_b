class Solution {
    public int solution(int[] a) {
        int n = a.length;
        
        // 풍선이 1개 또는 2개면 모두 남을 수 있음
        if (n <= 2) return n;
        
        int answer = 0;
        
        // 각 위치에서 왼쪽 최솟값과 오른쪽 최솟값을 저장
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        // 왼쪽에서부터 최솟값 계산
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        // 오른쪽에서부터 최솟값 계산
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        // 각 풍선이 마지막까지 남을 수 있는지 확인
        for (int i = 0; i < n; i++) {
            // 양쪽 끝은 항상 남을 수 있음
            if (i == 0 || i == n - 1) {
                answer++;
                continue;
            }
            
            // 왼쪽 최솟값 또는 오른쪽 최솟값보다 작거나 같으면 남을 수 있음
            // (한쪽이라도 현재 값보다 크면, 작은 쪽을 계속 터뜨리다가 마지막에 남을 수 있음)
            if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                answer++;
            }
        }
        
        return answer;
    }
}