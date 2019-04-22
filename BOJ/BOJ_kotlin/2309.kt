import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val nums = Array(9) { readLine().toInt() }
    val sb = StringBuilder()
    val total = nums.sum()

    first@for(i in 0..7) {
        for(j in i+1..8) {
            if(total-nums[i]-nums[j] == 100) {
                nums.filterIndexed { index, _ -> index != i && index != j }.sorted().forEach { sb.append(it).append("\n") }
                break@first
            }
        }
    }

    print(sb)
}