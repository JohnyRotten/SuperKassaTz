import java.util.Optional

object ArrayExtensions {
    tailrec fun <T, U, H> List<T>.merge(list: List<U>, selector: (T, U) -> H) : List<H> =
        when {
            this.isNotEmpty() && list.isNotEmpty() -> listOf(selector(this.first(), list.first())) + this.drop(1).toList().merge(list.drop(1).toList(), selector)
            else -> listOf()
        }
}