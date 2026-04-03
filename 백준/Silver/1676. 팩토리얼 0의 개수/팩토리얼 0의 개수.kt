import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var answer = 0
    var num = n

    while (num >= 5) {
        num /= 5
        answer += num
    }

    println(answer)
}