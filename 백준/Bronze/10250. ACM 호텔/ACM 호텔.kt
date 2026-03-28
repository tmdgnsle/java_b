import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val T = br.readLine().toInt()

    repeat(T) {
        val st = StringTokenizer(br.readLine())
        val H = st.nextToken().toInt()
        val W = st.nextToken().toInt()
        val N = st.nextToken().toInt()

        val floor = if (N % H == 0) H else N % H
        val room = if (N % H == 0) N / H else N / H + 1

        println("${floor}${room.toString().padStart(2, '0')}")
    }

}

