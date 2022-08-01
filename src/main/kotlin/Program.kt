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

fun getInput(inputFilePath: String): Result<List<List<String?>>> {
    val file = File(inputFilePath)
    if (!file.exists()) {
        return Result.failure(ProgramArgumentException.inputFileNotFound(inputFilePath))
    }
    val json = file.readText()
    return Result.success(Json.decodeFromString(json))
}

fun writeResult(result: List<List<String>>, outputFilePath: String?) {
    val json = Json.encodeToString(result)
    if (outputFilePath != null) {
        File(outputFilePath).writeText(json)
        println("Result was saved to: '$outputFilePath'.")
    }
    else {
        println(json)
    }
}
