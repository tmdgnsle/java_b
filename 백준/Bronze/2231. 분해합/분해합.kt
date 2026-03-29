import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var answer = 0

    for (i in 1 until N) {
        val sum = i + i.toString().sumOf { it - '0' }

        if (sum == N) {
            answer = i
            break
        }
    }

    println(answer)
}