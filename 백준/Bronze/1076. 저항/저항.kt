fun main() {
    val color = mutableMapOf(
        "black" to "0",
        "brown" to "1",
        "red" to "2",
        "orange" to "3",
        "yellow" to "4",
        "green" to "5",
        "blue" to "6",
        "violet" to "7",
        "grey" to "8",
        "white" to "9"
    )
    val value = mutableMapOf(
        "black" to "",
        "brown" to "0",
        "red" to "00",
        "orange" to "000",
        "yellow" to "0000",
        "green" to "00000",
        "blue" to "000000",
        "violet" to "0000000",
        "grey" to "00000000",
        "white" to "000000000"
    )

    val one = readln()
    val two = readln()
    val three = readln()

    if (one == "black" && two == "black") print(0)
    else if (one == "black") println(color[two]+value[three])
    else print(color[one]+color[two]+value[three])
}