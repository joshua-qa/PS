import java.io.BufferedReader
import java.io.InputStreamReader

var visit = BooleanArray(101)
var result = 0
val graph: MutableList<MutableList<Int>> = mutableListOf()
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var n = readLine().toInt()
    var m = readLine().toInt()

    for (i in 0..n) {
        graph.add(mutableListOf())
    }

    for (i in 0 until m) {
        var tmp = readLine().split(" ")
        var x = tmp[0].toInt()
        var y = tmp[1].toInt()

        graph.get(x).add(y)
        graph.get(y).add(x)
    }

    dfs(1)

    print(result-1)
}

fun dfs(n: Int) {
    if (visit[n]) {
        return
    }

    visit[n] = true
    result++

    graph.get(n).forEach {
        dfs(it)
    }
}