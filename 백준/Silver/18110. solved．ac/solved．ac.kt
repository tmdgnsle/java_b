import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    if (n == 0) {
        println(0)
        return
    }

    val arr = IntArray(n)
    for (i in 0 until n) {
        arr[i] = br.readLine().toInt()
    }

    arr.sort()

    val cut = Math.round(n * 0.15).toInt()

    var sum = 0
    for (i in cut until n - cut) {
        sum += arr[i]
    }

    val avg = Math.round(sum.toDouble() / (n - 2 * cut)).toInt()
    println(avg)
}