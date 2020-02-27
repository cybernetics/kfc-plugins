package com.github.turansky.kfc.gradle.plugin

internal fun defaultOutputConfiguration(): String {
    // language=JavaScript
    return """
            config.output = config.output || {}
            config.output.libraryTarget = 'umd'
            delete config.output.library
    """.trimIndent()
}

internal fun outputConfiguration(path: String): String {
    val libraryExport = path
        .split(".")
        .map { "'$it'" }
        .joinToString(", ")

    // language=JavaScript
    return """
            config.output = config.output || {}
            config.output.libraryTarget = 'umd'
            config.output.libraryExport = [$libraryExport]
            delete config.output.library
    """.trimIndent()
}
