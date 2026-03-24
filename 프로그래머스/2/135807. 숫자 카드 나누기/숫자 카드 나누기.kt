class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val gcdA = getgcdArray(arrayA)
        val gcdB = getgcdArray(arrayB)
        
        val answerA = if (canDivide(gcdA, arrayB)) gcdA else 0
        val answerB = if (canDivide(gcdB, arrayA)) gcdB else 0
        
        return maxOf(answerA, answerB)
    }
    
    private fun getgcdArray(arr: IntArray): Int {
        var gcd = arr[0]
        for(i in 1 until arr.size) {
            gcd = gcd(gcd, arr[i])
        }
        return gcd
    }
    
    private fun gcd(a: Int, b: Int): Int{
        var x = a
        var y = b
        while(y != 0){
            val temp = x % y
            x = y
            y = temp
        }
        return x
    }
    
    private fun canDivide(num: Int, arr: IntArray): Boolean {
        for(x in arr){
            if(x % num == 0) return false
        }
        return true
    }
}