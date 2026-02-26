class Solution {
    public long solution(int w, int h) {
        long W = w;
        long H = h;
        
        long gcd = gcd(W, H); // 최대 공약수 만큼 패턴이 반복됨
        
        return W * H - (W + H - gcd);
    }
    
    long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}