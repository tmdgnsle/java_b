import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val shirts = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val T = st.nextToken().toInt()
    val P = st.nextToken().toInt()

    var total = 0
    for(shirt in shirts){
        total += shirt / T
        if(shirt % T > 0) total++
    }
    println(total)

    println("${N / P} ${N % P}")


}