enum class Calendar(val month: Int, val Days: Int) {
    JANUARY(1, 31), FEBRUARY(2, 28), MARCH(3, 31), APRIL(4, 30), MAY(5, 31), JUNE(6, 30), JULY(7, 31), AUGUST(
        8,
        31
    ),
    SEPTEMBER(9, 30), OCTOBER(10, 31), NOVEMBER(11, 30), DECEMBER(12, 31)
}

fun main() {
    val (month, day) = readln().split(" ").map { it.toInt() }
    val currentMonth = Calendar.entries.map { it.month == month }.indexOf(true)
    var totalDays = day
    for (i in 0..<currentMonth) {
        totalDays += Calendar.entries[i].Days
    }

    when (totalDays % 7) {
        0 -> println("SUN")
        1 -> println("MON")
        2 -> println("TUE")
        3 -> println("WED")
        4 -> println("THU")
        5 -> println("FRI")
        6 -> println("SAT")
    }
}
