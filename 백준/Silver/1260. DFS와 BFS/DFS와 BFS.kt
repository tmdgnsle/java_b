import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

lateinit var graph: Array<MutableList<Int>>
lateinit var dfsV: BooleanArray
lateinit var bfsV: BooleanArray
var sb = StringBuilder()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val v = st.nextToken().toInt()

    graph = Array(n + 1) { mutableListOf() }

    repeat(m){
        val st2 = StringTokenizer(br.readLine())
        val a = st2.nextToken().toInt()
        val b = st2.nextToken().toInt()
        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..n){
        graph[i].sort()
    }

    dfsV = BooleanArray(n+1)
    bfsV = BooleanArray(n+1)

    dfs(v)
    sb.append("\n")
    bfs(v)

    println(sb)


}

fun dfs(start: Int){
    dfsV[start] = true
    sb.append(start).append(" ")
    for(next in graph[start]){
        if(!dfsV[next]){
            dfs(next)
        }
    }
}

fun bfs(start: Int){
    val queue = LinkedList<Int>()
    bfsV[start] = true
    queue.offer(start)

    while(queue.isNotEmpty()){
        val cur = queue.poll()
        sb.append(cur).append(" ")
        for(next in graph[cur]){
            if(!bfsV[next]){
                bfsV[next] = true
                queue.offer(next)
            }
        }
    }
}