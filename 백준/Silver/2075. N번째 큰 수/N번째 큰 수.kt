import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val pq = PriorityQueue<Int>()
    
    repeat(N){
        val st = StringTokenizer(br.readLine())
        repeat(N){
            val num = st.nextToken().toInt()
            if(pq.size < N){
                pq.offer(num)
            }else{
                if(pq.peek() < num){
                    pq.poll()
                    pq.offer(num)
                }
            }
        }
    }
    
    println(pq.peek())
}