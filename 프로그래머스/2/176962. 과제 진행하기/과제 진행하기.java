import java.util.*;

class Solution {

    static class Homework implements Comparable<Homework> {
        String title;
        int start;
        int time;

        Homework(String title, int start, int time) {
            this.title = title;
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Homework o) {
            return this.start - o.start;
        }
    }

    static class Pause {
        String title;
        int remain;

        Pause(String title, int remain) {
            this.title = title;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;

        PriorityQueue<Homework> pq = new PriorityQueue<>();

        for (String[] plan : plans) {
            String title = plan[0];
            int start = toMinute(plan[1]);
            int time = Integer.parseInt(plan[2]);

            pq.add(new Homework(title, start, time));
        }

        Stack<Pause> stack = new Stack<>();

        Homework now = pq.poll();

        while (!pq.isEmpty()) {
            Homework next = pq.poll();

            int availableTime = next.start - now.start;

            if (now.time <= availableTime) {
                answer[idx++] = now.title;

                int remainTime = availableTime - now.time;

                while (remainTime > 0 && !stack.isEmpty()) {
                    Pause pause = stack.pop();

                    if (pause.remain <= remainTime) {
                        remainTime -= pause.remain;
                        answer[idx++] = pause.title;
                    } else {
                        pause.remain -= remainTime;
                        stack.push(pause);
                        remainTime = 0;
                    }
                }
            } else {
                int remain = now.time - availableTime;
                stack.push(new Pause(now.title, remain));
            }

            now = next;
        }

        answer[idx++] = now.title;

        while (!stack.isEmpty()) {
            answer[idx++] = stack.pop().title;
        }

        return answer;
    }

    static int toMinute(String time) {
        String[] arr = time.split(":");
        int h = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        return h * 60 + m;
    }
}