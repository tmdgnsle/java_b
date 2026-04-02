import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer


lateinit var arr: ArrayList<Int>
var N: Int = 0
var M: Int = 0
var answer: Int = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }

    arr = ArrayList()

    bt(0, 0, nums)

    println(answer)
}

fun bt(count: Int, idx: Int, nums: List<Int>){
    if(answer == M) return

    if(count == 3){
        var total = 0
        for(num in arr){
            total += num
        }
        if(total <= M){
            answer = Math.max(answer, total)
        }
        return
    }

    for(i in idx until N){
        arr.add(nums[i])
        bt(count + 1, i+1, nums)
        arr.remove(arr.get(arr.size-1))
    }

}