data class Quartet(val first: String?, val second: String?, val third: String?, val fourth: String?) {
    fun isFull() : Boolean = !(first == null || second == null || third == null || fourth == null)

    fun tryCompose(another: Quartet) : Quartet? = if (
        (first != null && another.first != null) ||
        (second != null && another.second != null) ||
        (third != null && another.third != null) ||
        (fourth != null && another.fourth != null)
    ) null
    else Quartet(first ?: another.first, second ?: another.second, third ?: another.third, fourth ?: another.fourth)
}