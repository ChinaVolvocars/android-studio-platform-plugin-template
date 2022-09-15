package other

import java.util.*

fun String.asKt() = "${this.capitalize()}.kt"

val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
fun String.toSnakeCase() = camelRegex.replace(this) { "_${it.value}" }.lowercase(Locale.getDefault())