import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val used = BooleanArray(26)
    val sb = StringBuilder()

    repeat(n) {
        val line = br.readLine()
        var idx = -1

        val st = StringTokenizer(line)
        var pos = 0
        while (st.hasMoreTokens()) {
            val word = st.nextToken()

            while (pos < line.length && line[pos] == ' ') pos++

            val alpha = line[pos].lowercaseChar() - 'a'
            if (!used[alpha]) {
                used[alpha] = true
                idx = pos
                break
            }

            pos += word.length
        }

        if (idx == -1) {
            for (i in line.indices) {
                if (line[i].isLetter()) {
                    val alpha = line[i].lowercaseChar() - 'a'
                    if (!used[alpha]) {
                        used[alpha] = true
                        idx = i
                        break
                    }
                }
            }
        }

        if (idx == -1) {
            sb.append(line).append("\n")
        } else {
            sb.append(line.substring(0, idx))
                .append('[')
                .append(line[idx])
                .append(']')
                .append(line.substring(idx + 1))
                .append("\n")
        }


    }
    print(sb)
}
