import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val str = br.readLine()

    val mod = 1234567891L
    var total = 0L
    var r = 1L

    for (i in 0 until n) {
        val value = (str[i] - 'a' + 1).toLong()
        total = (total + value * r) % mod
        r = (r * 31) % mod
    }

    println(total)
}