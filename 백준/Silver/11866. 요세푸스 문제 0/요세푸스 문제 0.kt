import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val q = ArrayDeque<Int>()
    for (i in 1..n) q.addLast(i)

    val sb = StringBuilder()
    sb.append("<")

    var count = 0
    while (q.isNotEmpty()){
        val num = q.removeFirst()
        count++
        if(count == k){
            sb.append(num)
            if(q.isNotEmpty()){
                sb.append(", ")
            }
            count = 0
        }else {
            q.addLast(num)
        }
    }
    sb.append(">")

    println(sb)

}