import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 강연 정보를 저장할 클래스
        class Lecture {
            int pay;
            int deadline;
            
            public Lecture(int pay, int deadline) {
                this.pay = pay;
                this.deadline = deadline;
            }
        }
        
        // 강연 정보 입력 받기
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p, d));
        }
        
        // 페이가 높은 순으로 정렬
        Collections.sort(lectures, (a, b) -> b.pay - a.pay);
        
        // 각 날짜별 강연 스케줄 (기본값은 false로 아직 스케줄이 없음을 의미)
        boolean[] days = new boolean[10001]; // 최대 데드라인이 10000이므로
        int totalPay = 0;
        
        // 페이가 높은 강연부터 스케줄링
        for (Lecture lecture : lectures) {
            // 데드라인부터 1일까지 역순으로 가능한 날짜 찾기
            for (int day = lecture.deadline; day >= 1; day--) {
                if (!days[day]) {  // 해당 날짜에 아직 강연이 없다면
                    days[day] = true;  // 해당 날짜에 강연 스케줄링
                    totalPay += lecture.pay;  // 페이 추가
                    break;  // 다음 강연으로 넘어감
                }
            }
        }
        
        System.out.println(totalPay);
    }
}