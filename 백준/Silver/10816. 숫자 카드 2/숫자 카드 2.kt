import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashMap
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = HashMap<Int, Int>()
    val st = StringTokenizer(br.readLine())
    repeat(n){
        val num = st.nextToken().toInt()
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val m = br.readLine().toInt()
    val st2 = StringTokenizer(br.readLine())
    val sb = StringBuilder()
    repeat(m){
        val num = st2.nextToken().toInt()
        val count = map.getOrDefault(num, 0)
        sb.append(count).append(" ")
    }
    
    println(sb)

}