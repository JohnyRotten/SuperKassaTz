import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main(args: Array<String>) {
    try {
        val arguments = ProgramArguments.create(args).getOrThrow()
        val input = getInput(arguments.inputFilePath).getOrThrow()
        val result = Combinator().combine(input)
        writeResult(result, arguments.outputFilePath)
    } catch (e: java.lang.Exception) {
        println(e)
    }
}

fun getInput(inputFilePath: String): Result<List<Quartet>> {
    val file = File(inputFilePath)
    if (!file.exists()) {
        return Result.failure(ProgramArgumentException.inputFileNotFound(inputFilePath))
    }
    val json = file.readText()
    return Result.success(
        Json.decodeFromString<List<List<String?>>>(json)
            .map { Quartet(it.getOrNull(0), it.getOrNull(1), it.getOrNull(2), it.getOrNull(3)) })
}

fun writeResult(result: List<Quartet>, outputFilePath: String?) {
    val json = Json.encodeToString(result.map { listOf(it.first, it.second, it.third, it.fourth) })
    if (outputFilePath != null) {
        File(outputFilePath).writeText(json)
        println("Result was saved to: '$outputFilePath'.")
    }
    else {
        println(json)
    }
}
