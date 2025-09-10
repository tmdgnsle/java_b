import java.util.*;

class Solution {
    static class Job implements Comparable<Job>{
        int requestTime;
        int duration;
        
        public Job(int requestTime, int duration){
            this.requestTime = requestTime;
            this.duration = duration;
        }
        
        @Override
        public int compareTo(Job o){
            if(this.duration == o.duration){
                return this.requestTime - o.requestTime; 
            }
            return this.duration - o.duration;
        }
    }
    
    public int solution(int[][] jobs) {
        // 1. 요청시간 기준으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>(); // 수행시간 짧은 순
        
        int currentTime = 0; // 현재 시간
        int totalWaitTime = 0; // 총 대기시간
        int jobIndex = 0; // 처리할 작업 인덱스
        int completedJobs = 0; // 완료된 작업 수
        
        while(completedJobs < jobs.length) {
            // 현재 시간까지 요청된 모든 작업을 우선순위 큐에 추가
            while(jobIndex < jobs.length && jobs[jobIndex][0] <= currentTime) {
                pq.offer(new Job(jobs[jobIndex][0], jobs[jobIndex][1]));
                jobIndex++;
            }
            
            if(!pq.isEmpty()) {
                // 우선순위 큐에서 수행시간이 가장 짧은 작업 처리
                Job currentJob = pq.poll();
                currentTime += currentJob.duration;
                
                // 대기시간 = (작업완료시간 - 작업요청시간)
                totalWaitTime += (currentTime - currentJob.requestTime);
                completedJobs++;
            } else {
                // 처리할 작업이 없으면 다음 작업의 요청시간으로 이동
                if(jobIndex < jobs.length) {
                    currentTime = jobs[jobIndex][0];
                }
            }
        }
        
        return totalWaitTime / jobs.length;
    }
}