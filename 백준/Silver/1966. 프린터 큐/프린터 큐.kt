import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Document(val index: Int, val priority: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tc = br.readLine().toInt()

    val sb = StringBuilder()

    repeat(tc) {
        val st = StringTokenizer(br.readLine())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val st2 = StringTokenizer(br.readLine())
        val queue = ArrayDeque<Document>()

        for (i in 0 until n) {
            val priority = st2.nextToken().toInt()
            queue.addLast(Document(i, priority))
        }

        var count = 0

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            var isMax = true
            for (doc in queue) {
                if (current.priority < doc.priority) {
                    isMax = false
                    break
                }
            }

            if (isMax) {
                count++
                if (current.index == m) { // 궁금한 문서라면
                    sb.append(count).append('\n')
                    break
                }
            } else {
                queue.addLast(current)
            }
        }

    }
    println(sb)


}


