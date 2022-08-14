class Combinator {
    fun combine(list: List<Quartet>): List<Quartet> {
        val result = mutableSetOf<Quartet>()
        val set = list.toMutableSet()

        while (set.isNotEmpty()) {
            val quartet = set.first()
            set.remove(quartet)

            if (quartet.isFull()) {
                result.add(quartet)
            } else {
                set.mapNotNull { it.tryCompose(quartet) }
                    .forEach { (if (it.isFull()) result else set).add(it) }
            }
        }

        return result.toList()
    }
}