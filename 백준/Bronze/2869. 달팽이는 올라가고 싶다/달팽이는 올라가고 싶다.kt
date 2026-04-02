import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    val v = st.nextToken().toInt()

    val daily = a - b
    val beforeLast = v - a

    val answer = if (beforeLast <= 0) {
        1
    } else {
        (beforeLast + daily - 1) / daily + 1 
    }

    println(answer)
}