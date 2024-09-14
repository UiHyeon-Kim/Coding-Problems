import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = br.readLine().toInt()
    val nums = IntArray(10001)

    for (i in 0 until N) {
        nums[br.readLine().toInt()]++
    }
    br.close()

    for (i in nums.indices){
        bw.write("$i\n".repeat(nums[i]))
    }
    bw.flush()
    bw.close()
}