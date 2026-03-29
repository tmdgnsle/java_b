import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val arr = br.readLine().split(" ").map { it.toInt() }.sorted()
        if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break

        if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) println("right")
        else println("wrong")

    }
}