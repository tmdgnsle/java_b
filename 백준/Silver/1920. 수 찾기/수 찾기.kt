import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val m = br.readLine().toInt()
    val findNum = br.readLine().split(" ").map { it.toInt() }
    arr.sort()

    val sb = StringBuilder()

    for(target in findNum){
        var start = 0
        var end = n-1

        var find = false
        while(start <= end){
            val mid = (start + end) / 2
            if(arr[mid] > target){
                end = mid-1
            }else if(arr[mid] < target) {
                start = mid+1
            }else {
                find = true
                break
            }
        }

        if(find) sb.append(1)
        else sb.append(0)

        sb.append("\n")

    }
    println(sb)
}



