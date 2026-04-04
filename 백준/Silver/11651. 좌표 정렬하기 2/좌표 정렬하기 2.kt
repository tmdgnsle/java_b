import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        arr.add(Pair(x, y))
    }

    arr.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

    for (pair in arr) {
        println("${pair.first} ${pair.second}")
    }
}