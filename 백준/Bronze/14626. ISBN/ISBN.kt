import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val isbn = br.readLine().toCharArray()
    var idx = 0
    var total = 0
    for (i in 0..12){
        if(isbn[i] == '*'){
            idx = i
        }else {
            if(i % 2 == 0){
                total += (isbn[i] - '0')
            }else {
                total += 3 * (isbn[i] - '0')
            }
        }
    }

    var answer = 0
    if(idx % 2 == 0) answer = 10 - (total % 10)
    else {
        val find = 10 - (total % 10)
        for(i in 0 .. 9){
            val num = (3 * i) % 10
            if(find == num){
                answer = i
                break
            }
        }
    }


    println(answer)
}