import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val nums = BooleanArray(10000)

    for (i in 1 until 10000) {
        if (nums[i]) {
            continue
        }
        bw.write("$i\n")
        var j = i
        while (j < 10000) {
            var k = j
            while (j != 0) {
                k += j % 10
                j /= 10
            }
            if (k < 10000) {
                nums[k] = true
            }
            j = k
        }
    }

    bw.flush()
}