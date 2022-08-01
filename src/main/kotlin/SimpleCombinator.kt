class SimpleCombinator : Combinator {
    override fun combine(list: List<List<String?>>): List<List<String>> {
        val result = mutableListOf<List<String>?>()
        val set : MutableSet<List<String?>> = list.toMutableSet()
        set.add(listOf(null, null, null, null))

        while (set.isNotEmpty()) {
            val listFromSet = set.first()
            set.remove(listFromSet)

            set.forEach { l ->
                val mergeResult : List<String>? = mergeUnOptional(listFromSet, l, listOf())
                result.add(mergeResult)
            }
        }

        return result.filterNotNull()
    }

    companion object {
        private fun <T> mergeUnOptional(listA: List<T?>, listB: List<T?>, result: List<T>) : List<T>? =
            listA.firstOrNull().let { a ->
                listB.firstOrNull().let { b ->
                    when {
                        listA.isEmpty() && listB.isEmpty() -> result
                        a != null && b == null -> mergeUnOptional(listA.drop(1).toList(), listB.drop(1).toList(), result + a)
                        a == null && b != null -> mergeUnOptional(listA.drop(1).toList(), listB.drop(1).toList(), result + b)
                        else -> null
                    }
                }
            }
    }
}