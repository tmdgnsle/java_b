import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val a = br.readLine()
    val b = br.readLine()
    val c = br.readLine()

    val next = when {
        a[0].isDigit() -> a.toInt() + 3
        b[0].isDigit() -> b.toInt() + 2
        else -> c.toInt() + 1
    }

    when {
        next % 15 == 0 -> println("FizzBuzz")
        next % 3 == 0 -> println("Fizz")
        next % 5 == 0 -> println("Buzz")
        else -> println(next)
    }
}