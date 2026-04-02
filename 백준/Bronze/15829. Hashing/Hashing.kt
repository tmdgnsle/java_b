import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()
    val str = br.readLine().toCharArray()


    var total = 0L
    for (i in 0 until N) {
        var r = 1
        repeat(i) {
            r *= 31
        }
        total += (str[i] - 'a' + 1) * r
    }

    println(total % 1234567891)


}