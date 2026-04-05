class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer: Long = 0
        
        val max = maxOf(a, b)
        val min = minOf(a, b)
        for(i in min..max){
            answer += i
        }
        
        return answer
    }
}