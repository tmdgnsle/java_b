import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    out@ while (true) {
        val num = br.readLine()
        if (num.equals("0")) break
        val length = num.length

        for (i in 0 until length / 2) {
            if (num[i] != num[length - 1 - i]) {
                println("no")
                continue@out
            }
        }
        println("yes")

    }
}