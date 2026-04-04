import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val m = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val isPrime = BooleanArray(n + 1) { true }

    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..n) {
        if (i * i > n) break
        if (isPrime[i]) {
            for (j in i * i..n step i) {
                isPrime[j] = false
            }
        }
    }

    for (i in m..n) {
        if (isPrime[i]) println(i)
    }

}




