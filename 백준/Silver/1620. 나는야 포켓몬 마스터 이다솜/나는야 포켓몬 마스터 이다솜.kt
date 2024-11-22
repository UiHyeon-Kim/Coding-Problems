fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val pokeDictionary = mutableMapOf<Int, String>()
    val reverseDictionary = mutableMapOf<String, Int>()

    for (index in 1..m) {
        val pokemon = readln()
        pokeDictionary.put(index, pokemon)
        reverseDictionary.put(pokemon, index)
    }
    for (index in 1..n) {
        val problem = readln()
        if (problem[0] in '0'..'9') {
            println(pokeDictionary[problem.toInt()])
        } else {
            println(reverseDictionary[problem])
        }
    }
}