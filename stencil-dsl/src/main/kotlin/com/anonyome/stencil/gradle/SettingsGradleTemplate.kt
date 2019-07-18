@file:Suppress("FunctionName")

package com.anonyome.stencil.gradle

//language=kotlin
fun SettingsGradleTemplate(vararg projectNames: String) =
"""
${projectNames.joinToString("\n") { "include(\"$it\")" }}
"""