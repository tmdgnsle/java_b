import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val A = br.readLine()
    val B = br.readLine()
    val C = br.readLine()

    println(A.toInt() + B.toInt() - C.toInt())
    println((A + B).toInt() - C.toInt())


}

