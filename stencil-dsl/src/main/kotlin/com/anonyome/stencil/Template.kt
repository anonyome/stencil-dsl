package com.anonyome.stencil

import com.anonyome.stencil.Template.Dir
import com.anonyome.stencil.TemplateException.RootDoesntExist
import com.anonyome.stencil.TemplateException.RootIsNotDirectory
import java.io.File

//todo - rename to Stencil
sealed class Template {
    abstract val name: String

    data class File(
        override val name: String,
        val contents: String?
    ): Template()

    data class Dir(
        override val name: String,
        val children: List<Template>
    ): Template()
}

sealed class TemplateException(msg: String, cause: Throwable? = null): RuntimeException(msg, cause) {
    class RootDoesntExist : TemplateException("The provided root directory doesn't exist")
    class RootIsNotDirectory : TemplateException("The provided root is not a directory")
}

/**
 * iterate over the provides this [Template] creating all files and directories in the tree
 */
infix fun Template.createIn(inDir: File) {
    when {
        !inDir.exists() -> throw RootDoesntExist()
        !inDir.isDirectory -> throw RootIsNotDirectory()
    }

    val file = File(inDir, name)
    when (this) {
        is Dir -> {
            file.mkdir()
            children.forEach { it.createIn(file) }
        }
        is Template.File -> file.apply {
            createNewFile()
            contents?.let(::writeText)
        }
    }
}