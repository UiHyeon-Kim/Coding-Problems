import java.util.*

val br = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){

     val map = TreeMap<String, Double>()
     var size=0
     while(true){
         val input = br.readLine() ?: break
         map[input] = map.getOrDefault(input,0.0)+1
         size++
     }

     map.forEach{
         write("${it.key} ${String.format("%.4f",it.value/size*100)}\n")
     }

     close()
}