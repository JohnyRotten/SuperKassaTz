object ArrayExtensions {
    tailrec fun <T> List<T>.merge(array: List<T>, selector: (T, T) -> T) : List<T> =
        when {
            this.isNotEmpty() && array.isNotEmpty() -> listOf(selector(this.first(), array.first())) + this.drop(1).toList().merge(array.drop(1).toList(), selector)
            else -> listOf()
        }
}