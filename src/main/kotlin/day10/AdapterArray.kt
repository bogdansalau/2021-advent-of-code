package day10

class AdapterArray(val input: List<Int>) {

    private val adapters = input.sorted()
    private val devicePower = input.sorted().takeLast(1)[0] + 3

    fun solvePart1(): Int {
        val diff1 = computeDiffArray().filter { it == 1 }.count()
        val diff3 = computeDiffArray().filter { it == 3 }.count()
        return diff1 * diff3 + diff1
    }

    fun solvePart2(): Long {
        val tree = computeTree(0)
        return countLeafs(tree)
    }

    private fun computeDiffArray(): MutableList<Int> {
        val diffArray = mutableListOf<Int>()
        input
            .sorted()
            .fold(0) { a, b ->
                diffArray.add(b - a)
                b
            }
        return diffArray
    }

    private val nodeCache = mutableMapOf<Int, Node>()
    private val leafCache = mutableMapOf<Int, Long>()

    private fun computeTree(n: Int): Node {
        println("Creating node $n")
        var newNode = nodeCache[n]
        if (newNode != null) {
            return newNode
        } else {
            newNode = Node(n, mutableListOf())
            val children = possibleMoves(n)

            for (i in children.indices) {
                val newChild = computeTree(children[i])
                newNode.children.add(newChild)
            }
            nodeCache[n] = newNode
            return newNode
        }
    }

    private fun countLeafs(root: Node): Long {
        if (root.n == devicePower) return 1
        else {
            val nrLeafs = leafCache[root.n]
            if(nrLeafs != null) {
                return nrLeafs
            } else {
                var childrenLeafs = 0L
                root.children.forEach {
                    childrenLeafs += countLeafs(it)
                }
                leafCache[root.n] = childrenLeafs
                return childrenLeafs
            }
        }
    }

    private fun possibleMoves(n: Int): List<Int> {
        val allAdapters = adapters.toMutableList()
        allAdapters.add(devicePower)
        return allAdapters.filter { it > n }.take(3).filter { it - 3 <= n }
    }

    data class Node(val n: Int, val children: MutableList<Node>)


}
