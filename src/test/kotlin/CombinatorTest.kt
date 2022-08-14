import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CombinatorTest {

    @Test
    fun `simple combine`() {
        val inputData : List<Quartet> = listOf(
            Quartet("a1",   "a2",   "a3",   "a4"),
            Quartet("b1",   null,   null,   "b4"),
            Quartet(null,   "c2",   "c3",   null),
            Quartet("d1",   null,   null,   "d4"),
            Quartet(null,   "e2",   "e3",   null),
            Quartet(null,   "f2",   "f3",   "f4"),
            Quartet("h1",   null ,  null,   null),
            Quartet("g1",   null ,  null,   null)
        )
        val expectedData : List<Quartet> = listOf(
            Quartet("g1", "f2", "f3", "f4"),
            Quartet("h1", "f2", "f3", "f4"),
            Quartet("d1", "e2", "e3", "d4"),
            Quartet("d1", "c2", "c3", "d4"),
            Quartet("b1", "e2", "e3", "b4"),
            Quartet("b1", "c2", "c3", "b4"),
            Quartet("a1", "a2", "a3", "a4")
        )

        val combinator = Combinator()
        val result = combinator.combine(inputData)

        isSameLists(expectedData, result)
    }

    @Test
    fun `multiple combine`() {
        val inputData = listOf(
            Quartet("a1", null, null, null),
            Quartet(null, "b2", null, "b4"),
            Quartet(null, null, "c3", null)
        )

        val expected = listOf(Quartet("a1",   "b2",   "c3",   "b4"))

        val combinator = Combinator()
        val result = combinator.combine(inputData)

        isSameLists(expected, result)
    }

    private fun isSameLists(expected: List<Quartet>, result: List<Quartet>) {
        assertEquals(expected.count(), result.count(), "Expected list count (${expected.count()}) is not equals result list count (${result.count()}).")
        expected.forEach { list ->
            assert(result.any { list == it })
        }
    }
}