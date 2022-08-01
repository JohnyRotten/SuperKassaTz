import org.junit.jupiter.api.Test

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

        val combinator = SimpleCombinator()
        val result = combinator.combine(inputData)

        isSameLists(expectedData, result)
    }

    private fun <T> isSameLists(expectedData: List<List<T>>, result: List<List<T>>) : Unit {

    }
}