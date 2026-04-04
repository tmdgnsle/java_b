import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val board = Array(n) { br.readLine() }

    var answer = Int.MAX_VALUE

    for (i in 0 until n-7){
        for(j in 0 until m - 7){
            answer = min(answer, check(board, i, j))
        }
    }

    println(answer)
}

fun check(board: Array<String>, x:Int, y:Int): Int {
    var countW = 0
    var countB = 0

    for(i in 0 until 8){
        for(j in 0 until 8){
            val current = board[x + i][y+j]

            if((i+j) % 2 == 0){
                if(current != 'W') countW++
                if(current != 'B') countB++
            }else {
                if(current != 'B') countW++
                if(current != 'W') countB++
            }
        }
    }

    return min(countW, countB)
}

