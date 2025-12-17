import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;

        int a = 0;
        int b = 0;
        for(int i = 0; i<A.length; i++){
            a += A[i] * B[B.length - i - 1];
            b += B[i] * A[A.length - i - 1];
        }
        answer = Math.min(a, b);

        return answer;
    }
}