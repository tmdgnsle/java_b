class Solution {
    private lateinit var map: HashMap<String, Int>
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val answer = mutableListOf<String>()
        
        for(len in course){
            map = HashMap()
            for(order in orders){
                val arr = order.toCharArray().sorted().toCharArray()
                comb(arr, 0, 0, len, StringBuilder())
            }
            
            var max = 0
            for(count in map.values){
                if(count >= 2){
                        max = maxOf(max, count)
                }
            }
            
            for((key, value) in map){
                if(value == max && max >= 2){
                    answer.add(key)
                }
            }
            
        }
        
        answer.sort()
        return answer.toTypedArray()
    }
    
    private fun comb(
    arr: CharArray,
        idx: Int,
        depth: Int,
        target: Int,
        sb: StringBuilder
    ){
        if(depth == target){
            val menu = sb.toString()
            map[menu] = map.getOrDefault(menu, 0) + 1
            return
        }
        
        for(i in idx until arr.size){
            sb.append(arr[i])
            comb(arr, i + 1, depth + 1, target, sb)
            sb.deleteCharAt(sb.length - 1)
        }
        
    }
    
}