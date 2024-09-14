fun main() {
    val str = readln()
    var alpa = Array(26) { -1 }
    var index = 0

    for (i in str.indices){
        index = str[i] - 'a'

        if (alpa[index] == -1) alpa[index] = i
    }

    repeat(alpa.size) {
        print("${alpa[it]} ")
    }
}