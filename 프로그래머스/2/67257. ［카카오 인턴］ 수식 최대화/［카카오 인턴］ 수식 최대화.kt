import kotlin.math.abs

class Solution {
    fun solution(expression: String): Long {
        val opsRegex = Regex("[+\\-*]") 
        val numRegex = Regex("\\d+")
        
        val nums = numRegex.findAll(expression).map { it.value.toLong() }
        val ops = opsRegex.findAll(expression).map { it.value }.toList()
        val result = mutableListOf<Long>()
        var max = 0L
        
        val opsSequence = getOpsSequence(ops.distinct())
        
        // 전체 연산자 순서 계산
        for (opse in opsSequence) {
            val sequence = opse.split(" ")
            val currentNums = nums.toMutableList()
            val currentOps = ops.toMutableList()
            
            // 현재 순서의 연산자를 순서대로 계산
            for (seq in sequence) {
                var idx = 0
                // 연산 인덱스 관리
                while (idx < currentOps.size) {
                    // 같은 연산자면 계산, 다르면 다음 인덱스
                    if (currentOps[idx] == seq) {
                        val res = when(seq) {
                            "+" -> currentNums[idx] + currentNums[idx + 1] 
                            "-" -> currentNums[idx] - currentNums[idx + 1] 
                            else -> currentNums[idx] * currentNums[idx + 1]
                        }
                        currentNums[idx] = res
                        currentNums.removeAt(idx + 1)
                        currentOps.removeAt(idx)
                    } else {
                        idx++
                    }
                }
            }
            max = max.coerceAtLeast(abs(currentNums.first()))
        }
        
        return max
    }
        
    private fun getOpsSequence(ops: List<String>): List<String> {
        val size = ops.size
        val subset = mutableListOf<String>()
        val visited = BooleanArray(size)
        val sb = StringBuilder()
        
        fun backtrack(depth: Int) {
            if (depth == size) {
                for (i in subset) sb.append(i).append(' ')
                sb.append("\n")
                return
            }
            
            for (i in 0 until size) {
                if (visited[i]) continue
                visited[i] = true
                subset.add(ops[i])
                backtrack(depth + 1)
                subset.removeLast()
                visited[i] = false
            }
        }
        backtrack(0)
        return sb.split("\n")
    }
}