class ProgramArgumentException(message: String): Exception("$message${System.lineSeparator()}Use program: Program <inputFilePath> [<outputFilePath>]") {
    companion object {
        fun inputFilePathNotSet(): ProgramArgumentException = ProgramArgumentException("Input file path not set.")
        fun inputFileNotFound(filePath: String) = ProgramArgumentException("Input file '$filePath' not found.")
    }
}