import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    val c = br.readLine().toInt()

    val total = a * b * c

    val count = IntArray(10)
    for(num in total.toString()){
        count[num - '0']++
    }

    for (num in count) println(num)

}

