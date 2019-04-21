import java.util.*;

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val sb = StringBuilder()
    var count = IntArray(2000001)
    var nums = IntArray(n) {
        nextInt()
    }

    for(i in nums) {
        count[i+1000000]++
    }

    for(i in count.indices) {
        if(count[i] != 0) {
            sb.append("${i-1000000}".repeat(count[i])).append("\n")
        }
    }

    print(sb)
}