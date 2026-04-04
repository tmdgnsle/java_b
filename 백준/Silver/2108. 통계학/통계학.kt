import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.round

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val arr = IntArray(n)
    val count = IntArray(8001)   // -4000 ~ 4000
    var sum = 0
    var min = 4001
    var max = -4001

    for (i in 0 until n) {
        val num = br.readLine().toInt()
        arr[i] = num
        sum += num
        count[num + 4000]++

        if (num < min) min = num
        if (num > max) max = num
    }

    arr.sort()

    // 1. 산술평균
    val avg = if (sum.toDouble() / n == -0.0) 0 else round(sum.toDouble() / n).toInt()

    // 2. 중앙값
    val median = arr[n / 2]

    // 3. 최빈값
    var maxFreq = 0
    for (i in count.indices) {
        if (count[i] > maxFreq) maxFreq = count[i]
    }

    val modes = mutableListOf<Int>()
    for (i in count.indices) {
        if (count[i] == maxFreq) {
            modes.add(i - 4000)
        }
    }

    val mode = if (modes.size > 1) modes[1] else modes[0]

    // 4. 범위
    val range = max - min

    val sb = StringBuilder()
    sb.append(avg).append('\n')
    sb.append(median).append('\n')
    sb.append(mode).append('\n')
    sb.append(range).append('\n')

    print(sb)
}