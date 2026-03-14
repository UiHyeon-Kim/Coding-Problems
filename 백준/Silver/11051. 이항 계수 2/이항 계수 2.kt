import java.util.StringTokenizer
import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()){
    val st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val dp = Array(n + 1) { Array(n + 1) { BigInteger.ZERO } }

    for (i in 1..n) {
        for (j in 0..i) {
            if (j == 0 || j == i) {
                dp[i][j] = BigInteger.ONE
            } else {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % BigInteger.valueOf(10007)
            }
        }
    }

    println(dp[n][k])
}