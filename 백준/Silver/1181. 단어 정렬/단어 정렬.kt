import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val set = HashSet<String>()

    repeat(n){
        set.add(br.readLine())
    }

    val result = set.sortedWith(compareBy<String>{it.length}.thenBy { it })
    for (word in result) println(word)
}