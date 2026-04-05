import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val s = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = st.nextToken().toInt()
    }

    var left = 0
    var sum = 0
    var answer = Int.MAX_VALUE

    for (right in 0 until n) {
        sum += arr[right]

        while (sum >= s) {
            answer = min(answer, right - left + 1)
            sum -= arr[left]
            left++
        }
    }

    println(if (answer == Int.MAX_VALUE) 0 else answer)
}