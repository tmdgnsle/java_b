import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.sqrt

fun isPrime(n: Int): Boolean {
    if (n < 2) return false

    for (i in 2..sqrt(n.toDouble()).toInt()) {
        if (n % i == 0) return false
    }
    return true
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    var count = 0

    repeat(n) {
        val num = st.nextToken().toInt()
        if (isPrime(num)) count++
    }

    println(count)
}