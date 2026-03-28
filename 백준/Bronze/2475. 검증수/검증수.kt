import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    var total = 0
    repeat(5){
        val num = st.nextToken().toInt()
        total += num * num
    }

    print(total % 10)

}

