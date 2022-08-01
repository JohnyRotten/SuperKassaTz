data class ProgramArguments(val inputFilePath: String, val outputFilePath: String?) {
    companion object {
        fun create(args: Array<String>) : Result<ProgramArguments> {
            if (args.isEmpty()) {
                return Result.failure(ProgramArgumentException.inputFilePathNotSet())
            }
            val inputFilePath: String = args[0]
            val outputFilePath: String? = args.elementAtOrNull(1)

            return Result.success(ProgramArguments(inputFilePath, outputFilePath))
        }
    }
}