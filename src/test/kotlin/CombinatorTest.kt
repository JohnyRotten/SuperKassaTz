import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CombinatorTest {

    @Test
    fun combine() {
        val inputData : List<List<String?>> = listOf(
            listOf("a1",   "a2",   "a3",   "a4"),
            listOf("b1",   null,   null,   "b4"),
            listOf(null,   "c2",   "c3",   null),
            listOf("d1",   null,   null,   "d4"),
            listOf(null,   "e2",   "e3",   null),
            listOf(null,   "f2",   "f3",   "f4"),
            listOf("h1",   null ,  null,   null),
            listOf("g1",   null ,  null,   null)
        )
        val expectedData : List<List<String>> = listOf(
            listOf("g1", "f2", "f3", "f4"),
            listOf("h1", "f2", "f3", "f4"),
            listOf("d1", "e2", "e3", "d4"),
            listOf("d1", "c2", "c3", "d4"),
            listOf("b1", "e2", "e3", "b4"),
            listOf("b1", "c2", "c3", "b4"),
            listOf("a1", "a2", "a3", "a4")
        )

        val combinator = Combinator()
        val result = combinator.combine(inputData)

        isSameLists(expectedData, result)
    }

    private fun <T> isSameLists(expected: List<List<T>>, result: List<List<T>>) {
        assertEquals(expected.count(), result.count(), "Expected list count (${expected.count()}) is not equals result list count (${result.count()}).")
        expected.forEach { list ->
            assert(result.any { isSameList(list, it) })
        }
    }

    private fun <T> isSameList(expected: List<T>, result: List<T>) : Boolean = when {
        expected.isNotEmpty() && result.isNotEmpty() -> expected.first() == result.first() && isSameList(expected.drop(1).toList(), result.drop(1).toList())
        expected.isEmpty() && result.isEmpty() -> true
        else -> false
    }
}