import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val arr = IntArray(n)

    for(i in arr.indices){
        arr[i] = br.readLine().toInt()
    }
    arr.sortDescending()
    var money = k
    var count = 0
    for(m in arr){
        if(money < m) continue

        count += money / m
        money %= m

        if(money == 0) break
    }

    println(count)
}