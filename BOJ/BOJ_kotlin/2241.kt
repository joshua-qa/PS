import java.util.*;

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()

    val sb = StringBuilder()
    for(i in n downTo 0) {
        for(j in 0 until n-i) {
            sb.append(" ")
        }
        for(k in 0 until i) {
            sb.append("*")
        }
        if(i != 0) sb.append("\n")
    }
    print(sb)
}