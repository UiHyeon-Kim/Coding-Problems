fun main() {
    val imaginedTips = mutableListOf<Int>()
    var totalTip = 0L
    repeat(readln().toInt()) {
        imaginedTips.add(readln().toInt())
    }

    imaginedTips.sortDescending()
    imaginedTips.forEachIndexed { index, tip ->
        var temporary = tip - ((index + 1) - 1)
        if (temporary < 0) temporary = 0
        totalTip += temporary
    }

    println(totalTip)
}
