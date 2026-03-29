import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val arr = br.readLine().split(" ").map { it.toInt() }

    val asc = arr.sorted()
    val desc = arr.sortedDescending()

    when {
        arr == asc -> println("ascending")
        arr == desc -> println("descending")
        else -> println("mixed")
    }
}