import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Document(val index: Int, val priority: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val sb = StringBuilder()

    val arr = IntArray(n)
    for (i in 0 until n){
        arr[i] = br.readLine().toInt()
    }
    val stack = ArrayDeque<Int>()
    var num = 1
    for (i in arr){
        if(i >= num){
            while(i >= num){
                stack.addFirst(num++)
                sb.append("+\n")
            }
            stack.removeFirst()
            sb.append("-\n")
        }else{
            val current = stack.removeFirst()
            if(current > i){
                println("NO")
                return
            }else{
                sb.append("-\n")
            }
        }
    }


    println(sb)

}


