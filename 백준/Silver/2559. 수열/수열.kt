import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    var sum = 0
    for (i in 0 until k) {
        sum += arr[i]
    }

    var answer = sum

    for (i in k until n) {
        sum += arr[i]
        sum -= arr[i - k]
        answer = max(answer, sum)
    }

    println(answer)
}