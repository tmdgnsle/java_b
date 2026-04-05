class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0
        return n.toString()
        .map{it - '0'}
        .toIntArray()
            .sortedDescending()
            .joinToString("")
            .toLong()
    }
}