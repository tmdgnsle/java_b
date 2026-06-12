class Solution {
    public int solution(int[][] signals) {
        int[] totals = new int[signals.length];
        for(int i = 0; i<signals.length; i++){
            int total = 0;
            for(int j = 0; j<3; j++){
                total += signals[i][j];
            }
            totals[i] = total;
        }
        
        int time = totals[0];
        for(int i = 0; i<totals.length - 1; i++){
            time = lcm(time, totals[i+1]);
        }
        
        
        int answer = -1;
        int c = 1;
        
        while(c <= time){
            boolean finish = true;
            for(int i = 0; i<totals.length; i++){
                int remain = c % totals[i];
                if(remain > signals[i][0] && remain <= signals[i][0] + signals[i][1]){
                    if(i == totals.length - 1) {
                        finish = true;
                        answer = c;
                    }            
                }else {
                    finish = false;
                    break;
                }
            }
            if(finish) break;
            c++;
        }
        return answer;
    }
    
    static int lcm(int a, int b){
        return a / gcd(a, b) * b;
    }
    
    static int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}